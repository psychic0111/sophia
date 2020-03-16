package com.yz.sophia.insight.service;

import com.alibaba.fastjson.JSONObject;
import com.yz.sophia.insight.dao.TravelInsightMapper;
import com.yz.sophia.insight.model.po.TravelInsight;
import com.yz.sophia.insight.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * create by liuji on 2020/3/16
 **/
@Service
public class TravelInsightService {

//    @Autowired
//    TravelInsightMapper travelInsightMapper;

    public TravelInsight getTravelInsight() throws IOException {
        String strURL = "https://data.variflight.com/analytics/otpapi/trainDelay";
        URL url = new URL(strURL);
        HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
        InputStreamReader input = new InputStreamReader(httpConn
                .getInputStream(), "utf-8");
        BufferedReader bufReader = new BufferedReader(input);
        String line = "";
        StringBuilder contentBuf = new StringBuilder();
        while ((line = bufReader.readLine()) != null) {
            contentBuf.append(line);
        }
        String buf = contentBuf.toString();

        System.out.println("返回的结果：\n" + new String(buf.getBytes("utf-8"),"utf-8"));
        JSONObject jsonObject=JSONObject.parseObject(buf);
        System.out.println("转成json：" + jsonObject.toString());
        String dataStr = jsonObject.getString("data");
        System.out.println("dataStr：" + dataStr);
        JSONObject data1Json=JSONObject.parseObject(dataStr);
        String data2Str = data1Json.getString("data");
        JSONObject data2Json=JSONObject.parseObject(data2Str);
        System.out.println("今日全国晚点车次数：" + data2Json.getInteger("delay_tnum"));
        System.out.println("大面积晚点车站数：" + data2Json.getInteger("extensive_delay"));
        System.out.println("今日全国停运车次数：" + data2Json.getInteger("out_action_num"));
        System.out.println("未来两个小时内预计晚点车次数：" + data2Json.getInteger("fut_delay_train"));
        JSONObject trainTodyJson=JSONObject.parseObject(data2Json.getString("train_today"));
        System.out.println("出发晚点最多的车次：" + trainTodyJson.getString("name"));
        System.out.println("晚点车次数：" + trainTodyJson.getInteger("num"));
        System.out.println("晚点车次：" + trainTodyJson.getString("tnum"));
        System.out.println("最长晚点时长：" + trainTodyJson.getString("delay_date"));
        TravelInsight travelInsight = new TravelInsight();
        travelInsight.setCreateTime(DateUtil.getNowDate());
        travelInsight.setDelayTnum(data2Json.getInteger("delay_tnum"));
        travelInsight.setExtensiveDelay(data2Json.getInteger("extensive_delay"));
        travelInsight.setOutActionNum(data2Json.getInteger("out_action_num"));
        travelInsight.setFutDelayTrain(data2Json.getInteger("fut_delay_train"));
        travelInsight.setTrainTodayName(trainTodyJson.getString("name"));
        travelInsight.setTrainTodayNum(trainTodyJson.getInteger("num"));
        travelInsight.setTrainTodayTnum(trainTodyJson.getString("tnum"));
        travelInsight.setTrainTodayDelayDate(trainTodyJson.getString("delay_date"));
        return travelInsight;
    }

}
