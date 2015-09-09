package cc.cail.bugms.web.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cc.cail.bugms.common.AjaxResult;
import cc.cail.bugms.dao.entity.User;
import cc.cail.bugms.service.UserService;

@RequestMapping("/user")
@Controller
public class UserController extends BaseController {
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/login.do", method = RequestMethod.GET)
	public String login() {
		return "login";
	}

	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public AjaxResult login(@RequestParam("user") User user, Model model) {
		if (SecurityUtils.getSubject().isAuthenticated()) {
			respWriter.toSuccess();
		} else {
			SecurityUtils.getSubject()
					.login(new UsernamePasswordToken(user.getUserAccount(), user.getUserPwd().toCharArray(), true));
				
		}
		return respWriter.toSuccess();
	}
}
