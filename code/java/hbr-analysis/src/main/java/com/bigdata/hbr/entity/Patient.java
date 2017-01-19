package com.bigdata.hbr.entity;

public class Patient {
    private Integer id;

    private String name;

    private String gender;

    private String position;

    private String doctorLoginName;

    private String heartIdentifier;

    private Double sd1;

    private Double sd2;

    private String healthStatus;

    private String treatStatus;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position == null ? null : position.trim();
    }

    public String getDoctorLoginName() {
        return doctorLoginName;
    }

    public void setDoctorLoginName(String doctorLoginName) {
        this.doctorLoginName = doctorLoginName == null ? null : doctorLoginName.trim();
    }

    public String getHeartIdentifier() {
        return heartIdentifier;
    }

    public void setHeartIdentifier(String heartIdentifier) {
        this.heartIdentifier = heartIdentifier == null ? null : heartIdentifier.trim();
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

    public String getTreatStatus() {
        return treatStatus;
    }

    public void setTreatStatus(String treatStatus) {
        this.treatStatus = treatStatus == null ? null : treatStatus.trim();
    }
}