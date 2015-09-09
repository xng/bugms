package cc.cail.bugms.common.exception;

public class ServiceException extends Exception {
	private static final long serialVersionUID = 1L;
	private ErrorCode code;

	public ErrorCode getCode() {
		return code;
	}

	public void setCode(ErrorCode code) {
		this.code = code;
	}

	public ServiceException(ErrorCode code) {
		super(code.getMsg());
		this.code = code;
	}
}
