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
import com.yz.sophia.insight.util.HttpClientUtils;
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

    public LawResultResp lawyerCaseDistribute(String paramCode) throws Exception {
        JSONObject req = new JSONObject();
        LawResultResp resp = new LawResultResp();
        resp.setRspCode(LawResultEnum.SUCCESS.getCode());
        resp.setRspMsg(LawResultEnum.SUCCESS.getName());
        String url = config.getApi().getLawyerCaseDistribute()+"/"+paramCode;
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


    public LawResultResp lawyerCaseTypeDistribute(String paramCode) throws Exception {
        JSONObject req = new JSONObject();
        LawResultResp resp = new LawResultResp();
        resp.setRspCode(LawResultEnum.SUCCESS.getCode());
        resp.setRspMsg(LawResultEnum.SUCCESS.getName());
        String url = config.getApi().getLawyerCaseTypeDistribute()+"/"+paramCode;
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


    public LawResultResp lawCourtLevelDistribute(String paramCode) throws Exception{
        JSONObject req = new JSONObject();
        LawResultResp resp = new LawResultResp();
        resp.setRspCode(LawResultEnum.SUCCESS.getCode());
        resp.setRspMsg(LawResultEnum.SUCCESS.getName());
        String url = config.getApi().getLawCourtLevelDistribute()+"/"+paramCode;
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

    public LawResultResp lawCaseTimeDistribute(String paramCode) throws Exception{
        JSONObject req = new JSONObject();
        LawResultResp resp = new LawResultResp();
        resp.setRspCode(LawResultEnum.SUCCESS.getCode());
        resp.setRspMsg(LawResultEnum.SUCCESS.getName());
        String url = config.getApi().getLawCaseTimeDistribute()+"/"+paramCode;
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

    public LawResultResp lawCaseAreaDistribute(String paramCode) throws Exception{
        JSONObject req = new JSONObject();
        LawResultResp resp = new LawResultResp();
        resp.setRspCode(LawResultEnum.SUCCESS.getCode());
        resp.setRspMsg(LawResultEnum.SUCCESS.getName());
        String url = config.getApi().getLawCaseAreaDistribute()+"/"+paramCode;
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

    public LawResultResp lawLitigationStepDistribute(String paramCode) throws Exception{
        JSONObject req = new JSONObject();
        LawResultResp resp = new LawResultResp();
        resp.setRspCode(LawResultEnum.SUCCESS.getCode());
        resp.setRspMsg(LawResultEnum.SUCCESS.getName());
        String url = config.getApi().getLawLitigationStepDistribute()+"/"+paramCode;
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

    public LawResultResp lawCustomerTypeDistribute(String paramCode) throws Exception{
        JSONObject req = new JSONObject();
        LawResultResp resp = new LawResultResp();
        resp.setRspCode(LawResultEnum.SUCCESS.getCode());
        resp.setRspMsg(LawResultEnum.SUCCESS.getName());
        String url = config.getApi().getLawCustomerTypeDistribute()+"/"+paramCode;
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

    public LawResultResp lawSentenceRate(String paramCode) throws Exception{
        JSONObject req = new JSONObject();
        LawResultResp resp = new LawResultResp();
        resp.setRspCode(LawResultEnum.SUCCESS.getCode());
        resp.setRspMsg(LawResultEnum.SUCCESS.getName());
        String url = config.getApi().getLawSentenceRate()+"/"+paramCode;
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

    public LawResultResp lawSentenceMoney(String paramCode) throws Exception{
        JSONObject req = new JSONObject();
        LawResultResp resp = new LawResultResp();
        resp.setRspCode(LawResultEnum.SUCCESS.getCode());
        resp.setRspMsg(LawResultEnum.SUCCESS.getName());
        String url = config.getApi().getLawSentenceMoney()+"/"+paramCode;
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

    public LawResultResp clientCaseDistribute(String paramCode) throws Exception{
        JSONObject req = new JSONObject();
        LawResultResp resp = new LawResultResp();
        resp.setRspCode(LawResultEnum.SUCCESS.getCode());
        resp.setRspMsg(LawResultEnum.SUCCESS.getName());
        String url = config.getApi().getClientCaseDistribute()+"/"+paramCode;
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

    public LawResultResp clientCaseTypeDistribute(String paramCode) throws Exception{
        JSONObject req = new JSONObject();
        LawResultResp resp = new LawResultResp();
        resp.setRspCode(LawResultEnum.SUCCESS.getCode());
        resp.setRspMsg(LawResultEnum.SUCCESS.getName());
        String url = config.getApi().getClientCaseTypeDistribute()+"/"+paramCode;
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

    public LawResultResp clientCourtLevelDistribute(String paramCode) throws Exception{
        JSONObject req = new JSONObject();
        LawResultResp resp = new LawResultResp();
        resp.setRspCode(LawResultEnum.SUCCESS.getCode());
        resp.setRspMsg(LawResultEnum.SUCCESS.getName());
        String url = config.getApi().getClientCourtLevelDistribute()+"/"+paramCode;
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

    public LawResultResp clientCaseTimeDistribute(String paramCode) throws Exception{
        JSONObject req = new JSONObject();
        LawResultResp resp = new LawResultResp();
        resp.setRspCode(LawResultEnum.SUCCESS.getCode());
        resp.setRspMsg(LawResultEnum.SUCCESS.getName());
        String url = config.getApi().getClientCaseTimeDistribute()+"/"+paramCode;
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

    public LawResultResp clientCaseAreaDistribute(String paramCode) throws Exception{
        JSONObject req = new JSONObject();
        LawResultResp resp = new LawResultResp();
        resp.setRspCode(LawResultEnum.SUCCESS.getCode());
        resp.setRspMsg(LawResultEnum.SUCCESS.getName());
        String url = config.getApi().getClientCaseAreaDistribute()+"/"+paramCode;
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

    public LawResultResp clientSentenceMoney(String paramCode) throws Exception{
        JSONObject req = new JSONObject();
        LawResultResp resp = new LawResultResp();
        resp.setRspCode(LawResultEnum.SUCCESS.getCode());
        resp.setRspMsg(LawResultEnum.SUCCESS.getName());
        String url = config.getApi().getClientSentenceMoney()+"/"+paramCode;
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

    public LawResultResp clientSentenceRate(String paramCode) throws Exception{
        JSONObject req = new JSONObject();
        LawResultResp resp = new LawResultResp();
        resp.setRspCode(LawResultEnum.SUCCESS.getCode());
        resp.setRspMsg(LawResultEnum.SUCCESS.getName());
        String url = config.getApi().getClientSentenceRate()+"/"+paramCode;
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

    public LawResultResp lawyerSearch(String keyword, int pageNo, int pageSize) throws Exception{
        Map req = new HashMap<String,Object>();
        LawResultResp resp = new LawResultResp();
        resp.setRspCode(LawResultEnum.SUCCESS.getCode());
        resp.setRspMsg(LawResultEnum.SUCCESS.getName());
        String url = config.getApi().getLawyerSearch();
        req.put("keyword1", keyword);
        req.put("pageNo", pageNo-1);//由于此接口分页是从0开始，所以需要减一做处理
        req.put("pageSize", pageSize);
        String result = HttpClientUtils.sendxwwwform(url, req);
        if (null == result || "".equals(result)) {
            resp.setRspCode(LawResultEnum.FAIL.getCode());
            resp.setRspMsg(LawResultEnum.FAIL.getName());
        }
        Gson gson = new Gson();
        Map<String, Object> map = new HashMap<String, Object>();
        List list = gson.fromJson(result,new TypeToken<List<Map<String, Object>>>() {}.getType());
        map.put("pageNo",pageNo);
        map.put("pageSize",pageSize);
        if (list != null ) {
            map.put("pageNum",list.size());
        }
        map.put("list",list);
        resp.setMap(map);
        return resp;
    }

    public LawResultResp clientSearch(String fullName) throws Exception{
        JSONObject req = new JSONObject();
        LawResultResp resp = new LawResultResp();
        resp.setRspCode(LawResultEnum.SUCCESS.getCode());
        resp.setRspMsg(LawResultEnum.SUCCESS.getName());
        String url = config.getApi().getClientSearch();
        req.put("fullName", fullName);
        String result = HttpClientUtils.sendxwwwform(url, req);
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
