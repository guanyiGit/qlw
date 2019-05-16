package com.soholy.dogmanager.pojo.dogCard;

import java.util.Date;

//精确查找犬只档案列表的参数对象
public class DogArchivesParm {
    private static final long serialVersionUID = 1L;
    private String districtId;//区域id
    private Integer varieties;//犬只品种
    private Integer gender;//性别
    private Integer color;//毛色
    private Integer dogAgeStart;//起始犬龄
    private Integer dogAgeEnd;//结束犬龄
    private Date registrationStartDate;//登记起始时间 登记时间指犬证办理时间
    private Date registrationEndDate;//登记结束时间
    private int status;//状态
    private Integer startPoints;//扣分范围起始
    private Integer endPoints;//扣分范围结束
    private String input;//模糊查询字符串
    private Integer num;//页码
    private Integer start;//sql查询起始数
    private Integer size;//条数

    public String getDistrictId() {
        return districtId;
    }

    public void setDistrictId(String districtId) {
        this.districtId = districtId;
    }

    public Integer getVarieties() {
        return varieties;
    }

    public void setVarieties(Integer varieties) {
        this.varieties = varieties;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Integer getColor() {
        return color;
    }

    public void setColor(Integer color) {
        this.color = color;
    }

    public Integer getDogAgeStart() {
        return dogAgeStart;
    }

    public void setDogAgeStart(Integer dogAgeStart) {
        this.dogAgeStart = dogAgeStart;
    }

    public Integer getDogAgeEnd() {
        return dogAgeEnd;
    }

    public void setDogAgeEnd(Integer dogAgeEnd) {
        this.dogAgeEnd = dogAgeEnd;
    }

    public Date getRegistrationStartDate() {
        return registrationStartDate;
    }

    public void setRegistrationStartDate(Date registrationStartDate) {
        this.registrationStartDate = registrationStartDate;
    }

    public Date getRegistrationEndDate() {
        return registrationEndDate;
    }

    public void setRegistrationEndDate(Date registrationEndDate) {
        this.registrationEndDate = registrationEndDate;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Integer getStartPoints() {
        return startPoints;
    }

    public void setStartPoints(Integer startPoints) {
        this.startPoints = startPoints;
    }

    public Integer getEndPoints() {
        return endPoints;
    }

    public void setEndPoints(Integer endPoints) {
        this.endPoints = endPoints;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "DogArchivesParm{" +
                "districtId='" + districtId + '\'' +
                ", varieties=" + varieties +
                ", gender=" + gender +
                ", color=" + color +
                ", dogAgeStart=" + dogAgeStart +
                ", dogAgeEnd=" + dogAgeEnd +
                ", registrationStartDate=" + registrationStartDate +
                ", registrationEndDate=" + registrationEndDate +
                ", status=" + status +
                ", startPoints=" + startPoints +
                ", endPoints=" + endPoints +
                ", input='" + input + '\'' +
                ", num=" + num +
                ", start=" + start +
                ", size=" + size +
                '}';
    }
}
