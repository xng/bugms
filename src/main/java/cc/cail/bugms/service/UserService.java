package cc.cail.bugms.service;

import cc.cail.bugms.common.exception.ServiceException;
import cc.cail.bugms.dao.entity.User;

public interface UserService {

	/**
	 * 按帐号查询密码，登录用
	 */
	public User queryUserByAccount(String account);

	/**
	 * 保存或者更新用户
	 */
	public void saveOrUpdateUser(User user);

	/**
	 * 移除user
	 */
	public void removeUser(Integer id);

	public void updatePwd(Integer userId, String oldPwd, String newPwd) throws ServiceException;
}
