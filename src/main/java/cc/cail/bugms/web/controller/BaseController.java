package cc.cail.bugms.web.controller;

import org.apache.log4j.Logger;
import org.slf4j.LoggerFactory;

import cc.cail.bugms.common.AjaxResultBuilder;

public class BaseController {
	protected AjaxResultBuilder respWriter = new AjaxResultBuilder();

	protected Logger logger = Logger.getLogger(getClass());
}
