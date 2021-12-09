package com.sise.makerSpace.exception;

import com.sise.makerSpace.utils.ReturnMsgUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.SQLSyntaxErrorException;

/**
 * @program: yeb
 * @description: 全局异常处理
 * @author: Honors
 * @create: 2021-07-16 14:56
 */
@RestControllerAdvice
public class GlobalException {

    private ReturnMsgUtils returnMsgUtils=new ReturnMsgUtils();

    @ExceptionHandler(SQLException.class)
    public ReturnMsgUtils mySqlException(SQLException e){
        if (e instanceof SQLIntegrityConstraintViolationException){
            return returnMsgUtils.fail("该数据有关联数据，操作失败！");
        }else if (e instanceof SQLSyntaxErrorException){
            return returnMsgUtils.fail("值与数据库的列无法对应，操作失败！");
        }
        //除了上面捕获的知道sql异常，其他sql异常都报这个错误
        return returnMsgUtils.fail("数据异常，操作失败!");
    }
}