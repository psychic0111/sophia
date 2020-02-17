package com.yz.sophia.insight.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.yz.sophia.business.api.exception.BusinessException;
import com.yz.sophia.business.core.util.BeanUtils;
import com.yz.sophia.business.core.util.DateUtils;
import com.yz.sophia.insight.core.config.ApiConfig;
import com.yz.sophia.insight.core.config.InsightConfig;
import com.yz.sophia.insight.dao.CustomerMapper;
import com.yz.sophia.insight.model.enums.CooperationModeEnum;
import com.yz.sophia.insight.model.po.Customer;
import com.yz.sophia.insight.model.qo.CustomerQo;
import com.yz.sophia.insight.model.request.CustomerAddReq;
import com.yz.sophia.insight.model.response.LzSearchBodyResp;
import com.yz.sophia.insight.model.response.LzSearchResp;
import com.yz.sophia.insight.model.vo.CustomerInfoVo;
import com.yz.sophia.insight.model.vo.User;
import com.yz.sophia.insight.util.ApiSignUtils;
import com.yz.sophia.insight.util.HttpUtils;
import com.yz.sophia.insight.util.RSAUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

@Slf4j
@Service
public class LzSearchService {

    private InsightConfig config;

    public LzSearchBodyResp searchArticlesByWebsite(String domain, Integer emotion, String startTime, String endTime, int pageIndex, int pageRows) throws Exception {
        JSONObject req = new JSONObject();
        JSONObject head = new JSONObject();
        head.put("apikey", config.getApi().getKey());
        head.put("version", config.getApi().getVersion());
        JSONObject body = new JSONObject();
        body.put("domain", domain);
        body.put("emotion", emotion);
        body.put("startTime", startTime);
        body.put("endTime", endTime);
        body.put("pageIndex", pageIndex);
        body.put("pageRows", pageRows);
        String rsaPrivateKey = RSAUtils.readKeyFile(ApiSignUtils.class.getResourceAsStream("/rsa/pkcs8_rsa_private_key.pem"));
        String sign = ApiSignUtils.sign(config.getApi().getKey(), body, rsaPrivateKey);
        head.put("sign", sign);
        req.put("head", head);
        req.put("body", body);

        log.debug("生成请求接口签名：{}", sign);

        String url = config.getApi().getSearchArticlesByWebsite();
        String result = HttpUtils.post(url, req.toJSONString());
        JSONObject jsonResult = JSONObject.parseObject(result);
        LzSearchResp resp = JSON.toJavaObject(jsonResult, LzSearchResp.class);
        if (resp.getHead().getCode() == HttpStatus.SC_OK) {
            String resultSign = resp.getHead().getSign();
            String rsaPublicKey = RSAUtils.readKeyFile(ApiSignUtils.class.getResourceAsStream("/rsa/api/rsa_public_key.pem"));
            boolean verifyResult = ApiSignUtils.verify(config.getApi().getKey(), jsonResult.getJSONObject("body"), rsaPublicKey, resultSign);
            if (!verifyResult) {
                throw new Exception("Signature verification failed");
            }
        }
        return resp.getBody();
    }

    public LzSearchBodyResp searchArticlesByKeyword(String keyword, Integer emotion, Integer position, String startTime, String endTime, int pageIndex, int pageRows) throws Exception {
        JSONObject req = new JSONObject();
        JSONObject head = new JSONObject();
        head.put("apikey", config.getApi().getKey());
        head.put("version", config.getApi().getVersion());
        JSONObject body = new JSONObject();
        body.put("keyword", keyword);
        body.put("position", position);
        body.put("emotion", emotion);
        body.put("startTime", startTime);
        body.put("endTime", endTime);
        body.put("pageIndex", pageIndex);
        body.put("pageRows", pageRows);
        String rsaPrivateKey = RSAUtils.readKeyFile(ApiSignUtils.class.getResourceAsStream("/rsa/pkcs8_rsa_private_key.pem"));
        String sign = ApiSignUtils.sign(config.getApi().getKey(), body, rsaPrivateKey);
        head.put("sign", sign);
        req.put("head", head);
        req.put("body", body);
        log.debug("生成请求接口签名：{}", sign);

        String url = config.getApi().getSearchArticlesByKeyword();
        String result = HttpUtils.post(url, req.toJSONString());
        JSONObject jsonResult = JSONObject.parseObject(result);
        LzSearchResp resp = JSON.toJavaObject(jsonResult, LzSearchResp.class);
        if (resp.getHead().getCode() == HttpStatus.SC_OK) {
            String resultSign = resp.getHead().getSign();
            String rsaPublicKey = RSAUtils.readKeyFile(ApiSignUtils.class.getResourceAsStream("/rsa/api/rsa_public_key.pem"));
            boolean verifyResult = ApiSignUtils.verify(config.getApi().getKey(), jsonResult.getJSONObject("body"), rsaPublicKey, resultSign);
            if (!verifyResult) {
                throw new Exception("Signature verification failed");
            }
        }

        return resp.getBody();
    }

    public LzSearchBodyResp searchArticlesBySource(String sourceType, Integer emotion, String startTime, String endTime, int pageIndex, int pageRows) throws Exception {
        JSONObject req = new JSONObject();
        JSONObject head = new JSONObject();
        head.put("apikey", config.getApi().getKey());
        head.put("version", "1.0.0");
        JSONObject body = new JSONObject();
        body.put("sourceType", sourceType);
        body.put("emotion", emotion);
        body.put("startTime", startTime);
        body.put("endTime", endTime);
        body.put("pageIndex", pageIndex);
        body.put("pageRows", pageRows);
        String rsaPrivateKey = RSAUtils.readKeyFile(ApiSignUtils.class.getResourceAsStream("/rsa/pkcs8_rsa_private_key.pem"));
        String sign = ApiSignUtils.sign(config.getApi().getKey(), body, rsaPrivateKey);
        head.put("sign", sign);
        req.put("head", head);
        req.put("body", body);
        log.debug("生成请求接口签名：{}", sign);

        String url = config.getApi().getSearchArticlesBySource();
        String result = HttpUtils.post(url, req.toJSONString());
        JSONObject jsonResult = JSONObject.parseObject(result);
        LzSearchResp resp = JSON.toJavaObject(jsonResult, LzSearchResp.class);
        if (resp.getHead().getCode() == HttpStatus.SC_OK) {
            String resultSign = resp.getHead().getSign();
            String rsaPublicKey = RSAUtils.readKeyFile(ApiSignUtils.class.getResourceAsStream("/rsa/api/rsa_public_key.pem"));
            boolean verifyResult = ApiSignUtils.verify(config.getApi().getKey(), jsonResult.getJSONObject("body"), rsaPublicKey, resultSign);
            if (!verifyResult) {
                throw new Exception("Signature verification failed");
            }
        }

        return resp.getBody();
    }
}
