package cc.cail.bugms.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cc.cail.bugms.common.AjaxResult;
import cc.cail.bugms.common.exception.ServiceException;
import cc.cail.bugms.dao.entity.User;
import cc.cail.bugms.service.UserService;
/**
 * 
 * @author http://cail.cc
 *
 */
@RequestMapping("/user")
@Controller
public class UserController extends BaseController {
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/user.do", method = RequestMethod.GET)
	public String user() {
		return "user";
	}

	@RequestMapping(value = "/userList.do", method = RequestMethod.GET)
	@ResponseBody
	public AjaxResult userList() {
		Map<String, Object> data = new HashMap<String, Object>();
		List<User> users = userService.listUsers();
		data.put("rows", users);
		data.put("total", users.size());
		return respWriter.toSuccess(data);
	}

	@RequestMapping(value = "/saveorUpdateUser.do", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult saveorUpdateUser(@ModelAttribute("user") User user) {
		try {
			userService.saveOrUpdateUser(user);
			return respWriter.toSuccess();
		} catch (ServiceException e) {
			return respWriter.toError(e.getCode());
		}
	}
}
