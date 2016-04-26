package com.jd.coo.common;

import java.util.Calendar;

/**
 * Created by linlingyue on 2016/4/22.
 */
public class DateUtils {

    /**
     * 获取当前天是全年的第几周
     * @return
     */
    public static int getWeekNoForCurrentDay(){
        Calendar c=Calendar.getInstance();
        return c.get(Calendar.WEEK_OF_YEAR);
    }

}
