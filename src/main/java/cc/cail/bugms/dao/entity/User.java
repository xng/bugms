package cc.cail.bugms.dao.entity;

import java.io.Serializable;

public class User implements Serializable{
	private static final long serialVersionUID = -139212148792619323L;

	private Integer id;

    private String userAccount;

    private String userPwd;

    private String userName;

    private String userRole;

    private String userMail;

    private Integer userStatus;

    private String userBak1;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount == null ? null : userAccount.trim();
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd == null ? null : userPwd.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole == null ? null : userRole.trim();
    }

    public String getUserMail() {
        return userMail;
    }

    public void setUserMail(String userMail) {
        this.userMail = userMail == null ? null : userMail.trim();
    }

    public Integer getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(Integer userStatus) {
        this.userStatus = userStatus;
    }

    public String getUserBak1() {
        return userBak1;
    }

    public void setUserBak1(String userBak1) {
        this.userBak1 = userBak1 == null ? null : userBak1.trim();
    }
}