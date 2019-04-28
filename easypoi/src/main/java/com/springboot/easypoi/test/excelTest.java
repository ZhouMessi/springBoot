package com.springboot.easypoi.test;
import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import com.springboot.easypoi.entity.StudentEntity;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class excelTest {
    public static void main(String[] args) throws IOException {

        List<StudentEntity>list=new ArrayList<>();
        StudentEntity studentEntity=new StudentEntity();
        studentEntity.setId("1");
        studentEntity.setBirthday(DateUtils.addYears(new Date(),-10));
        studentEntity.setName("张三");
        studentEntity.setRegistrationDate(DateUtils.addYears(new Date(),-5));
        studentEntity.setSex(4564);
        list.add(studentEntity);

        StudentEntity studentEntity1=new StudentEntity();
        studentEntity1.setId("2");
        studentEntity1.setBirthday(DateUtils.addYears(new Date(),-9));
        studentEntity1.setName("李四");
        studentEntity1.setRegistrationDate(DateUtils.addYears(new Date(),-5));
        studentEntity1.setSex(18);
        list.add(studentEntity1);

        Workbook workbook=ExcelExportUtil.exportExcel(new ExportParams("计算机一班学生","学生"), StudentEntity.class,list);
        //保存数据
        FileOutputStream fos=new FileOutputStream("student.xls");
        workbook.write(fos);
        fos.close();
    }
}