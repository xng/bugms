package cc.cail.bugms.common.exception;

public enum ErrorCode {
	SUCC(200, "成功"),
	ERROR_NULL_USER(1001, "未找到相关用户"),
	ERROR_OLD_PASS_ERROR(1002, "旧密码错误"),
	ERROR_PASS_ERROR(1003, "密码错误"),
	ERROR_DISABLE_USER(1004, "帐号已不可用");

	private Integer code;
	private String msg;

	ErrorCode(Integer code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public Integer getCode() {
		return code;
	}

	public String getMsg() {
		return msg;
	}
}
