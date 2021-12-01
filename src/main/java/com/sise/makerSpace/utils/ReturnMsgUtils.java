package com.sise.makerSpace.utils;

import java.io.Serializable;

public class ReturnMsgUtils implements Serializable {
    private Integer flag;
    private String message;
    private Object data;	//数据，可以是PageBean
    public final static int OK=1;
    public final static int FAIL = 0;
    public final static int USERNAME_ALREADY_EXIST = 2;
    public final static int NOT_LOGIN=-1;
    public final static int PERMISSION_DENIED=3;

    public ReturnMsgUtils() {
        this.flag = OK;
        this.message = "OK";
    }

    public ReturnMsgUtils(Object data){
        this.flag = OK;
        this.message = "OK";
        this.data = data;
    }

    public ReturnMsgUtils(Integer flag, String message, Object data){
        this.flag = flag;
        this.message = message;
        this.data = data;
    }

    public boolean isSuccess(){
        return this.flag == OK;
    }


    /**
     * 构造个操作失败的返回接口
     * @param message
     */
    public ReturnMsgUtils(String message){
        fail(message);
    }

    /**
     * @param message
     */
    public ReturnMsgUtils(int flag, String message){
        this.flag = flag;
        this.message = message;
    }


    public ReturnMsgUtils notLogin(){
        this.flag = NOT_LOGIN;
        this.message = "请先登录";
        this.data = null;
        return this;
    }

    public  ReturnMsgUtils fail(String message){
        this.flag = FAIL;
        this.message = message;
        return this;
    }

    public ReturnMsgUtils success(String message){
        this.flag = OK;
        this.message = message;
        return this;
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
        this.data = data;
        return this;
    }
}