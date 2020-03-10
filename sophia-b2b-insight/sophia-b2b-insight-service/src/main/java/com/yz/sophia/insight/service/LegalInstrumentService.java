package com.yz.sophia.insight.service;

import com.github.pagehelper.PageHelper;
import com.yz.sophia.business.api.entity.Page;
import com.yz.sophia.insight.dao.LegalInstrumentInfoMapper;
import com.yz.sophia.insight.dao.LegalInstrumentMapper;
import com.yz.sophia.insight.model.po.LegalInstrument;
import com.yz.sophia.insight.model.po.LegalInstrumentExample;
import com.yz.sophia.insight.model.po.LegalInstrumentInfo;
import com.yz.sophia.insight.model.po.LegalInstrumentInfoExample;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class LegalInstrumentService {

    @Autowired
    private LegalInstrumentMapper legalInstrumentMapper;

    @Autowired
    private LegalInstrumentInfoMapper legalInstrumentInfoMapper;


    public Page<LegalInstrument> queryLegalinStrument(String lawCause, String judgmentType, Integer pageIndex, Integer pageSize) {
        LegalInstrumentExample example = new LegalInstrumentExample();
        LegalInstrumentExample.Criteria criteria = example.createCriteria();

        pageIndex = pageIndex == null ? 1 : pageIndex;
        pageSize = pageSize == null ? 10 : pageSize;

        if(StringUtils.isNotBlank(lawCause)){
            criteria.andLawCauseLike("%" + lawCause + "%");
        }
        if(StringUtils.isNotBlank(judgmentType)){
            criteria.andJudgmentTypeLike("%" + judgmentType + "%");
        }
        int totalCount = legalInstrumentMapper.countByExample(example);

        int offset = (pageIndex - 1) * pageSize;
        example.setOffset(offset);
        example.setPageSize(pageSize);
        example.setOrderByClause("submission_time" + " " + "desc");//排序规则
        List<LegalInstrument> list = legalInstrumentMapper.selectPageByExample(example);
        Page<LegalInstrument> pageInfo = new Page<LegalInstrument>(pageIndex, pageSize, totalCount, list);
        return pageInfo;
    }


    public LegalInstrumentInfo queryLegalInfo(String judgmentCode) {
        log.debug("获取案件文书详情入参，judgmentCode：" + judgmentCode);
        LegalInstrumentInfo legalInstrumentInfo = null;
        LegalInstrumentInfoExample legalInstInfo = new LegalInstrumentInfoExample();
        legalInstInfo.createCriteria().andJudgmentCodeEqualTo(judgmentCode);
        List<LegalInstrumentInfo> legalInstrumentInfos = legalInstrumentInfoMapper.selectByExampleWithBLOBs(legalInstInfo);
        if (legalInstrumentInfos != null) {
            legalInstrumentInfo = legalInstrumentInfos.get(0);
            log.debug("获取案件文书详情返回，legalInstrumentInfo：" + legalInstrumentInfo.toString());
        }
        return legalInstrumentInfo;
    }
}
