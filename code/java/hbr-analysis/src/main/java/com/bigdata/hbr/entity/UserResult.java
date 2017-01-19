package com.bigdata.hbr.entity;

import java.util.Date;

public class UserResult {
    private Integer id;

    private String username;

    private Double sd1;

    private Double sd2;

    private String healthStatus;

    private Date logTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public Double getSd1() {
        return sd1;
    }

    public void setSd1(Double sd1) {
        this.sd1 = sd1;
    }

    public Double getSd2() {
        return sd2;
    }

    public void setSd2(Double sd2) {
        this.sd2 = sd2;
    }

    public String getHealthStatus() {
        return healthStatus;
    }

    public void setHealthStatus(String healthStatus) {
        this.healthStatus = healthStatus == null ? null : healthStatus.trim();
    }

    public Date getLogTime() {
        return logTime;
    }

    public void setLogTime(Date logTime) {
        this.logTime = logTime;
    }
}