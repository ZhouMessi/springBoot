package com.springboot.easypoi;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import com.springboot.easypoi.entity.AliPayExceptionOrder;
import com.springboot.easypoi.entity.ConvergeGatheringTest;
import com.springboot.easypoi.entity.User;
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
    public void sheets(){
        Workbook workbook=null;
        FileOutputStream fos=null;
        try{
            ImportParams importParams=new ImportParams();
            //如果有标题必须要配置否则会报错
            importParams.setTitleRows(1);
            List<AliPayExceptionOrder> AliPayList = readerAndReturnByAP("D:\\IDE\\Github\\springBoot\\springBoot\\easypoi\\3月份测试明细.xls",importParams, AliPayExceptionOrder.class);


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
            List<ConvergeGatheringTest> list = readerAndReturnByAP("D:\\IDE\\Github\\springBoot\\springBoot\\easypoi\\3月份测试明细.xls",importParams2, ConvergeGatheringTest.class);

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