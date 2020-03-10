package com.yz.sophia.insight.controller;

import com.yz.sophia.business.api.entity.CommonResponse;
import com.yz.sophia.business.api.entity.Page;
import com.yz.sophia.insight.model.po.AlgorithmDataset;
import com.yz.sophia.insight.model.po.ProductInsight;
import com.yz.sophia.insight.model.vo.LineChartDataVo;
import com.yz.sophia.insight.provider.AlgorithmDatasetProvider;
import com.yz.sophia.insight.provider.ProductInsightProvider;
import com.yz.sophia.insight.service.AlgorithmDatasetService;
import com.yz.sophia.insight.service.ProductInsightService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.bouncycastle.jcajce.provider.config.ConfigurableProvider;
import org.bouncycastle.jcajce.provider.util.AlgorithmProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;


/**
 * 算法训练数据集
 */
@Slf4j
@CrossOrigin(origins = "*",maxAge = 3600)
@RestController("/algorithm")
public class AlgorithmDatasetController extends BaseController implements AlgorithmDatasetProvider {


    @Autowired
    private AlgorithmDatasetService datasetService;

    @Override
    @RequestMapping(
            value = {"/listAlgorithmDataset"},
            method = {RequestMethod.GET},
            produces = {"application/json;charset=UTF-8"}
    )
    @ApiOperation(
            value = "算法训练数据集检索",
            notes = "算法训练数据集检索"
    )
    @ResponseBody
    public CommonResponse<Page<AlgorithmDataset>> listAlgorithmDataset(@ApiParam(name = "category", value = "类别", defaultValue = "文本", required = false) @RequestParam(name = "category", required = false) String category,
                                                                       Integer pageIndex, Integer pageSize) {
        CommonResponse<Page<AlgorithmDataset>> respData = new CommonResponse<Page<AlgorithmDataset>>();
        try {
            respData = super.visit(() -> {

                Page<AlgorithmDataset> page = datasetService.listAlgorithmDataset(category, null, null, pageIndex, pageSize);
                return page;
            });
        } catch (Exception e) {
            log.info("算法训练数据集检索异常：e:"+e.getMessage());
            e.printStackTrace();
        }
        return respData;
    }

}
