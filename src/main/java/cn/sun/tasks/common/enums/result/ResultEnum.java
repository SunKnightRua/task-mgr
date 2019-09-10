package cn.sun.tasks.common.enums.result;

/**
 * 通用结果枚举.
 * 
 * @author  Mike Lee
 * @version 2017年6月26日 下午2:55:59
 */
public enum ResultEnum {
	SERVER_ERROR(500, "未知错误"), 
	SUCCESS(200, "成功"),
	ACCESS_FAIL(403, "未授权"),
	ACCOUNT_NOT_EXIST(450, "账号不存在"),
	PASSWORD_ERROR(451, "密码不存在"),
	AUTHENTICATION_FAIL(1000, "账号密码不正确"),
	ILLEGAL_ARGUMENT(403, "参数错误"),
	VALIDATION_FAILURE(600, "数据不符合要求");
	
	
	private Integer code;
	private String desc;
	private ResultEnum(Integer code, String desc) {
		this.code = code;
		this.desc = desc;
	}
	public Integer getCode() {
		return code;
	}
	public String getDesc() {
		return desc;
	}
	
}