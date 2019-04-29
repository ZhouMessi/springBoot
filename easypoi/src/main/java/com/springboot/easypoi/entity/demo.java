package com.springboot.easypoi.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;


@Entity
@ExcelTarget("user")
public class demo {

    @Id
    @GeneratedValue
    @Excel(name = "编号", orderNum = "1", mergeVertical = true, isImportField = "id")
    private int id;
    @Excel(name = "姓名", orderNum = "2", mergeVertical = true, isImportField = "name")
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

