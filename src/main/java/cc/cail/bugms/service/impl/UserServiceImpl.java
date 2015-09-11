package cc.cail.bugms.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cc.cail.bugms.common.MsConstant;
import cc.cail.bugms.common.exception.ErrorCode;
import cc.cail.bugms.common.exception.ServiceException;
import cc.cail.bugms.common.util.PwdUtil;
import cc.cail.bugms.dao.entity.Menu;
import cc.cail.bugms.dao.entity.MenuExample;
import cc.cail.bugms.dao.entity.User;
import cc.cail.bugms.dao.entity.UserExample;
import cc.cail.bugms.dao.manager.MenuMapper;
import cc.cail.bugms.dao.manager.UserMapper;
import cc.cail.bugms.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {
	private final Logger logger = Logger.getLogger(getClass());
	@Autowired
	private UserMapper userMapper;
	@Autowired
	public MenuMapper menuMapper;

	@Override
	public User queryUserByAccount(String account) {
		UserExample e = new UserExample();
		e.createCriteria().andUserAccountEqualTo(account);
		List<User> list = userMapper.selectByExample(e);
		return list.size() > 0 ? list.get(0) : null;
	}

	@Override
	public void saveOrUpdateUser(User user) throws ServiceException {
		if (user.getId() != null) {
			userMapper.updateByPrimaryKeySelective(user);
		} else {
			if (queryUserByAccount(user.getUserAccount()) != null) {
				throw new ServiceException(ErrorCode.USER_ACCOUNT_REPEAT);
			}
			user.setUserPwd(PwdUtil.getSign(MsConstant.DEFAULT_PWD));
			user.setUserStatus(MsConstant.COMMON_STATUS_NORMAL);
			userMapper.insert(user);
		}
	}

	@Override
	public void removeUser(Integer id) {
		logger.info("remove user : userId " + id);
		User user = new User();
		user.setUserStatus(MsConstant.COMMON_STATUS_DEl);
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

	@Override
	public List<Menu> getMenusByRole(String role) {
		MenuExample e = new MenuExample();
		e.createCriteria().andMenuRoleEqualTo(role).andMenuStatusEqualTo(MsConstant.COMMON_STATUS_NORMAL);
		return menuMapper.selectByExample(e);
	}

	@Override
	public List<User> listUsers() {
		return userMapper.selectByExample(new UserExample());
	}

	@Override
	public List<User> listRoleUsers(String role) {
		UserExample e = new UserExample();
		e.createCriteria().andUserRoleEqualTo(role).andUserStatusEqualTo(MsConstant.COMMON_STATUS_NORMAL);
		return userMapper.selectByExample(e);
	}
}
