package com.springboot.easypoi.handler;

import cn.afterturn.easypoi.handler.impl.ExcelDataHandlerDefaultImpl;
import com.springboot.easypoi.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserExcelHandler extends ExcelDataHandlerDefaultImpl<User> {
    private static final Logger log = LoggerFactory.getLogger(UserExcelHandler.class);

    @Override
    public Object importHandler(User obj, String name, Object value) {
        System.out.println("进来了");
        return super.importHandler(obj, name, value);
    }
}
