package com.springboot.easypoi.controller;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import com.springboot.easypoi.entity.demo;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;
import java.util.ArrayList;
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
}
