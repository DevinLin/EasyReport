package com.jd.coo.system.condition;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by linlingyue on 2016/4/21.
 */
public class TaskCondition implements Serializable{

    private String id;
    private String project_name;
    private String task_type;
    private String summary;
    private String online_time;
    private String testing_starttime;
    private String testing_endtime;
    private String productMgr;
    private String tester;
    private String lastWeekSchedule;
    private String currentSchedule;
    private String reason;
    private String risk;
    private String status;
    private String isDelete;
    private String create_time;
    private String create_user;
    private String update_user;
    private String update_time;
    private String category;
    private String expectedSchedule;
    private String weekNo;
    private String online_startTime;
    private String online_endTime;

    public String getOnline_endTime() {
        return online_endTime;
    }

    public void setOnline_endTime(String online_endTime) {
        this.online_endTime = online_endTime;
    }

    public String getOnline_startTime() {
        return online_startTime;
    }

    public void setOnline_startTime(String online_startTime) {
        this.online_startTime = online_startTime;
    }



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProject_name() {
        return project_name;
    }

    public void setProject_name(String project_name) {
        this.project_name = project_name;
    }

    public String getTask_type() {
        return task_type;
    }

    public void setTask_type(String task_type) {
        this.task_type = task_type;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getOnline_time() {
        return online_time;
    }

    public void setOnline_time(String online_time) {
        this.online_time = online_time;
    }

    public String getTesting_starttime() {
        return testing_starttime;
    }

    public void setTesting_starttime(String testing_starttime) {
        this.testing_starttime = testing_starttime;
    }

    public String getTesting_endtime() {
        return testing_endtime;
    }

    public void setTesting_endtime(String testing_endtime) {
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

    public String getLastWeekSchedule() {
        return lastWeekSchedule;
    }

    public void setLastWeekSchedule(String lastWeekSchedule) {
        this.lastWeekSchedule = lastWeekSchedule;
    }

    public String getCurrentSchedule() {
        return currentSchedule;
    }

    public void setCurrentSchedule(String currentSchedule) {
        this.currentSchedule = currentSchedule;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
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

    public String getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(String update_time) {
        this.update_time = update_time;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getExpectedSchedule() {
        return expectedSchedule;
    }

    public void setExpectedSchedule(String expectedSchedule) {
        this.expectedSchedule = expectedSchedule;
    }

    public String getWeekNo() {
        return weekNo;
    }

    public void setWeekNo(String weekNo) {
        this.weekNo = weekNo;
    }


}
