package cc.cail.bugms.common;

import java.util.Map;

import cc.cail.bugms.common.exception.ErrorCode;

public class AjaxResultBuilder {
	public AjaxResult toSuccess() {
		return this.toSuccess(null);
	}

	public AjaxResult toSuccess(Map<String, Object> data) {
		return new AjaxResult(ErrorCode.SUCC, data, null);
	}

	public AjaxResult toError(ErrorCode code) {
		return this.toError(code, null);
	}

	public AjaxResult toError(ErrorCode code, String msg) {
		return new AjaxResult(code, null, msg);
	}
}
