package cc.cail.bugms.common.exception;

public enum ErrorCode {
	ERROR_NULL_USER(1001, ""),
	ERROR_OLD_PASS_ERROR(1002, "");

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
