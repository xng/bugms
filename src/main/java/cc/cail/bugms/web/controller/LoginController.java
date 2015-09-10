package cc.cail.bugms.web.controller;

import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cc.cail.bugms.common.AjaxResult;
import cc.cail.bugms.common.exception.ErrorCode;
import cc.cail.bugms.dao.entity.Menu;
import cc.cail.bugms.dao.entity.User;
import cc.cail.bugms.service.UserService;

@Controller
public class LoginController extends BaseController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/login.do", method = RequestMethod.GET)
	public String login() {
		return "login";
	}

	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult login(@ModelAttribute("user") User user) {
		logger.info("login in " + user.getUserAccount());
		if (SecurityUtils.getSubject().isAuthenticated()) {
			return respWriter.toSuccess();
		} else {
			try {
				SecurityUtils.getSubject()
						.login(new UsernamePasswordToken(user.getUserAccount(), user.getUserPwd().toCharArray(), true));
				return respWriter.toSuccess();
			} catch (UnknownAccountException e) {
				return respWriter.toError(ErrorCode.ERROR_NULL_USER);
			} catch (IncorrectCredentialsException e) {
				return respWriter.toError(ErrorCode.ERROR_PASS_ERROR);
			} catch (DisabledAccountException e) {
				return respWriter.toError(ErrorCode.ERROR_DISABLE_USER);
			}
		}
	}

	@RequestMapping(value = "/index.do", method = RequestMethod.GET)
	public String index(Model m) {
		User user = (User) SecurityUtils.getSubject().getPrincipal();
		List<Menu> menus = userService.getMenusByRole(user.getUserRole());
		user.setUserPwd(null);
		m.addAttribute("menus", menus);
		m.addAttribute("user", user);
		return "index";
	}
}
