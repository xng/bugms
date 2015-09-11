package cc.cail.bugms.service;

import java.util.List;
import java.util.Map;

import cc.cail.bugms.dao.entity.Bug;
import cc.cail.bugms.dao.entity.BugLog;
/**
 * 
 * @author http://cail.cc
 *
 */
public interface BugService {
	/**
	 * 根据测试人员id获取当前人提交的Bug列表
	 * 
	 * @param testerId
	 * @return
	 */
	public List<Map<String, Object>> queryBugsByTesterId(Integer testerId);

	/**
	 * 根据开发人员id获取指派给当前人的Bug列表
	 * 
	 * @param developerId
	 * @return
	 */
	public List<Map<String, Object>> queryBugsByDeveloperId(Integer developerId);

	/**
	 * 根据bugId获取BugLog
	 * 
	 * @param bugId
	 * @return
	 */
	public List<BugLog> queryBugLogByBugId(Integer bugId);

	/**
	 * 提交Bug
	 * 
	 * @param bug
	 */
	public void saveOrUpdateBug(Bug bug);

	/**
	 * 更新bug
	 * 
	 * @param bug
	 * @param action
	 */
	public void updateBug(Bug bug, BugLog bugLog);

}
