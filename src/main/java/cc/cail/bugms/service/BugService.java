package cc.cail.bugms.service;

import java.util.List;

import cc.cail.bugms.dao.entity.Bug;
import cc.cail.bugms.dao.entity.BugLog;

public interface BugService {
	/**
	 * 根据测试人员id获取当前人提交的Bug列表
	 * @param testerId
	 * @return
	 */
	public List<Bug> queryBugsByTesterId(Integer testerId);
	/**
	 * 根据开发人员id获取指派给当前人的Bug列表
	 * @param developerId
	 * @return
	 */
	public List<Bug> queryBugsByDeveloperId(Integer developerId);
	/**
	 * 根据id查看bug
	 * @param id
	 * @return
	 */
	public Bug queryById(Integer id);
	/**
	 * 根据bugId获取BugLog
	 * @param bugId
	 * @return
	 */
	public List<BugLog> queryBugLogByBugId(Integer bugId);
	/**
	 * 提交或更新Bug
	 * @param bug
	 */
	public void saveOrUpdateBug(Bug bug);
	
}
