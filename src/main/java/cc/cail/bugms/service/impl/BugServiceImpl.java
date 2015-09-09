package cc.cail.bugms.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cc.cail.bugms.dao.entity.Bug;
import cc.cail.bugms.dao.entity.BugExample;
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
	public List<Bug> queryBugsByTesterId(Integer testerId) {
		BugExample e = new BugExample();
		e.createCriteria().andCreateIdEqualTo(testerId);
		return bugMapper.selectByExample(e);
	}

	@Override
	public List<Bug> queryBugsByDeveloperId(Integer developerId) {
		BugExample e = new BugExample();
		e.createCriteria().andAssignIdEqualTo(developerId);
		return bugMapper.selectByExample(e);
	}

	@Override
	public Bug queryById(Integer id) {
		return bugMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<BugLog> queryBugLogByBugId(Integer bugId) {
		BugLogExample e = new BugLogExample();
		e.createCriteria().andBugIdEqualTo(bugId);
		e.setOrderByClause("update_time");
		return bugLogMapper.selectByExample(e);
	}

	@Override
	public void saveBug(Bug bug) {
		bugMapper.insert(bug);
	}

	@Override
	public void updateBug(Bug bug, BugLog bugLog) {
		logger.info("update log action "+bugLog.toString());
		bugMapper.updateByPrimaryKeySelective(bug);
		bugLog.setUpdateTime(new Date());
		bugLogMapper.insert(bugLog);
	}

}
