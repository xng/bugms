package cc.cail.bugms.web.controller;

import org.apache.log4j.Logger;

import cc.cail.bugms.common.AjaxResultBuilder;
/**
 * 
 * @author http://cail.cc
 *
 */
public class BaseController {
	protected AjaxResultBuilder respWriter = new AjaxResultBuilder();

	protected Logger logger = Logger.getLogger(getClass());
}
