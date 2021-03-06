package com.jd.coo.common;
/**
* 此拦截器可实现数据列表的排序及物理分页
* <br>User: yanghongfeng
* <br>DateTime: Sep 18, 2012 9:55:09 AM
* <br>Version 1.0
*/

import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.builder.xml.dynamic.ForEachSqlNode;
import org.apache.ibatis.executor.parameter.DefaultParameterHandler;
import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.*;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.property.PropertyTokenizer;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.RowBounds;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;


@Intercepts({ @Signature(type = StatementHandler.class, method = "prepare", args = { Connection.class }) })
public class PaginationInterceptor implements Interceptor {

	 private static final Logger log = Logger.getLogger(PaginationInterceptor.class);

	/* (non-Javadoc)  
    * @see org.apache.ibatis.plugin.Interceptor#intercept(org.apache.ibatis.plugin.Invocation)
	 */
	public Object intercept(Invocation invocation) throws Throwable {
		StatementHandler statementHandler = (StatementHandler) invocation.getTarget();
		MetaObject metaStatementHandler = MetaObject.forObject(statementHandler);
		RowBounds rowBounds = (RowBounds) metaStatementHandler.getValue("delegate.rowBounds");
		String originalSql = (String) metaStatementHandler.getValue("delegate.boundSql.sql");

		DefaultParameterHandler defaultParameterHandler = (DefaultParameterHandler) metaStatementHandler.getValue("delegate.parameterHandler");
		
		Page page = null;
		Object object = defaultParameterHandler.getParameterObject();
		if(object instanceof HashMap){
			Map parameterObject = (Map)object;
			if(parameterObject.containsKey("page")){
				 page = (Page)parameterObject.get("page");
			}
		}else{
			if(object  instanceof Page){
				page = (Page)object;
			}
		}
		
		if(page==null){
			return invocation.proceed();
		}
		Configuration configuration = (Configuration) metaStatementHandler.getValue("delegate.configuration");

		Dialect.Type databaseType = null;
		try {
			databaseType = Dialect.Type.valueOf(configuration.getVariables().getProperty("dialect").toUpperCase());
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (databaseType == null) {
			throw new RuntimeException("the value of the dialect property in configuration.xml is not defined : "
					+ configuration.getVariables().getProperty("dialect"));
		}
		Dialect dialect = null;
		switch (databaseType) {
			case ORACLE:
				dialect = new OracleDialect();
				break;
			case MYSQL:
				dialect = new MySqlDialect();
				break;

		}
	//	String originalSql = (String) metaStatementHandler.getValue("delegate.boundSql.sql");
		Connection connection = (Connection) invocation.getArgs()[0];
		 BoundSql boundSql = (BoundSql) statementHandler.getBoundSql();
		 
		 
		 MappedStatement mappedStatement = (MappedStatement)   
	     metaStatementHandler.getValue("delegate.mappedStatement"); 
		
		String countSql = dialect.getCountString(originalSql);

		
		if (page.getOrder() != null) {
				@SuppressWarnings("unchecked")
				LinkedHashMap<String, String> sorts = new LinkedHashMap<String,String>();
				sorts.put( getCoumlsByPropertyName(mappedStatement,page.getSort()), page.getOrder());
				//使用自定义排序
				originalSql = dialect.getOrderString(originalSql, sorts);
		}else if(StringUtils.isNotEmpty(page.getSord()) ){
			@SuppressWarnings("unchecked")
			LinkedHashMap<String, String> sorts = new LinkedHashMap<String,String>();
			sorts.put( getCoumlsByPropertyName(mappedStatement,page.getSidx()), page.getSord());
			//使用自定义排序
			originalSql = dialect.getOrderString(originalSql, sorts);
		}
		//使用自定义的物理分页方法。若不使用自定义分页（此处注释该方法），则使用mybatis的逻辑分页。物理分页效率高于逻辑分页
		originalSql = dialect.getLimitString(originalSql, (page.getPage()-1)*page.getPageSize(), page.getPageSize());
		
		//originalSql = null;
		//如果使用自定义的物理分页法，请打开下边的两个注释。
		metaStatementHandler.setValue("delegate.rowBounds.offset", RowBounds.NO_ROW_OFFSET);
		metaStatementHandler.setValue("delegate.rowBounds.limit", RowBounds.NO_ROW_LIMIT);
		
		metaStatementHandler.setValue("delegate.boundSql.sql", originalSql);
		 setPageParameter(connection, countSql, mappedStatement,  
			         boundSql,  page);
		
		log.debug("生成分页SQL : " + boundSql.getSql());
		return invocation.proceed();
	}

	/**  
	* @Description:  
	* @author jianglongfei
	* @date 2014-6-12 下午05:01:38 
	* @param mappedStatement
	* @param sortColName
	* @return 
	*/
	private String getCoumlsByPropertyName(MappedStatement mappedStatement,
			String sortColName) {
		 ResultMap resultMaps = (ResultMap)mappedStatement.getResultMaps().get(0);
		 List<ResultMapping> resultMappings = (List<ResultMapping>)resultMaps.getPropertyResultMappings();
		 for(ResultMapping mapping:resultMappings){
			 if(sortColName.equals(mapping.getProperty())){
				 return mapping.getColumn();
			 }
		 }
		 return "id";
	}

	/** 
	 * 从数据库里查询总的记录数并计算总页数，回写进分页参数<code>PageParameter</code>,这样调用  
	 * 者就可用通过 分页参数<code>PageParameter</code>获得相关信息。 
	 *  
	 * @param connection
	 * @param mappedStatement 
	 * @param boundSql 
	 * @param page 
	 */  
	private void setPageParameter( Connection connection, String countSql,MappedStatement mappedStatement,  
	        BoundSql boundSql, Page page) {  
	    // 记录总记录数  
	    PreparedStatement countStmt = null;  
	    ResultSet rs = null;  
	    try {  
	        countStmt = connection.prepareStatement(countSql);  
	        
	        List<ParameterMapping> parameterMappings = boundSql.getParameterMappings();
	        
	        BoundSql countBS = new BoundSql(mappedStatement.getConfiguration(), countSql,  
	        		parameterMappings, boundSql.getParameterObject());  
	        
	        if(parameterMappings!=null && parameterMappings.size()>0){
	        	for (ParameterMapping parameterMapping:parameterMappings) {
					 Object propertyValue = null;
		        	 String propertyName = parameterMapping.getProperty();
		        	 PropertyTokenizer prop = new PropertyTokenizer(propertyName);
		        	 if(boundSql.hasAdditionalParameter(propertyName)){
		        		 propertyValue =  boundSql.getAdditionalParameter(propertyName);
		        		 countBS.setAdditionalParameter(propertyName, propertyValue);
		        	 }else if(propertyName.startsWith(ForEachSqlNode.ITEM_PREFIX) && boundSql.hasAdditionalParameter(prop.getName())){
		        		 propertyValue =  boundSql.getAdditionalParameter(prop.getName());
		        		 countBS.setAdditionalParameter(propertyName, propertyValue);
		        	 }
				}
	        }
	        setParameters(countStmt, mappedStatement, countBS, boundSql.getParameterObject());  
	        rs = countStmt.executeQuery();  
	        int totalCount = 0;  
	        if (rs.next()) {  
	            totalCount = rs.getInt(1);  
	        }  
	        page.setTotal(totalCount);  
	    } catch (SQLException e) {  
	    	log.error("Ignore this exception", e);  
	    } finally {  
	        try {  
	            rs.close();  
	        } catch (SQLException e) {  
	        	log.error("Ignore this exception", e);  
	        }  
	        try {  
	            countStmt.close();  
	        } catch (SQLException e) {  
	        	log.error("Ignore this exception", e);  
	        }  
	    }  
	}  
	  
	/** 
	 * 对SQL参数(?)设值 
	 *  
	 * @param ps 
	 * @param mappedStatement 
	 * @param boundSql 
	 * @param parameterObject 
	 * @throws SQLException 
	 */  
	private void setParameters(PreparedStatement ps, MappedStatement mappedStatement, BoundSql boundSql,  
	        Object parameterObject) throws SQLException {  
	    ParameterHandler parameterHandler = new DefaultParameterHandler(mappedStatement, parameterObject, boundSql);  
	    parameterHandler.setParameters(ps);  
	}

	public Object plugin(Object target) {
		return Plugin.wrap(target, this);
	}

	public void setProperties(Properties properties) {

	}  


}