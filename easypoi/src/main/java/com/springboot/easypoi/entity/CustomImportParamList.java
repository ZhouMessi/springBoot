package com.springboot.easypoi.entity;

import cn.afterturn.easypoi.excel.entity.ImportParams;

/**
 * 2019年4月29日15:19:08
 * 周洲
 * 自定义导入参数列表
 */
public class CustomImportParamList {

    private ImportParams aliPayExceptionOrderIP=new ImportParams();

    private ImportParams aliPayOnLineTestIP=new ImportParams();

    private ImportParams aliPayRefundTestIP=new ImportParams();

    private ImportParams convergeExceptionOrderIP=new ImportParams();

    private ImportParams convergeGatheringTestIP=new ImportParams();

    private ImportParams convergeRefundTestIP=new ImportParams();

    //初始化配置参数如果以后格式有变化只需要在这里改
    public CustomImportParamList() {
        this.aliPayExceptionOrderIP.setTitleRows(1);

        this.aliPayOnLineTestIP.setTitleRows(1);
        this.aliPayOnLineTestIP.setStartSheetIndex(5);

        this.aliPayRefundTestIP.setTitleRows(1);
        this.aliPayRefundTestIP.setStartSheetIndex(4);

        this.convergeExceptionOrderIP.setTitleRows(1);
        this.convergeExceptionOrderIP.setStartSheetIndex(2);

        this.convergeGatheringTestIP.setStartSheetIndex(1);

        this.convergeRefundTestIP.setStartSheetIndex(3);
    }

    public ImportParams getAliPayExceptionOrderIP() {
        return aliPayExceptionOrderIP;
    }

    public void setAliPayExceptionOrderIP(ImportParams aliPayExceptionOrderIP) {
        this.aliPayExceptionOrderIP = aliPayExceptionOrderIP;
    }

    public ImportParams getAliPayOnLineTestIP() {
        return aliPayOnLineTestIP;
    }

    public void setAliPayOnLineTestIP(ImportParams aliPayOnLineTestIP) {
        this.aliPayOnLineTestIP = aliPayOnLineTestIP;
    }

    public ImportParams getAliPayRefundTestIP() {
        return aliPayRefundTestIP;
    }

    public void setAliPayRefundTestIP(ImportParams aliPayRefundTestIP) {
        this.aliPayRefundTestIP = aliPayRefundTestIP;
    }

    public ImportParams getConvergeExceptionOrderIP() {
        return convergeExceptionOrderIP;
    }

    public void setConvergeExceptionOrderIP(ImportParams convergeExceptionOrderIP) {
        this.convergeExceptionOrderIP = convergeExceptionOrderIP;
    }

    public ImportParams getConvergeGatheringTestIP() {
        return convergeGatheringTestIP;
    }

    public void setConvergeGatheringTestIP(ImportParams convergeGatheringTestIP) {
        this.convergeGatheringTestIP = convergeGatheringTestIP;
    }

    public ImportParams getConvergeRefundTestIP() {
        return convergeRefundTestIP;
    }

    public void setConvergeRefundTestIP(ImportParams convergeRefundTestIP) {
        this.convergeRefundTestIP = convergeRefundTestIP;
    }
}
