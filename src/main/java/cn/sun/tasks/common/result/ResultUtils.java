package cn.sun.tasks.common.result;

import cn.sun.tasks.common.enums.result.ResultEnum;

/**
 * 通用返回结果工具类.
 */
public class ResultUtils {
    /**
     * 返回通用成功信息.
     * 
     * @return Result<T> 通用返回结果
     */
    public static <T> Result<T> success() {
        Result<T> result = new Result<T>();
        result.setCode(ResultEnum.SUCCESS.getCode());
        result.setMsg(ResultEnum.SUCCESS.getDesc());
        return result;
    }

    /**
     * 返回通用成功信息.
     * 
     * @param t          泛型
     * @return Result<T> 通用返回结果
     */
    public static <T> Result<T> success(T t) {
        Result<T> result = new Result<T>();
        result.setCode(ResultEnum.SUCCESS.getCode());
        result.setMsg(ResultEnum.SUCCESS.getDesc());
        result.setData(t);
        return result;
    }

    /**
     * 返回通用失败结果.
     * 
     * @param code 		    错误代码
     * @param message 	    错误信息
     * @return Result<T> 通用返回结果
     */
    public static <T> Result<T> failure(Integer code, String message) {
        Result<T> result = new Result<T>();
        result.setCode(code);
        result.setMsg(message);
        return result;
    }

    /**
     * 返回通用失败信息.
     * 
     * @param resultEnum 错误结果枚举
     * @return Result<T> 通用返回结果
     */
    public static <T> Result<T> failure(ResultEnum resultEnum) {
        Result<T> result = new Result<T>();
        result.setCode(resultEnum.getCode());
        result.setMsg(resultEnum.getDesc());
        return result;
    }
}