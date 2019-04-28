package com.springboot.easypoi.controller;

import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import cn.afterturn.easypoi.excel.entity.TemplateExportParams;
import cn.afterturn.easypoi.excel.entity.result.ExcelImportResult;
import cn.afterturn.easypoi.handler.inter.IExcelDataHandler;
import com.alibaba.fastjson.JSONObject;
import com.springboot.easypoi.common.util.ExcelUtil;
import com.springboot.easypoi.entity.EasyPOIModel;
import com.springboot.easypoi.entity.User;
import com.springboot.easypoi.handler.UserExcelHandler;
import org.apache.coyote.Response;
import org.apache.poi.ss.usermodel.Workbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("lms")
public class excelController {
    private static final Logger log = LoggerFactory.getLogger(excelController.class);


    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String hello() {
        return "userTem";
    }

    @RequestMapping(value = "/demo",method = {RequestMethod.GET})
    public String demo(){
        return "userTem";
    }

    @RequestMapping(value = "/excelImportLock",produces = "application/json;charset=utf-8",method = RequestMethod.POST)
    @ResponseBody
    public JSONObject excelImport(@RequestParam("file") MultipartFile file) {

        JSONObject json = new JSONObject();
        ImportParams importParams = new ImportParams();
        // 数据处理
        IExcelDataHandler<User> handler = new UserExcelHandler();
        handler.setNeedHandlerFields(new String[] { "姓名" });// 注意这里对应的是excel的列名。也就是对象上指定的列名。
        importParams.setDataHanlder(handler);

        // 需要验证
        importParams.setNeedVerfiy(true);

        try {
            ExcelImportResult<User> result = ExcelImportUtil.importExcelMore(file.getInputStream(), User.class,
                    importParams);

            List<User> successList = result.getList();
            List<User> failList = result.getFailList();

            log.info("是否存在验证未通过的数据:" + result.isVerfiyFail());
            log.info("验证通过的数量:" + successList.size());
            log.info("验证未通过的数量:" + failList.size());

            for (User user : successList) {
                log.info("成功列表信息:ID=" + user.getId() + user.getName() + "-"
                        + new SimpleDateFormat("yyyy-MM-dd").format(user.getBirthday()));
            }
            for (User user : failList) {
                log.info("失败列表信息:" + user.getName());
            }
            json.put("returnMsg", "导入数据成功");
            json.put("returnCode", "000000");
        } catch (IOException e) {
            log.error(e.getMessage(), e);

            json.put("returnMsg", "I/O异常");
            json.put("returnCode", "111111");

        } catch (Exception e) {
            log.error(e.getMessage(), e);
            json.put("returnMsg", "特殊异常");
            json.put("returnCode", "222222");

        }

        return json;
    }


}
