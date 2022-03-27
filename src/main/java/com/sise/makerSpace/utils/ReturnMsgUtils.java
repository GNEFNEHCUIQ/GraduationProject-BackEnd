package com.sise.makerSpace.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReturnMsgUtils implements Serializable {
    private Integer flag;
    private String message;
    private Object data;	//数据，可以是PageBean
    public final static int OK=200;
    public final static int FAIL = 404;
    public final static int USERNAME_ALREADY_EXIST = 2;
    public final static int NOT_LOGIN=401;
    public final static int PERMISSION_DENIED=403;

    /*public ReturnMsgUtils() {
        this.flag = OK;
        this.message = "成功！";
    }

    public ReturnMsgUtils(Object data){
        this.flag = OK;
        this.message = "成功！";
        this.data = data;
    }

    public ReturnMsgUtils(Integer flag, String message, Object data){
        this.flag = flag;
        this.message = message;
        this.data = data;
    }*/

    public boolean isSuccess(){
        return this.flag == OK;
    }


    /**
     * 构造个操作失败的返回接口
     * @param message
     */
    /*public ReturnMsgUtils(String message){
        fail(message);
    }*/

    /**
     * @param message
     */
    /*public ReturnMsgUtils(int flag, String message){
        this.flag = flag;
        this.message = message;
    }


    public ReturnMsgUtils notLogin(){
        this.flag = NOT_LOGIN;
        this.message = "请先登录";
        this.data = null;
        return this;
    }*/

    public  ReturnMsgUtils fail(String message){
        return new ReturnMsgUtils(FAIL,message,null);
    }

    public ReturnMsgUtils success(String message){
        return new ReturnMsgUtils(OK,message,null);
    }

    public Integer getFlag() {
        return flag;
    }


    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * 强制类型转换
     * @return
     */
    @SuppressWarnings("unchecked")
    public <T> T getData() {
        if (data == null) {
            return null;
        }
        return (T)data;
    }

    public ReturnMsgUtils setData(Object data) {
        return new ReturnMsgUtils(OK,null,data);
    }


    public ReturnMsgUtils setData(Object data,String message) {
        return new ReturnMsgUtils(OK,message,data);
    }

}