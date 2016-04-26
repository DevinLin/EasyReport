package com.jd.coo.system.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by linlingyue on 2016/4/21.
 */
public class Task implements Serializable {

    private Long id;
    private String project_name;
    private Integer task_type;
    private String summary;
    private Date online_time;
    private Date testing_starttime;
    private Date testing_endtime;
    private String productMgr;
    private String tester;
    private Integer lastWeekSchedule;
    private Integer currentSchedule;
    private String reason;
    private String risk;
    private Integer status;
    private Integer isDelete;
    private Date create_time ;
    private String create_user ;
    private String update_user ;
    private Date update_time ;
    private String category ;
    private Integer expectedSchedule ;
    private Integer weekNo ;

    public Integer getLastWeekSchedule() {
        return lastWeekSchedule;
    }

    public void setLastWeekSchedule(Integer lastWeekSchedule) {
        this.lastWeekSchedule = lastWeekSchedule;
    }

    public Integer getCurrentSchedule() {
        return currentSchedule;
    }

    public void setCurrentSchedule(Integer currentSchedule) {
        this.currentSchedule = currentSchedule;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getExpectedSchedule() {
        return expectedSchedule;
    }

    public void setExpectedSchedule(Integer expectedSchedule) {
        this.expectedSchedule = expectedSchedule;
    }

    public Integer getWeekNo() {
        return weekNo;
    }

    public void setWeekNo(Integer weekNo) {
        this.weekNo = weekNo;
    }




    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public String getCreate_user() {
        return create_user;
    }

    public void setCreate_user(String create_user) {
        this.create_user = create_user;
    }

    public String getUpdate_user() {
        return update_user;
    }

    public void setUpdate_user(String update_user) {
        this.update_user = update_user;
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProject_name() {
        return project_name;
    }

    public void setProject_name(String project_name) {
        this.project_name = project_name;
    }

    public Integer getTask_type() {
        return task_type;
    }

    public void setTask_type(Integer task_type) {
        this.task_type = task_type;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Date getOnline_time() {
        return online_time;
    }

    public void setOnline_time(Date online_time) {
        this.online_time = online_time;
    }

    public Date getTesting_starttime() {
        return testing_starttime;
    }

    public void setTesting_starttime(Date testing_starttime) {
        this.testing_starttime = testing_starttime;
    }

    public Date getTesting_endtime() {
        return testing_endtime;
    }

    public void setTesting_endtime(Date testing_endtime) {
        this.testing_endtime = testing_endtime;
    }

    public String getProductMgr() {
        return productMgr;
    }

    public void setProductMgr(String productMgr) {
        this.productMgr = productMgr;
    }

    public String getTester() {
        return tester;
    }

    public void setTester(String tester) {
        this.tester = tester;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getRisk() {
        return risk;
    }

    public void setRisk(String risk) {
        this.risk = risk;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }
}
