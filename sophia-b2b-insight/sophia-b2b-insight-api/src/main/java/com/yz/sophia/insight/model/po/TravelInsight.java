package com.yz.sophia.insight.model.po;

import java.util.Date;

public class TravelInsight {
    private Long id;

    private Integer delayTnum;

    private Integer extensiveDelay;

    private Integer outActionNum;

    private Integer futDelayTrain;

    private String trainTodayName;

    private Integer trainTodayNum;

    private String trainTodayTnum;

    private String trainTodayDelayDate;

    private Date createTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getDelayTnum() {
        return delayTnum;
    }

    public void setDelayTnum(Integer delayTnum) {
        this.delayTnum = delayTnum;
    }

    public Integer getExtensiveDelay() {
        return extensiveDelay;
    }

    public void setExtensiveDelay(Integer extensiveDelay) {
        this.extensiveDelay = extensiveDelay;
    }

    public Integer getOutActionNum() {
        return outActionNum;
    }

    public void setOutActionNum(Integer outActionNum) {
        this.outActionNum = outActionNum;
    }

    public Integer getFutDelayTrain() {
        return futDelayTrain;
    }

    public void setFutDelayTrain(Integer futDelayTrain) {
        this.futDelayTrain = futDelayTrain;
    }

    public String getTrainTodayName() {
        return trainTodayName;
    }

    public void setTrainTodayName(String trainTodayName) {
        this.trainTodayName = trainTodayName;
    }

    public Integer getTrainTodayNum() {
        return trainTodayNum;
    }

    public void setTrainTodayNum(Integer trainTodayNum) {
        this.trainTodayNum = trainTodayNum;
    }

    public String getTrainTodayTnum() {
        return trainTodayTnum;
    }

    public void setTrainTodayTnum(String trainTodayTnum) {
        this.trainTodayTnum = trainTodayTnum;
    }

    public String getTrainTodayDelayDate() {
        return trainTodayDelayDate;
    }

    public void setTrainTodayDelayDate(String trainTodayDelayDate) {
        this.trainTodayDelayDate = trainTodayDelayDate;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}