package cc.cail.bugms.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cc.cail.bugms.common.AjaxResult;
import cc.cail.bugms.common.MsConstant;
import cc.cail.bugms.common.exception.ServiceException;
import cc.cail.bugms.dao.entity.Bug;
import cc.cail.bugms.dao.entity.BugLog;
import cc.cail.bugms.dao.entity.User;
import cc.cail.bugms.service.BugService;
import cc.cail.bugms.service.UserService;

/**
 * 
 * @author http://cail.cc
 *
 */
@RequestMapping("/bug")
@Controller
public class BugController extends BaseController {
	@Autowired
	private UserService userService;
	@Autowired
	private BugService bugService;

	@RequestMapping(value = "/new_bug.do", method = RequestMethod.GET)
	public String newBug(Model m) {
		User user = (User) SecurityUtils.getSubject().getPrincipal();
		/* 列出开发人员 */
		List<User> devs = userService.listRoleUsers(MsConstant.ROLE_DEV);
		m.addAttribute("userId", user.getId());
		m.addAttribute("devs", devs);
		return "new_bug";
	}

	@RequestMapping(value = "/new_bug.do", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult saveBug(@ModelAttribute("bug") Bug bug) {
		bugService.saveOrUpdateBug(bug);
		return respWriter.toSuccess();
	}

	@RequestMapping(value = "/bugs.do", method = RequestMethod.GET)
	public String bugList(Model m) {
		m.addAttribute("userId", ((User) SecurityUtils.getSubject().getPrincipal()).getId());
		return "bugs";
	}

	@RequestMapping(value = "/bug_list.do", method = RequestMethod.GET)
	@ResponseBody
	public AjaxResult bugListJson() {
		User user = (User) SecurityUtils.getSubject().getPrincipal();
		List<Map<String, Object>> buglist = null;
		if (MsConstant.ROLE_DEV.equals(user.getUserRole())) {
			buglist = bugService.queryBugsByDeveloperId(user.getId());
		} else if (MsConstant.ROLE_TEST.equals(user.getUserRole())) {
			buglist = bugService.queryBugsByTesterId(user.getId());
		}

		Map<String, Object> data = new HashMap<String, Object>();
		data.put("rows", buglist);
		data.put("total", buglist.size());
		return respWriter.toSuccess(data);
	}

	/**
	 * 按bugid获取单个bug的操作记录
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/bug_log_list.do", method = RequestMethod.GET)
	@ResponseBody
	public AjaxResult bugLogList(@RequestParam("id") Integer id) {
		List<BugLog> logList = bugService.queryBugLogByBugId(id);
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("logList", logList);
		return respWriter.toSuccess(data);
	}

	@RequestMapping(value = "/op_bug.do", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult opBug(@ModelAttribute("bugLog") BugLog bugLog) {
		try {
			bugService.updateBug(bugLog);
		} catch (ServiceException e) {
			return respWriter.toError(e.getCode());
		}
		return respWriter.toSuccess();
	}
	
	@RequestMapping(value="/bug_count.do",method = RequestMethod.GET)
	public String bugCount(){
		return "bug_count";
	}
	@RequestMapping(value = "/bug_count_json.do", method = RequestMethod.GET)
	@ResponseBody
	public AjaxResult bugCountJson() {
		List<Map<String, Object>> buglist = bugService.queryAllBugs();
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("rows", buglist);
		data.put("total", buglist.size());
		return respWriter.toSuccess(data);
	}
	
}
