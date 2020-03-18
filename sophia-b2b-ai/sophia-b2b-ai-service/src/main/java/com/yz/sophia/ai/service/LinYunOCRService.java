package com.yz.sophia.ai.service;

import com.sinovoice.hcicloudsdk.api.HciCloudSys;
import com.sinovoice.hcicloudsdk.api.HciCloudUser;
import com.sinovoice.hcicloudsdk.api.HciLibPath;
import com.sinovoice.hcicloudsdk.api.ocr.HciCloudOcr;
import com.sinovoice.hcicloudsdk.common.HciErrorCode;
import com.sinovoice.hcicloudsdk.common.InitParam;
import com.sinovoice.hcicloudsdk.common.Session;
import com.sinovoice.hcicloudsdk.common.ocr.OcrConfig;
import com.sinovoice.hcicloudsdk.common.ocr.OcrInitParam;
import com.sinovoice.hcicloudsdk.common.ocr.OcrRecogResult;
import com.sinovoice.hcicloudsdk.common.ocr.OcrTemplateId;
import com.yz.sophia.ai.core.config.AIConfig;
import com.yz.sophia.ai.model.enums.OCRFunctionEnum;
import com.yz.sophia.ai.model.enums.OCRTemplateEnum;
import com.yz.sophia.ai.model.response.HciOCRResp;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Date;

@Slf4j
@Service
public class LinYunOCRService {

    @Autowired
    private AIConfig aiConfig;

    private final String appkey="d95d5495";
    private final String developerkey= "266543e5971afddb9a10e899ecfdee21";
    private final String cloudurl="http://api.hcicloud.com:8880/ocr/auto_recognise";

    //指定使用的OCR手写能力
//	private final static String capkey="ocr.cloud.bizcard";
//	private final static String capkey="ocr.cloud.template";
//	private final static String capkey="ocr.cloud.uyghur";
    private final String templateIndex="0";
    private final String templatePageIndex="0";
    private final String property="hkidcard";
    //指定访问平台的SdkVersion版本、
    private final String sdkversion="8.1";
    private final String udid="101:1234567890";

    //@PostConstruct
    private void initHci(){
        String libPath = aiConfig.applicationHome() + "\\hci\\dll";
        // 指定dll文件路径，顺序表示加载顺序
        String sysLibPath[] = new String[] { libPath + "\\libhci_curl.dll",
                libPath + "\\hci_sys.dll", libPath + "\\hci_sys_jni.dll" };
        // 加载hci_sys.dll
        HciLibPath.setSysLibPath(sysLibPath);

        String ocrLibPath[] = new String[] {
                libPath + "\\libhci_curl.dll",
                libPath + "\\hci_sys.dll",
                libPath + "\\hci_sys_jni.dll",

                libPath + "\\opencv_core246.dll",
                libPath + "\\opencv_imgproc246.dll",
                libPath + "\\opencv_flann246.dll",
                libPath + "\\opencv_features2d246.dll",
                libPath + "\\opencv_calib3d246.dll",
                libPath + "\\opencv_highgui246.dll",
                libPath + "\\opencv_objdetect246.dll",
                libPath + "\\opencv_video246.dll",
                libPath + "\\opencv_gpu246.dll",
                libPath + "\\opencv_nonfree246.dll",

                libPath + "\\mkl_core.dll",
                libPath + "\\mkl_sequential.dll",
                libPath + "\\mkl_rt.dll",

                libPath + "\\iReadBarCodeApi.dll",
                libPath + "\\iRead_Function.dll",
                libPath + "\\iReadBankCard.dll",
                libPath + "\\iReadForm.dll",
                libPath + "\\iRead_BizCard.dll",

                libPath + "\\hci_ocr.dll",
                libPath + "\\hci_ocr_jni.dll",
                libPath + "\\hci_ocr_cloud_recog.dll",
                libPath + "\\hci_ocr_local_recog.dll",
                libPath + "\\hci_ocr_local_recog_bizcard.dll",
                libPath + "\\hci_ocr_local_recog_template.dll",
                libPath + "\\hci_ocr_local_recog_bankcard.dll",
        };

        // 再加载hci_ocr.dll
        HciLibPath.setOcrLibPath(ocrLibPath);
    }

    private int initOCR(String capKey){
        OcrInitParam ocrInitParam = new OcrInitParam();

        String dataPath = aiConfig.applicationHome() + "\\hci\\data";
        ocrInitParam.addParam(OcrInitParam.PARAM_KEY_DATA_PATH, dataPath);
        ocrInitParam.addParam(OcrInitParam.PARAM_KEY_FILE_FLAG, "none");
        ocrInitParam.addParam(OcrInitParam.PARAM_KEY_INIT_CAP_KEYS, capKey);

        // 调用初始化方法
        int initResult = HciCloudOcr.hciOcrInit(ocrInitParam.getStringConfig());
        return initResult;
    }

    /**
     *
     * @param capKey    ocr能力
     * @param userId    当前用户ID
     * @param data      图像数据
     * @return
     * @throws Exception
     */
    public HciOCRResp distinguish(OCRFunctionEnum capKey, String userId, byte[] data) throws Exception {
        HciOCRResp response = new HciOCRResp();
        InitParam initParam = aiConfig.getInitParam();
        initHci();
        int errorCode = HciCloudSys.hciInit(initParam.getStringConfig(), null);
        if(errorCode != HciErrorCode.HCI_ERR_NONE){
            log.error("灵云系统初始化失败");
            response.setCode(errorCode);
            response.setMessage(HciCloudSys.hciGetErrorInfo(errorCode));
            return response;
        }

        errorCode = HciCloudSys.hciCheckAuth();
        if(errorCode != HciErrorCode.HCI_ERR_NONE){
            log.error("灵云系统获取授权发生错误, 信息：code=" + errorCode + ", message=" + HciCloudSys.hciGetErrorInfo(errorCode));
            response.setCode(errorCode);
            response.setMessage(HciCloudSys.hciGetErrorInfo(errorCode));
            return response;
        }

        if(StringUtils.isNotBlank(userId)){
            errorCode = HciCloudUser.hciSetCurrentUser(userId);
            if(errorCode != HciErrorCode.HCI_ERR_NONE){
                log.error("灵云系统设置当前用户发生错误, userId:{}", userId);
                response.setCode(errorCode);
                response.setMessage(HciCloudSys.hciGetErrorInfo(errorCode));
                return response;
            }
        }

        errorCode = initOCR(capKey.getCode());
        if(errorCode != HciErrorCode.HCI_ERR_NONE){
            log.error("灵云系统初始OCR发生错误");
            response.setCode(errorCode);
            response.setMessage(HciCloudSys.hciGetErrorInfo(errorCode));
            return response;
        }

        OcrConfig recogConfig = new OcrConfig();
        // template加载处理
        OcrTemplateId templateId = new OcrTemplateId();
        if(capKey.getCode().contains("template")){
            if (capKey.getCode().contains("local")) {
                // 本地模板加载
            } else {
                // 云端需设置property参数
                recogConfig.addParam(
                        OcrConfig.TemplateConfig.PARAM_KEY_PROPTERTY, "idcard");
            }
            // 此处默认模板索引和模板页索引为0
            recogConfig.addParam(OcrConfig.TemplateConfig.PARAM_KEY_TEMPLATE_INDEX,
                    "0");
            recogConfig.addParam(
                    OcrConfig.TemplateConfig.PARAM_KEY_TEMPLATE_PATE_INDEX, "0");
        }

        // 初始化工作完成，开始识别图像数据
        Session session = new Session();
        try {
            OcrConfig sessionConfig = new OcrConfig();
            sessionConfig.addParam(OcrConfig.SessionConfig.PARAM_KEY_CAP_KEY, capKey.getCode());
            log.info("图像识别能力：{} 加载完毕", capKey.getName());
            errorCode = HciCloudOcr.hciOcrSessionStart(sessionConfig.getStringConfig(), session);
            if (errorCode != HciErrorCode.HCI_ERR_NONE) {
                log.error("灵云系统图像识别session开始发生异常, 信息：code=" + errorCode + ", message=" + HciCloudSys.hciGetErrorInfo(errorCode));
                response.setCode(errorCode);
                response.setMessage(HciCloudSys.hciGetErrorInfo(errorCode));
                return response;
            }

            errorCode = HciCloudOcr.hciOcrSetImageBuffer(session, data);
            if (errorCode != HciErrorCode.HCI_ERR_NONE) {
                log.error("灵云系统图像识别加载图像数据发生异常, 信息：code=" + errorCode + ", message=" + HciCloudSys.hciGetErrorInfo(errorCode));
                response.setCode(errorCode);
                response.setMessage(HciCloudSys.hciGetErrorInfo(errorCode));
                return response;
            }

            OcrRecogResult result = new OcrRecogResult();

            log.info("开始识别图像，识别配置信息：{}", recogConfig.getStringConfig());
            errorCode = HciCloudOcr.hciOcrRecog(session, recogConfig.getStringConfig(), null, result);
            if (errorCode != HciErrorCode.HCI_ERR_NONE) {
                log.error("灵云系统图像识别发生异常, 信息：code=" + errorCode + ", message=" + HciCloudSys.hciGetErrorInfo(errorCode));
                response.setCode(errorCode);
                response.setMessage(HciCloudSys.hciGetErrorInfo(errorCode));
                return response;
            }

            response.setData(result);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            HciCloudOcr.hciOcrSessionStop(session);
            HciCloudOcr.hciOcrRelease();
            HciCloudSys.hciRelease();
        }
        return response;
    }

    public byte[] distinguishByHttp(OCRFunctionEnum capKey, OCRTemplateEnum templateEnum, String needScore, String userId, InputStream bInputStream) throws Exception {
        HttpClient httpClient = new HttpClient();
        PostMethod postMethod = new PostMethod(cloudurl);
        postMethod.setRequestHeader("x-app-key",appkey);
        postMethod.setRequestHeader("x-sdk-version", sdkversion);

        Date currentTime = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String nowDate = dateFormat.format(currentTime);

        postMethod.setRequestHeader("x-request-date", nowDate);

        //String taskconfig="capkey="+ capKey.getCode() +",property=idcard,templateIndex="+templateIndex+",templatePageindex="+templatePageIndex+",need_score=yes";
        StringBuilder taskConfig = new StringBuilder();
        taskConfig.append("capkey=").append(capKey.getCode()).append(",");
        if(capKey.getCode().contains("template")){
            taskConfig.append("property=").append(templateEnum.getProperty()).append(",");
            taskConfig.append("templateIndex=").append(templateEnum.getTemplateIndex()).append(",");
            taskConfig.append("templatePageindex=").append(templateEnum.getTemplatePageIndex()).append(",");
        }
        taskConfig.append("need_score=").append(needScore);

        postMethod.setRequestHeader("x-task-config",taskConfig.toString());
        postMethod.setRequestHeader("x-session-key",getXsessionkey(nowDate, developerkey));
        postMethod.setRequestHeader("x-result-format", "xml");
        postMethod.setRequestBody(bInputStream);
        httpClient.executeMethod(postMethod);
        byte[] responseBody=postMethod.getResponseBody();
        return responseBody;
    }

    //生成灵云平台请求的SessionKey密钥
    private String getXsessionkey(String currentTime,String developerkey) {
        try {
            MessageDigest md=MessageDigest.getInstance("MD5");
            byte[] messageByte = (currentTime+developerkey).getBytes("UTF-8");
            byte[] md5Byte = md.digest(messageByte);
            return byteToHex(md5Byte);

        } catch (Exception e) {
            // TODO: handle exception
        }
        return developerkey;

    }

    //Byte2Hex
    private String byteToHex(byte[] bytes) {
        StringBuffer hexStr = new StringBuffer();
        int num;
        for (int count = 0; count < bytes.length; count++) {
            num = bytes[count];
            if(num < 0) {
                num += 256;
            }
            if(num < 16){
                hexStr.append("0");
            }
            hexStr.append(Integer.toHexString(num));
        }
        return hexStr.toString().toUpperCase();
    }
}
