package cc.cail.bugms.common;

import java.util.Map;

import org.apache.commons.lang.StringUtils;

import cc.cail.bugms.common.exception.ErrorCode;

public class AjaxResult {
	private Integer errorCode;
	private String errorMsg;
	private Map<String, Object> data;

	public AjaxResult() {
	}

	public AjaxResult(ErrorCode code, Map<String, Object> data, String msg) {
		this.errorCode = code.getCode();
		this.data = data;
		this.errorMsg = code.getMsg();
		if (StringUtils.isNotBlank(msg)) {
			this.errorMsg = msg;
		}
	}

	public Integer getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(Integer errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public Map<String, Object> getData() {
		return data;
	}

	public void setData(Map<String, Object> data) {
		this.data = data;
	}

}
