package cc.cail.bugms.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cc.cail.bugms.common.MsConstant;
import cc.cail.bugms.common.exception.ErrorCode;
import cc.cail.bugms.common.exception.ServiceException;
import cc.cail.bugms.dao.entity.User;
import cc.cail.bugms.dao.entity.UserExample;
import cc.cail.bugms.dao.manager.UserMapper;
import cc.cail.bugms.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	private final Logger logger = Logger.getLogger(getClass());
	@Autowired
	private UserMapper userMapper;

	@Override
	public User queryUserByAccount(String account) {
		UserExample e = new UserExample();
		e.createCriteria().andUserAccountEqualTo(account);
		List<User> list = userMapper.selectByExample(e);
		return list.size() > 0 ? list.get(0) : null;
	}

	@Override
	public void saveOrUpdateUser(User user) {
		if (user.getId() != null) {
			userMapper.updateByPrimaryKeySelective(user);
		} else {
			userMapper.insert(user);
		}
	}

	@Override
	public void removeUser(Integer id) {
		logger.info("remove user : userId " + id);
		User user = new User();
		user.setUserStatus(MsConstant.USER_STATUS_DEl);
	}

	@Override
	public void updatePwd(Integer userId, String oldPwd, String newPwd) throws ServiceException {
		logger.info("update Pwd : userId " + userId);
		User user = userMapper.selectByPrimaryKey(userId);
		if (user == null) {
			logger.error("update Pwd null error : " + userId);
			throw new ServiceException(ErrorCode.ERROR_NULL_USER);
		} else if (!user.getUserPwd().equals(oldPwd)) {
			logger.error("update Pwd oldPwd error : " + userId);
			throw new ServiceException(ErrorCode.ERROR_OLD_PASS_ERROR);
		} else {
			user.setUserPwd(newPwd);
			userMapper.updateByPrimaryKeySelective(user);
		}
	}

}
