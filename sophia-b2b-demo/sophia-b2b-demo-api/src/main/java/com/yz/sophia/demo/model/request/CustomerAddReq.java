package com.yz.sophia.demo.model.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.yz.sophia.demo.model.vo.UploadFile;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
@ToString
public class CustomerAddReq {

    @ApiModelProperty("客户ID")
    private Long id;

    /*基本信息*/
    @ApiModelProperty("客户名称")
    private String customerName;

    @ApiModelProperty("一级客户分类")
    private String firstCategoryCode;

    @ApiModelProperty("二级客户分类")
    private String secondCategoryCode;

    @ApiModelProperty("三级客户分类")
    private String thirdCategoryCode;

    @ApiModelProperty("客户分类ID")
    private Integer customerCategoryId;

    //@Size(max = 2, message = "档案分类超过最大长度")
    @ApiModelProperty("档案分类 01法人，02政府/事业单位，03军队，04其他非法人，05一次性客户'")
    private String archiveCategory;

    //@Size(max = 2, message = "合作模式超过最大长度")
    @ApiModelProperty("合作模式 01长期客户 02临时客户")
    private String cooperationMode;

    @ApiModelProperty("统一社会信用代码")
    private String socialCreditCode;

    @ApiModelProperty("营业执照名称")
    private String businessLicense;

    @ApiModelProperty("法定代表人")
    private String legalPersonName;

    @ApiModelProperty("法定代表人身份证号")
    private String legalPersonIdcard;

    @ApiModelProperty("注册资本")
    private String registeredCapital;

    //@Size(max = 11, message = "联系电话超过最大长度")
    @ApiModelProperty("联系电话")
    private String phone;

    @ApiModelProperty("联系人姓名")
    private String contactPerson;

    @ApiModelProperty("传真")
    private String fax;

    @ApiModelProperty("国家")
    private String countryCode;

    //@Size(max = 6, message = "邮政编码超过最大长度")
    @ApiModelProperty("邮政编码")
    private String postCode;

    @ApiModelProperty("开票名称1")
    private String invoiceName;

    @ApiModelProperty("开票名称2")
    private String invoiceName2;

    @ApiModelProperty("客户地址-省（传sapCode）")
    private String regionProvince;

    @ApiModelProperty("客户地址-省")
    private String regionProvinceName;

    @ApiModelProperty("客户地址-市（传regionName）")
    private String regionCity;

    @ApiModelProperty("客户地址-区（传regionName）")
    private String regionArea;

    @ApiModelProperty("客户地址-详细地址")
    private String addressDetails;

    @ApiModelProperty("附件")
    private List<UploadFile> uploadFileList;

    /*银行信息*/
    @ApiModelProperty("银行账号")
    private String bankAccountNumber;

    @ApiModelProperty("银行账号户主")
    private String bankAccountName;

    @ApiModelProperty("开户银行")
    private String bankName;

    @ApiModelProperty("银行联行号")
    private String bankNumber;

    @ApiModelProperty("打款账号")
    private String bankAccountNumber2;

    /*财务信息*/
    @ApiModelProperty("公司代码")
    private String companyCode;

    //@Size(max = 4, message = "付款条件超过最大长度")
    @ApiModelProperty("付款条件")
    private String paymentTerms;

    //@Size(max = 2, message = "支付方式超过最大长度")
    @ApiModelProperty("支付方式 01转账、02现金（刷卡）、03支票、04信控、05账扣")
    private String payMode;

    //@Size(max = 2, message = "账期超过最大长度")
    @ApiModelProperty("账期 01（无账期），02（7天），03（15天），04（30天），05（45天），06（60天），07（90天）")
    private String paymentDays;

    @ApiModelProperty("计划销售金额")
    private BigDecimal planSalesAmount;

    @ApiModelProperty("签单金额")
    private BigDecimal writtenAmount;

    /*销售信息*/
    @ApiModelProperty("所属门店")
    private String b2bShopCode;

    @ApiModelProperty("所属门店")
    private String b2bShopName;

    @ApiModelProperty("业务对接人")
    private Long salesUserId;

    @ApiModelProperty("业务对接人姓名")
    private String salesUserName;

    //@Size(max = 2, message = "祱分类超过最大长度")
    @ApiModelProperty("祱分类")
    private String taxesCategory;

    @ApiModelProperty("所属省区")
    private String salesProvince;

    /*信控信息*/
    //@Size(max = 2, message = "客户级别超过最大长度")
    @ApiModelProperty("客户级别")
    private String customerLevel;

    @ApiModelProperty("信控额度")
    private BigDecimal creditLimit;

    @ApiModelProperty("临时额度")
    private BigDecimal tempCreditLimit;

    @ApiModelProperty("临时客户有效起始时间yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone="GMT+8")
    private Date tempBeginTime;

    @ApiModelProperty("临时客户有效结束时间yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone="GMT+8")
    private Date tempEndTime;
}
