package com.sedwt.icloud.common;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.commons.lang3.StringUtils;

/**
 * @author : zhang yijun
 * @date : 2021/3/15 14:19
 * @description : TODO
 */

@Getter
@Setter
@ToString
public class Result {

    /**
     * 默认错误响应码
     */
    private static final Integer DEFAULT_FAILED_CODE = -1;

    /**
     * 默认成功响应码
     */
    private static final Integer DEFAULT_SUCCESS_CODE = 200;

    /**
     * 响应码
     */
    private Integer code;

    /**
     * 响应信息
     */
    private String message;

    public static Result success(){
        return success(null, null);
    }

    public static Result success(String message){
        return success(DEFAULT_SUCCESS_CODE, message);
    }

    public static Result success(Integer code, String message){
        Result result = new Result();
        Integer cod = code == null ? DEFAULT_SUCCESS_CODE : code;
        String mes = StringUtils.isEmpty(message) ? "Default success" : message;
        result.setCode(cod);
        result.setMessage(mes);
        return result;
    }


    public static Result fail(){
        return fail(null, null);
    }

    public static Result fail(String message){
        return fail(DEFAULT_FAILED_CODE, message);
    }

    public static Result fail(Integer code, String message){
        Result result = new Result();
        Integer cod = code == null ? DEFAULT_FAILED_CODE : code;
        String mes = StringUtils.isEmpty(message) ? "Default failed" : message;
        result.setCode(cod);
        result.setMessage(mes);
        return result;
    }
}
