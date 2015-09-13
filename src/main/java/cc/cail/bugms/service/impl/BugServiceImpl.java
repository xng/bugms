package cc.cail.bugms.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cc.cail.bugms.common.MsConstant;
import cc.cail.bugms.common.exception.ErrorCode;
import cc.cail.bugms.common.exception.ServiceException;
import cc.cail.bugms.dao.entity.Bug;
import cc.cail.bugms.dao.entity.BugLog;
import cc.cail.bugms.dao.entity.BugLogExample;
import cc.cail.bugms.dao.manager.BugLogMapper;
import cc.cail.bugms.dao.manager.BugMapper;
import cc.cail.bugms.service.BugService;

@Service
public class BugServiceImpl implements BugService {

	private final Logger logger = Logger.getLogger(getClass());
	@Autowired
	private BugMapper bugMapper;
	@Autowired
	private BugLogMapper bugLogMapper;

	@Override
	public List<Map<String, Object>> queryBugsByTesterId(Integer testerId) {
		return bugMapper.listTestersBug(testerId);
	}

	@Override
	public List<Map<String, Object>> queryBugsByDeveloperId(Integer developerId) {
		return bugMapper.listDevBug(developerId);
	}

	@Override
	public List<BugLog> queryBugLogByBugId(Integer bugId) {
		BugLogExample e = new BugLogExample();
		e.createCriteria().andBugIdEqualTo(bugId);
		e.setOrderByClause("update_time");
		return bugLogMapper.selectByExample(e);
	}

	@Override
	public void saveOrUpdateBug(Bug bug) {
		Date now = new Date();
		bug.setCreateTime(now);
		bug.setUpdateTime(now);
		if (bug.getId() == null) {
			bug.setAssignTime(now);
			bug.setBugStatus(MsConstant.BUG_STATUS_NEW);
			bugMapper.insert(bug);
		} else {
			bugMapper.updateByPrimaryKeySelective(bug);
		}
	}

	@Override
	public void updateBug(BugLog bugLog) throws ServiceException {
		logger.info("update log action " + bugLog.toString());
		Bug bug = bugMapper.selectByPrimaryKey(bugLog.getBugId());
		if (bug == null) {
			throw new ServiceException(ErrorCode.BUG_NULL_ERRPR);
		}
		Bug up = new Bug();
		up.setId(bug.getId());
		up.setUpdateId(bugLog.getUpdateId());
		up.setUpdateTime(new Date());
		if ("关闭".equals(bugLog.getOperation())) {
			up.setBugStatus(MsConstant.BUG_STATUS_CLOSE);
		} else if ("未解决".equals(bugLog.getOperation())) {
			up.setBugStatus(MsConstant.BUG_STATUS_NEW);
		} else if ("已修正".equals(bugLog.getOperation())) {
			up.setBugStatus(MsConstant.BUG_STATUS_DEAL);
		} else if ("不予处理".equals(bugLog.getOperation())) {
			up.setBugStatus(MsConstant.BUG_STATUS_DEAL);
		}
		bugMapper.updateByPrimaryKeySelective(up);
		bugLog.setUpdateTime(new Date());
		bugLogMapper.insert(bugLog);
	}
	
	@Override
	public List<Map<String, Object>> queryAllBugs() {
		return bugMapper.queryAllBugs();
	}

}
