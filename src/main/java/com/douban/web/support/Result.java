package com.douban.web.support;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by ruikai.lin  on 2018/1/30 下午4:48.
 * Description:Controller层统一的返回结果
 */
@ApiModel("返回数据")
public class Result {
    @ApiModelProperty("返回状态码")
    private Integer code;
    @ApiModelProperty("返回信息")
    private String message;
    @ApiModelProperty("返回数据")
    private Object data;

    private Result(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    private Result( String message) {
        this.message = message;
    }
    private Result(Integer code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static Result success(){
        return new Result(0,"执行成功");
    }

    public static Result success(Object data){
        return new Result(0,"执行成功",data);
    }

    public static Result fail(Integer code,String message){
        return new Result(1,message);  //后续根据业务具体情况完善
    }

    public static Result fail(String message){
        return new Result(message);
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public Object getData() {
        return data;
    }
}
