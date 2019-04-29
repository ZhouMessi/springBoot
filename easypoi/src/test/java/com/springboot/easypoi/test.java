package com.springboot.easypoi;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import com.springboot.easypoi.entity.*;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

import static com.springboot.easypoi.common.util.CustomExcelUtil.exportExcel;
import static com.springboot.easypoi.common.util.CustomExcelUtil.readerAndReturnByAP;

public class test {

    @Test
    public void add() throws IOException {
        //导入参数配置
        ImportParams importParams=new ImportParams();
        //根据导入的文件获取对应的list集合信息
        List<User> list = readerAndReturnByAP("E:\\demo\\demo.xls",importParams,User.class);
        User user=new User();
        user.setId("1");
        user.setAge(22);
        user.setBirthday(DateUtils.addYears(new Date(),-10));
        user.setName("赵六");
        list.add(user);
        //导出参数设置
        ExportParams exportParams=new ExportParams();
        exportParams.setTitle("员工信息表");
        exportParams.setSheetName("员工");
        //导出对应的list,并配置参数
        exportExcel(list,"demo02",User.class,exportParams);
    }



    @Test
    public void test(){
        ImportParams importParams=new ImportParams();
        //如果有标题必须要配置否则会报错
        importParams.setTitleRows(1);
        List<User> list = readerAndReturnByAP("E:\\demo\\demo02.xls",importParams,User.class);
        for (User user : list) {
            System.out.println("成功列表信息:ID=" + user.getId() +"--姓名="+ user.getName() + "--年龄="+user.getAge()
                    + "--生日=" + new SimpleDateFormat("yyyy-MM-dd").format(user.getBirthday()));
        }

    }


    @Test
    public void ready() throws IOException {
        ImportParams importParams=new ImportParams();
        //如果有标题必须要配置否则会报错
        importParams.setTitleRows(1);
        List<AliPayExceptionOrder> list = readerAndReturnByAP("D:\\IDE\\Github\\springBoot\\springBoot\\easypoi\\3月份测试明细.xls",importParams, AliPayExceptionOrder.class);

        for (AliPayExceptionOrder aliPayExceptionOrder : list) {
            System.out.println("账务流水号"+aliPayExceptionOrder.getFinancialSerialNum());
            System.out.println("业务流水号"+aliPayExceptionOrder.getBusinessSerialNum());
            System.out.println("商户订单号"+aliPayExceptionOrder.getMerchantOrderNum());
            System.out.println("商品名称"+aliPayExceptionOrder.getProductName());
            System.out.println("发生时间"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(aliPayExceptionOrder.getOccurrenceTime()));
            System.out.println("对方账号"+aliPayExceptionOrder.getAdverseAccount());
            System.out.println("收入金额（+元）"+aliPayExceptionOrder.getIncome());
            System.out.println("支出金额（-元）"+aliPayExceptionOrder.getAmountPaid());
            System.out.println("账户余额（元）"+aliPayExceptionOrder.getAccountBalance());
            System.out.println("交易渠道"+aliPayExceptionOrder.getTransaction());

            System.out.println("------------------------------");
        }


        //导出参数设置
        ExportParams exportParams=new ExportParams();
        exportParams.setTitle("3月份支付宝异常订单");
        exportParams.setSheetName("支付宝异常订单");
        //导出对应的list,并配置参数
        exportExcel(list,"aliPayOrder",AliPayExceptionOrder.class,exportParams);
    }

    @Test
    public void readerPOJO2(){
        ImportParams importParams=new ImportParams();
        //如果有标题必须要配置否则会报错
        importParams.setTitleRows(0);
        //读取指定的sheet,比如要读取上传得第二个sheet 那么需要把startSheetIndex = 1 就可以了
        importParams.setStartSheetIndex(1);
        List<ConvergeGatheringTest> list = readerAndReturnByAP("D:\\IDE\\Github\\springBoot\\springBoot\\easypoi\\3月份测试明细.xls",importParams, ConvergeGatheringTest.class);

        int count=1;

        for (ConvergeGatheringTest convergeGatheringTest : list) {
            System.out.println("商户编号"+convergeGatheringTest.getMerchantNo());
            System.out.println("商户名称"+convergeGatheringTest.getMerchantName());
            System.out.println("创建时间"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(convergeGatheringTest.getCreateTime()));
            System.out.println("支付时间(年月日)"+new SimpleDateFormat("yyyy-MM-dd").format(convergeGatheringTest.getPayTimeYMD()));
            System.out.println("支付时间(时分秒)"+new SimpleDateFormat("HH:mm:ss").format(convergeGatheringTest.getPayTimeHMS()));
            System.out.println("商户订单号"+convergeGatheringTest.getMerchantOrderNum());
            System.out.println("支付流水号"+convergeGatheringTest.getPaySerialNum());
            System.out.println("支付方式"+convergeGatheringTest.getPayType());
            System.out.println("订单状态"+convergeGatheringTest.getOrderStatus());
            System.out.println("订单金额"+convergeGatheringTest.getOrderMoney());
            System.out.println("手续费"+convergeGatheringTest.getOrderNum());
            System.out.println("产品名称"+convergeGatheringTest.getProductName());

            System.out.println("这是第"+count+"个");
            count++;
        }
    }

    @Test
    public void readerPOJO3(){
        ImportParams importParams=new ImportParams();
        //如果有标题必须要配置否则会报错
        importParams.setTitleRows(1);
        //读取指定的sheet,比如要读取上传得第二个sheet 那么需要把startSheetIndex = 1 就可以了
        importParams.setStartSheetIndex(2);
        List<ConvergeExceptionOrder> list = readerAndReturnByAP("E:\\springBoot\\easypoi\\3月份测试明细.xls",importParams, ConvergeExceptionOrder.class);

        int count=1;

        for (ConvergeExceptionOrder convergeExceptionOrder : list) {
            System.out.println("商户编号"+convergeExceptionOrder.getMerchantNo());
            System.out.println("商户名称"+convergeExceptionOrder.getMerchantName());
            System.out.println("创建时间"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(convergeExceptionOrder.getCreateTime()));
            System.out.println("支付时间(年月日)"+new SimpleDateFormat("yyyy-MM-dd").format(convergeExceptionOrder.getPayTimeYMD()));
            System.out.println("支付时间(时分秒)"+new SimpleDateFormat("HH:mm:ss").format(convergeExceptionOrder.getPayTimeHMS()));
            System.out.println("商户订单号"+convergeExceptionOrder.getMerchantOrderNum());
            System.out.println("支付流水号"+convergeExceptionOrder.getPaySerialNum());
            System.out.println("支付方式"+convergeExceptionOrder.getPayType());
            System.out.println("订单状态"+convergeExceptionOrder.getOrderStatus());
            System.out.println("订单金额"+convergeExceptionOrder.getOrderMoney());
            System.out.println("手续费"+convergeExceptionOrder.getOrderNum());

            System.err.println("这是第"+count+"个");
            count++;
        }
    }

    @Test
    public void readerPOJO4(){
        ImportParams importParams=new ImportParams();
        //如果有标题必须要配置否则会报错
        importParams.setTitleRows(0);
        //读取指定的sheet,比如要读取上传得第二个sheet 那么需要把startSheetIndex = 1 就可以了
        importParams.setStartSheetIndex(3);
        List<ConvergeRefundTest> list = readerAndReturnByAP("E:\\springBoot\\easypoi\\3月份测试明细.xls",importParams, ConvergeRefundTest.class);

        int count=1;

        for (ConvergeRefundTest convergeRefundTest : list) {
            System.out.println("商户编号"+convergeRefundTest.getMerchantNo());
            System.out.println("商户名称"+convergeRefundTest.getMerchantName());
            System.out.println("退款请求时间"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(convergeRefundTest.getRefundApplyTime()));
            System.out.println("退款完成时间(年月日)"+new SimpleDateFormat("yyyy-MM-dd").format(convergeRefundTest.getRefundSuccessTime1()));
            System.out.println("退款完成时间(时分秒)"+new SimpleDateFormat("HH:mm:ss").format(convergeRefundTest.getRefundSuccessTime2()));
            System.out.println("原商户订单号"+convergeRefundTest.getOriginalMerchantOrderNum());
            System.out.println("原支付流水号"+convergeRefundTest.getOriginalPaySerialNum());
            System.out.println("退款流水号"+convergeRefundTest.getRefundSerialNum());
            System.out.println("商户退款订单号"+convergeRefundTest.getMerchantRefundOrderNum());
            System.out.println("退款金额"+convergeRefundTest.getRefundMoney());
            System.out.println("退款手续费"+convergeRefundTest.getRefundPoundage());
            System.out.println("退款状态"+convergeRefundTest.getRefundState());
            System.out.println("退款方式"+convergeRefundTest.getRefundWay());
            System.out.println("退款申请原因"+convergeRefundTest.getRefundApplyCause());

            System.err.println("这是第"+count+"个");
            count++;
        }
    }

    @Test
    public void readerPOJO5(){
        ImportParams importParams=new ImportParams();
        //如果有标题必须要配置否则会报错
        importParams.setTitleRows(1);
        //读取指定的sheet,比如要读取上传得第二个sheet 那么需要把startSheetIndex = 1 就可以了
        importParams.setStartSheetIndex(4);
        List<AliPayRefundTest> list = readerAndReturnByAP("E:\\springBoot\\easypoi\\3月份测试明细.xls",importParams, AliPayRefundTest.class);

        int count=1;

        for (AliPayRefundTest aliPayRefundTest : list) {
            System.out.println("账务流水号"+aliPayRefundTest.getFinancialSerialNum());
            System.out.println("业务流水号"+aliPayRefundTest.getBusinessSerialNum());
            System.out.println("商户订单号"+aliPayRefundTest.getMerchantOrderNum());
            System.out.println("商品名称"+aliPayRefundTest.getProductName());
            System.out.println("发生时间"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(aliPayRefundTest.getOccurrenceTime()));
            System.out.println("对方账号"+aliPayRefundTest.getAdverseAccount());
            System.out.println("收入金额（+元）"+aliPayRefundTest.getIncome());
            System.out.println("支出金额（-元）"+aliPayRefundTest.getAmountPaid());
            System.out.println("账户余额（元）"+aliPayRefundTest.getAccountBalance());
            System.out.println("交易渠道"+aliPayRefundTest.getTransaction());
            System.out.println("业务类型"+aliPayRefundTest.getServiceType());
            System.out.println("备注"+aliPayRefundTest.getReMark());

            System.err.println("这是第"+count+"个");
            count++;
        }
    }

    @Test
    public void readerPOJO6(){
        ImportParams importParams=new ImportParams();
        //如果有标题必须要配置否则会报错
        importParams.setTitleRows(1);
        //读取指定的sheet,比如要读取上传得第二个sheet 那么需要把startSheetIndex = 1 就可以了
        importParams.setStartSheetIndex(5);
        List<AliPayOnLineTest> list = readerAndReturnByAP("E:\\springBoot\\easypoi\\3月份测试明细.xls",importParams, AliPayOnLineTest.class);

        int count=1;

        for (AliPayOnLineTest aliPayOnLineTest : list) {
            System.out.println("账务流水号"+aliPayOnLineTest.getFinancialSerialNum());
            System.out.println("业务流水号"+aliPayOnLineTest.getBusinessSerialNum());
            System.out.println("商户订单号"+aliPayOnLineTest.getMerchantOrderNum());
            System.out.println("商品名称"+aliPayOnLineTest.getProductName());
            System.out.println("发生时间"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(aliPayOnLineTest.getOccurrenceTime()));
            System.out.println("对方账号"+aliPayOnLineTest.getAdverseAccount());
            System.out.println("收入金额（+元）"+aliPayOnLineTest.getIncome());
            System.out.println("支出金额（-元）"+aliPayOnLineTest.getAmountPaid());
            System.out.println("账户余额（元）"+aliPayOnLineTest.getAccountBalance());
            System.out.println("交易渠道"+aliPayOnLineTest.getTransaction());
            System.out.println("业务类型"+aliPayOnLineTest.getServiceType());
            System.out.println("备注"+aliPayOnLineTest.getReMark());

            System.err.println("这是第"+count+"个");
            count++;
        }
    }


    @Test
    public void sheets(){
        Workbook workbook=null;
        FileOutputStream fos=null;
        try{
            ImportParams importParams=new ImportParams();
            //如果有标题必须要配置否则会报错
            importParams.setTitleRows(1);
            List<AliPayExceptionOrder> AliPayList = readerAndReturnByAP("E:\\springBoot\\easypoi\\3月份测试明细.xls",importParams, AliPayExceptionOrder.class);


            //创建参数对象(用来设定excel的sheet的内容信息)
            ExportParams AliPayParam=new ExportParams();
            //设置sheet名字
            AliPayParam.setSheetName("三月份支付宝异常订单");
            AliPayParam.setTitle("3月份支付宝异常订单");
            //创建sheet1使用的map
            Map<String,Object> AliPayMap=new HashMap<>();
            //title的参数为ExportParams类型,目前仅仅在AliPayParam中设置了sheetName
            AliPayMap.put("title",AliPayParam);
            //模板导出对应的实体类型
            AliPayMap.put("entity",AliPayExceptionOrder.class);
            //sheet中要填充的数据
            AliPayMap.put("data",AliPayList);


            ImportParams importParams2=new ImportParams();
            //如果有标题必须要配置否则会报错
            importParams2.setTitleRows(0);
            //读取指定的sheet,比如要读取上传得第二个sheet 那么需要把startSheetIndex = 1 就可以了
            importParams2.setStartSheetIndex(1);
            List<ConvergeGatheringTest> list = readerAndReturnByAP("E:\\springBoot\\easypoi\\3月份测试明细.xls",importParams2, ConvergeGatheringTest.class);

            //创建参数对象(用来设定excel的sheet的内容信息)
            ExportParams exportParams=new ExportParams();
            //设置sheet名字
            exportParams.setSheetName("汇聚收款测试");
            //创建sheet1使用的map
            Map<String,Object> map2=new HashMap<>();
            map2.put("title",exportParams);
            map2.put("entity",ConvergeGatheringTest.class);
            map2.put("data",list);

            // 将sheet1、sheet2、sheet3使用得map进行包装
            List<Map<String, Object>> sheetsList = new ArrayList<>();
            sheetsList.add(AliPayMap);
            sheetsList.add(map2);

            //执行方法
            workbook = ExcelExportUtil.exportExcel(sheetsList, ExcelType.HSSF);
            //保存数据

            fos=new FileOutputStream("整合多个sheets表.xls");
            workbook.write(fos);
            System.out.println("导入数据完成");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                fos.close();
                workbook.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}