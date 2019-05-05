package com.springboot.easypoi.controller;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import com.springboot.easypoi.entity.ConvergeGatheringTest;
import com.springboot.easypoi.entity.demo;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.util.StringUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

@Controller
@RequestMapping("excel")
public class excelController {
    Logger log= Logger.getLogger(String.valueOf(excelController.class));

    @RequestMapping(value = "/hello",method = {RequestMethod.GET})
    public String hello(){
        return "excel";
    }


//    @ResponseBody
//    @PostMapping(value="/excelImportLock",produces="application/json;charset=utf-8")
//    public JSONObject excelImport(@RequestParam("file") MultipartFile file) {
//
//        JSONObject json = new JSONObject();
//        ImportParams importParams = new ImportParams();
//        // 数据处理
//        IExcelDataHandler<User> handler = new UserExcelHandler();
//        handler.setNeedHandlerFields(new String[] { "姓名" });// 注意这里对应的是excel的列名。也就是对象上指定的列名。
//        importParams.setDataHanlder(handler);
//
//        // 需要验证
//        importParams.setNeedVerfiy(true);
//
//        try {
//            ExcelImportResult<User> result = ExcelImportUtil.importExcelMore(file.getInputStream(), User.class,
//                    importParams);
//
//            List<User> successList = result.getList();
//            List<User> failList = result.getFailList();
//
//            log.info("是否存在验证未通过的数据:" + result.isVerfiyFail());
//            log.info("验证通过的数量:" + successList.size());
//            log.info("验证未通过的数量:" + failList.size());
//
//            for (User user : successList) {
//                log.info("成功列表信息:ID=" + user.getId() + user.getName() + "-"
//                        + new SimpleDateFormat("yyyy-MM-dd").format(user.getBirthday()));
//            }
//            for (User user : failList) {
//                log.info("失败列表信息:" + user.getName());
//            }
//            json.put("returnMsg", "导入数据成功");
//            json.put("returnCode", "000000");
//        } catch (IOException e) {
//
//            json.put("returnMsg", "I/O异常");
//            json.put("returnCode", "111111");
//
//        } catch (Exception e) {
//            json.put("returnMsg", "特殊异常");
//            json.put("returnCode", "222222");
//
//        }
//
//        return json;
//    }

    @RequestMapping(value = "/downloadExcel")
    public void downLoad(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // 告诉浏览器用什么软件可以打开此文件
        response.setHeader("content-Type", "application/vnd.ms-excel");
        // 下载文件的默认名称
        response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode("用户数据表","UTF-8") + ".xls");
        //编码
        response.setCharacterEncoding("UTF-8");
        List<demo>list=new ArrayList<>();
        demo d=new demo();
        d.setId(1);
        d.setName("张三");
        list.add(d);
        demo d2=new demo();
        d2.setId(2);
        d2.setName("李四");
        list.add(d2);

        Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams(), demo.class, list);
        workbook.write(response.getOutputStream());

    }

    @RequestMapping("/hello2")
    public String hello(Model model) {
        model.addAttribute("name", "world");
        return "hello";
    }

    /*public void excel150() throws IOException {
        L.info("正在匹配核对150环境信息");

        UploadFile tempfile = getFile();
        File file = tempfile.getFile();
        ImportParams importParams=new ImportParams();

        String mypath="";
        String path = new File("").getAbsolutePath().replaceAll("\\\\", "/"); //获得Tomcat的默认路径
        mypath = path.substring(0,path.lastIndexOf("/"))+"/webapps/"+ DateUtil.DateToString(new Date(), DateStyle.YYYY_MM_DD_HH_MM_SS_NOSPLIT)+".xls"; //截取字符串
        FileOutputStream os = new FileOutputStream(mypath);

        String sql="select cash from t_trade  where no = ?";
        //如果有标题必须要配置否则会报错
        importParams.setTitleRows(0);
        //读取指定的sheet,比如要读取上传得第二个sheet 那么需要把startSheetIndex = 1 就可以了
        // importParams.setStartSheetIndex(1);
        List<ConvergeGatheringTest> list = readerAndReturnByFile(file,importParams, ConvergeGatheringTest.class);
        int count=1;
        for (ConvergeGatheringTest convergeGatheringTest : list) {
            String merchantOrderNum = convergeGatheringTest.getMerchantOrderNum();
            Double o = Db.queryColumn(sql, merchantOrderNum);
            if(StringUtil.notNull(o)){
                convergeGatheringTest.setEnvironment150(o);
            }
            // System.out.println("商户编号"+convergeGatheringTest.getMerchantNo());
            // System.out.println("商户名称"+convergeGatheringTest.getMerchantName());
            // System.out.println("创建时间"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(convergeGatheringTest.getCreateTime()));
            // System.out.println("支付时间(年月日)"+new SimpleDateFormat("yyyy-MM-dd").format(convergeGatheringTest.getPayTimeYMD()));
            // System.out.println("支付时间(时分秒)"+new SimpleDateFormat("HH:mm:ss").format(convergeGatheringTest.getPayTimeHMS()));
            // System.out.println("商户订单号"+convergeGatheringTest.getMerchantOrderNum());
            // System.out.println("支付流水号"+convergeGatheringTest.getPaySerialNum());
            // System.out.println("支付方式"+convergeGatheringTest.getPayType());
            // System.out.println("订单状态"+convergeGatheringTest.getOrderStatus());
            // System.out.println("订单金额"+convergeGatheringTest.getOrderMoney());
            // System.out.println("手续费"+convergeGatheringTest.getOrderNum());
            // System.out.println("产品名称"+convergeGatheringTest.getProductName());

            System.out.println("这是第"+count+"个");
            count++;
        }

        //导出参数设置
        ExportParams exportParams=new ExportParams();
        exportParams.setSheetName("汇聚收款模块");

        Workbook workbook = ExcelExportUtil.exportExcel(exportParams, ConvergeGatheringTest.class, list);
        workbook.write(os);


        //判断路径是否存在
        if(new File(mypath).isFile()){
            renderFile(new File(mypath));
        }else{
            renderNull();
        }


    }*/
}
