package cc.cail.bugms.service;

import java.util.List;

import cc.cail.bugms.common.exception.ServiceException;
import cc.cail.bugms.dao.entity.Menu;
import cc.cail.bugms.dao.entity.User;

/**
 * 用户接口实现类
 * 
 * @author http://cail.cc
 */
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

	/**
	 * 根据角色获取菜单
	 * 
	 * @param role
	 * @return
	 */
	public List<Menu> getMenusByRole(String role);

	public List<User> listUsers();
}
