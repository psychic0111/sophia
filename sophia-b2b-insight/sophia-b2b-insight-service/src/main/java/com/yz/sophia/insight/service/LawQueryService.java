package com.yz.sophia.insight.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.yz.sophia.insight.core.config.InsightConfig;
import com.yz.sophia.insight.model.enums.LawResultEnum;
import com.yz.sophia.insight.model.response.LawResultResp;
import com.yz.sophia.insight.model.response.LzSearchBodyResp;
import com.yz.sophia.insight.model.response.LzSearchResp;
import com.yz.sophia.insight.util.ApiSignUtils;
import com.yz.sophia.insight.util.HttpUtils;
import com.yz.sophia.insight.util.RSAUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class LawQueryService {

    @Autowired
    private InsightConfig config;

    public LawResultResp lawyerCaseDistribute() throws Exception {
        JSONObject req = new JSONObject();
        LawResultResp resp = new LawResultResp();
        resp.setRspCode(LawResultEnum.SUCCESS.getCode());
        resp.setRspMsg(LawResultEnum.SUCCESS.getName());
        String url = config.getApi().getLawyerCaseDistribute();
        String result = HttpUtils.post(url, req.toJSONString());
        if (null == result || "".equals(result)) {
            resp.setRspCode(LawResultEnum.FAIL.getCode());
            resp.setRspMsg(LawResultEnum.FAIL.getName());
        }
        Gson gson = new Gson();
        Map<String, Object> map = new HashMap<String, Object>();
        map = gson.fromJson(result, map.getClass());
        resp.setMap(map);
        return resp;
    }


    public LawResultResp lawyerCaseTypeDistribute() throws Exception {
        JSONObject req = new JSONObject();
        LawResultResp resp = new LawResultResp();
        resp.setRspCode(LawResultEnum.SUCCESS.getCode());
        resp.setRspMsg(LawResultEnum.SUCCESS.getName());
        String url = config.getApi().getLawyerCaseTypeDistribute();
        String result = HttpUtils.post(url, req.toJSONString());
        if (null == result || "".equals(result)) {
            resp.setRspCode(LawResultEnum.FAIL.getCode());
            resp.setRspMsg(LawResultEnum.FAIL.getName());
        }
        Gson gson = new Gson();
        Map<String, Object> map = new HashMap<String, Object>();
        map = gson.fromJson(result, map.getClass());
        resp.setMap(map);
        return resp;
    }


    public LawResultResp lawCourtLevelDistribute() throws Exception{
        JSONObject req = new JSONObject();
        LawResultResp resp = new LawResultResp();
        resp.setRspCode(LawResultEnum.SUCCESS.getCode());
        resp.setRspMsg(LawResultEnum.SUCCESS.getName());
        String url = config.getApi().getLawCourtLevelDistribute();
        String result = HttpUtils.post(url, req.toJSONString());
        if (null == result || "".equals(result)) {
            resp.setRspCode(LawResultEnum.FAIL.getCode());
            resp.setRspMsg(LawResultEnum.FAIL.getName());
        }
        Gson gson = new Gson();
        Map<String, Object> map = new HashMap<String, Object>();
        map = gson.fromJson(result, map.getClass());
        resp.setMap(map);
        return resp;
    }

    public LawResultResp lawCaseTimeDistribute() throws Exception{
        JSONObject req = new JSONObject();
        LawResultResp resp = new LawResultResp();
        resp.setRspCode(LawResultEnum.SUCCESS.getCode());
        resp.setRspMsg(LawResultEnum.SUCCESS.getName());
        String url = config.getApi().getLawCaseTimeDistribute();
        String result = HttpUtils.post(url, req.toJSONString());
        if (null == result || "".equals(result)) {
            resp.setRspCode(LawResultEnum.FAIL.getCode());
            resp.setRspMsg(LawResultEnum.FAIL.getName());
        }
        Gson gson = new Gson();
        Map<String, Object> map = new HashMap<String, Object>();
        map = gson.fromJson(result, map.getClass());
        resp.setMap(map);
        return resp;
    }

    public LawResultResp lawCaseAreaDistribute() throws Exception{
        JSONObject req = new JSONObject();
        LawResultResp resp = new LawResultResp();
        resp.setRspCode(LawResultEnum.SUCCESS.getCode());
        resp.setRspMsg(LawResultEnum.SUCCESS.getName());
        String url = config.getApi().getLawCaseAreaDistribute();
        String result = HttpUtils.post(url, req.toJSONString());
        if (null == result || "".equals(result)) {
            resp.setRspCode(LawResultEnum.FAIL.getCode());
            resp.setRspMsg(LawResultEnum.FAIL.getName());
        }
        Gson gson = new Gson();
        Map<String, Object> map = new HashMap<String, Object>();
        map = gson.fromJson(result, map.getClass());
        resp.setMap(map);
        return resp;
    }

    public LawResultResp lawLitigationStepDistribute() throws Exception{
        JSONObject req = new JSONObject();
        LawResultResp resp = new LawResultResp();
        resp.setRspCode(LawResultEnum.SUCCESS.getCode());
        resp.setRspMsg(LawResultEnum.SUCCESS.getName());
        String url = config.getApi().getLawLitigationStepDistribute();
        String result = HttpUtils.post(url, req.toJSONString());
        if (null == result || "".equals(result)) {
            resp.setRspCode(LawResultEnum.FAIL.getCode());
            resp.setRspMsg(LawResultEnum.FAIL.getName());
        }
        Gson gson = new Gson();
        Map<String, Object> map = new HashMap<String, Object>();
        map = gson.fromJson(result, map.getClass());
        resp.setMap(map);
        return resp;
    }

    public LawResultResp lawCustomerTypeDistribute() throws Exception{
        JSONObject req = new JSONObject();
        LawResultResp resp = new LawResultResp();
        resp.setRspCode(LawResultEnum.SUCCESS.getCode());
        resp.setRspMsg(LawResultEnum.SUCCESS.getName());
        String url = config.getApi().getLawCustomerTypeDistribute();
        String result = HttpUtils.post(url, req.toJSONString());
        if (null == result || "".equals(result)) {
            resp.setRspCode(LawResultEnum.FAIL.getCode());
            resp.setRspMsg(LawResultEnum.FAIL.getName());
        }
        Gson gson = new Gson();
        Map<String, Object> map = new HashMap<String, Object>();
        map = gson.fromJson(result, map.getClass());
        resp.setMap(map);
        return resp;
    }

    public LawResultResp lawSentenceRate() throws Exception{
        JSONObject req = new JSONObject();
        LawResultResp resp = new LawResultResp();
        resp.setRspCode(LawResultEnum.SUCCESS.getCode());
        resp.setRspMsg(LawResultEnum.SUCCESS.getName());
        String url = config.getApi().getLawSentenceRate();
        String result = HttpUtils.post(url, req.toJSONString());
        if (null == result || "".equals(result)) {
            resp.setRspCode(LawResultEnum.FAIL.getCode());
            resp.setRspMsg(LawResultEnum.FAIL.getName());
        }
        Gson gson = new Gson();
        Map<String, Object> map = new HashMap<String, Object>();
        map = gson.fromJson(result, map.getClass());
        resp.setMap(map);
        return resp;
    }

    public LawResultResp lawSentenceMoney() throws Exception{
        JSONObject req = new JSONObject();
        LawResultResp resp = new LawResultResp();
        resp.setRspCode(LawResultEnum.SUCCESS.getCode());
        resp.setRspMsg(LawResultEnum.SUCCESS.getName());
        String url = config.getApi().getLawSentenceMoney();
        String result = HttpUtils.post(url, req.toJSONString());
        if (null == result || "".equals(result)) {
            resp.setRspCode(LawResultEnum.FAIL.getCode());
            resp.setRspMsg(LawResultEnum.FAIL.getName());
        }
        Gson gson = new Gson();
        Map<String, Object> map = new HashMap<String, Object>();
        map = gson.fromJson(result, map.getClass());
        resp.setMap(map);
        return resp;
    }

    public LawResultResp clientCaseDistribute() throws Exception{
        JSONObject req = new JSONObject();
        LawResultResp resp = new LawResultResp();
        resp.setRspCode(LawResultEnum.SUCCESS.getCode());
        resp.setRspMsg(LawResultEnum.SUCCESS.getName());
        String url = config.getApi().getClientCaseDistribute();
        String result = HttpUtils.post(url, req.toJSONString());
        if (null == result || "".equals(result)) {
            resp.setRspCode(LawResultEnum.FAIL.getCode());
            resp.setRspMsg(LawResultEnum.FAIL.getName());
        }
        Gson gson = new Gson();
        Map<String, Object> map = new HashMap<String, Object>();
        List list = gson.fromJson(result,new TypeToken<List<Map<String, Object>>>() {}.getType());
        map.put("list",list);
        resp.setMap(map);
        return resp;
    }

    public LawResultResp clientCaseTypeDistribute() throws Exception{
        JSONObject req = new JSONObject();
        LawResultResp resp = new LawResultResp();
        resp.setRspCode(LawResultEnum.SUCCESS.getCode());
        resp.setRspMsg(LawResultEnum.SUCCESS.getName());
        String url = config.getApi().getClientCaseTypeDistribute();
        String result = HttpUtils.post(url, req.toJSONString());
        if (null == result || "".equals(result)) {
            resp.setRspCode(LawResultEnum.FAIL.getCode());
            resp.setRspMsg(LawResultEnum.FAIL.getName());
        }
        Gson gson = new Gson();
        Map<String, Object> map = new HashMap<String, Object>();
        List list = gson.fromJson(result,new TypeToken<List<Map<String, Object>>>() {}.getType());
        map.put("list",list);
        resp.setMap(map);
        return resp;
    }

    public LawResultResp clientCourtLevelDistribute() throws Exception{
        JSONObject req = new JSONObject();
        LawResultResp resp = new LawResultResp();
        resp.setRspCode(LawResultEnum.SUCCESS.getCode());
        resp.setRspMsg(LawResultEnum.SUCCESS.getName());
        String url = config.getApi().getClientCourtLevelDistribute();
        String result = HttpUtils.post(url, req.toJSONString());
        if (null == result || "".equals(result)) {
            resp.setRspCode(LawResultEnum.FAIL.getCode());
            resp.setRspMsg(LawResultEnum.FAIL.getName());
        }
        Gson gson = new Gson();
        Map<String, Object> map = new HashMap<String, Object>();
        List list = gson.fromJson(result,new TypeToken<List<Map<String, Object>>>() {}.getType());
        map.put("list",list);
        resp.setMap(map);
        return resp;
    }

    public LawResultResp clientCaseTimeDistribute() throws Exception{
        JSONObject req = new JSONObject();
        LawResultResp resp = new LawResultResp();
        resp.setRspCode(LawResultEnum.SUCCESS.getCode());
        resp.setRspMsg(LawResultEnum.SUCCESS.getName());
        String url = config.getApi().getClientCaseTimeDistribute();
        String result = HttpUtils.post(url, req.toJSONString());
        if (null == result || "".equals(result)) {
            resp.setRspCode(LawResultEnum.FAIL.getCode());
            resp.setRspMsg(LawResultEnum.FAIL.getName());
        }
        Gson gson = new Gson();
        Map<String, Object> map = new HashMap<String, Object>();
        map = gson.fromJson(result, map.getClass());
        resp.setMap(map);
        return resp;
    }

    public LawResultResp clientCaseAreaDistribute() throws Exception{
        JSONObject req = new JSONObject();
        LawResultResp resp = new LawResultResp();
        resp.setRspCode(LawResultEnum.SUCCESS.getCode());
        resp.setRspMsg(LawResultEnum.SUCCESS.getName());
        String url = config.getApi().getClientCaseAreaDistribute();
        String result = HttpUtils.post(url, req.toJSONString());
        if (null == result || "".equals(result)) {
            resp.setRspCode(LawResultEnum.FAIL.getCode());
            resp.setRspMsg(LawResultEnum.FAIL.getName());
        }
        Gson gson = new Gson();
        Map<String, Object> map = new HashMap<String, Object>();
        map = gson.fromJson(result, map.getClass());
        resp.setMap(map);
        return resp;
    }

    public LawResultResp clientSentenceMoney() throws Exception{
        JSONObject req = new JSONObject();
        LawResultResp resp = new LawResultResp();
        resp.setRspCode(LawResultEnum.SUCCESS.getCode());
        resp.setRspMsg(LawResultEnum.SUCCESS.getName());
        String url = config.getApi().getClientSentenceMoney();
        String result = HttpUtils.post(url, req.toJSONString());
        if (null == result || "".equals(result)) {
            resp.setRspCode(LawResultEnum.FAIL.getCode());
            resp.setRspMsg(LawResultEnum.FAIL.getName());
        }
        Gson gson = new Gson();
        Map<String, Object> map = new HashMap<String, Object>();
        map = gson.fromJson(result, map.getClass());
        resp.setMap(map);
        return resp;
    }

    public LawResultResp clientSentenceRate() throws Exception{
        JSONObject req = new JSONObject();
        LawResultResp resp = new LawResultResp();
        resp.setRspCode(LawResultEnum.SUCCESS.getCode());
        resp.setRspMsg(LawResultEnum.SUCCESS.getName());
        String url = config.getApi().getClientSentenceRate();
        String result = HttpUtils.post(url, req.toJSONString());
        if (null == result || "".equals(result)) {
            resp.setRspCode(LawResultEnum.FAIL.getCode());
            resp.setRspMsg(LawResultEnum.FAIL.getName());
        }
        Gson gson = new Gson();
        Map<String, Object> map = new HashMap<String, Object>();
        List list = gson.fromJson(result,new TypeToken<List<Map<String, Object>>>() {}.getType());
        map.put("list",list);
        resp.setMap(map);
        return resp;
    }
}
