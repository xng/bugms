package cc.cail.bugms.shiro;

import java.util.Arrays;
import java.util.HashSet;

import org.apache.log4j.Logger;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.SaltedAuthenticationInfo;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import cc.cail.bugms.common.MsConstant;
import cc.cail.bugms.dao.entity.User;
import cc.cail.bugms.service.UserService;
/**
 * 
 * @author http://cail.cc
 *
 */
public class ShiroRealm extends AuthorizingRealm {
	private UserService userService;

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	private final Logger logger = Logger.getLogger(this.getClass());

	/**
	 * 授权查询回调函数.
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		logger.info("~~~授权了");
		User user = (User) principals.getPrimaryPrincipal();
		SimpleAuthorizationInfo sai = new SimpleAuthorizationInfo();
		sai.setRoles(new HashSet<String>(Arrays.asList(user.getUserRole())));
		return sai;
	}

	/**
	 * 认证回调函数,登录时调用
	 */
	@Override
	protected SaltedAuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken)
			throws AuthenticationException {
		logger.info("~~~登录了");
		UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
		User user = userService.queryUserByAccount(token.getUsername());
		if (user != null) {
			if (user.getUserStatus() == MsConstant.COMMON_STATUS_DEl) {
				throw new DisabledAccountException();
			}
			return new SimpleAuthenticationInfo(user, user.getUserPwd(), getName());
		} else {
			throw new UnknownAccountException();
		}
	}
}
