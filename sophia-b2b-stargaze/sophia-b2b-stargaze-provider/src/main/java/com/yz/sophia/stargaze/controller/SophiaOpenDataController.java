package com.yz.sophia.stargaze.controller;

import com.yz.sophia.business.api.entity.CommonResponse;
import com.yz.sophia.business.api.entity.Page;
import com.yz.sophia.stargaze.model.po.SophiaOpenService;
import com.yz.sophia.stargaze.model.response.SophiaOpenDataResp;
import com.yz.sophia.stargaze.provider.SophiaOpenDataProvider;
import com.yz.sophia.stargaze.service.SophiaOpenDataService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * 观星台驾驶舱数据
 */
@Slf4j
@CrossOrigin(origins = "*",maxAge = 3600)
@RestController("/sophiaOpenData")
public class SophiaOpenDataController extends BaseController implements SophiaOpenDataProvider {


    @Autowired
    private SophiaOpenDataService sophiaOpenDataService;

    @Override
    @ResponseBody
    @ApiOperation(value = "查询服务检索数据")
    @RequestMapping(value="/listSophiaOpenData",method = RequestMethod.POST)
    public CommonResponse<SophiaOpenDataResp> listSophiaOpenData(@ApiParam(name="keyword", value="关键词, 例如：语音", defaultValue="语音", required=false) @RequestParam(name = "keyword", required = false) String keyword,
                                                                 @ApiParam(name="orderField", value="排序字段, 例如：创建时间=create_time, 算法类型=product_module", defaultValue="create_time", required=false) @RequestParam(name = "orderField", required = false) String orderField,
                                                                 @ApiParam(name="orderType", value="排序类型, 例如：升序=asc, 降序=desc", defaultValue="desc", required=false) @RequestParam(name = "orderType", required = false) String orderType,
                                                                 Integer pageIndex, Integer pageSize) {
        CommonResponse<SophiaOpenDataResp> respData = new CommonResponse<>();

        try {
            respData = super.visit(() -> {
                Page<SophiaOpenService> page = sophiaOpenDataService.listOpenServiceDataByKeyword(keyword, orderField, orderType, pageIndex, pageSize);
                log.info("查询服务检索数据结果:", page.toString());
                SophiaOpenDataResp resp = new SophiaOpenDataResp();
                resp.setSophiaOpenData(page);
                return resp;
            });
        } catch (Exception e) {
            log.info("查询服务检索数据接口异常：e:"+e.getMessage());
            e.printStackTrace();
        }
        return respData;
    }

}
