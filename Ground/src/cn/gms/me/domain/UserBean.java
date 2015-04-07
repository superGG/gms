package cn.gms.me.domain;

/**
 * JavaBean 类.
 * @author Administrator
 *
 */
public class UserBean {
	
	/**
	 * 用户姓名.
	 */
	 private String username = null;
	 /**
	 * 用户密码.
	 */
	 private String password = null;
	/**
	 * 用户手机.
	 */
	 private String phone = null;
	 /**
	  * 用户角色.
	  */
	 private String role = null;
	 
	 /**
	  * .
	  */
	public UserBean() {
		super();
	}
	
	/**
	 * 获取用户姓名.
	 * @return username.
	 */
	public final String getUsername() {
		return username;
	}
	
	/**
	 * 设置用户姓名.
	 * @param username 用户姓名
	 */
	public final void setUsername(final String username) {
		this.username = username;
	}
	
	/**
	 * 获取用户密码.
	 * @return password.
	 */
	public final String getPassword() {
		return password;
	}
	
	/**
	 * 设置用户密码.
	 * @param password 用户密码
	 */
	public final void setPassword(final String password) {
		this.password = password;
	}
	
	/**
	 * 获取用户手机.
	 * @return phone.
	 */
	public final String getPhone() {
		return phone;
	}
	
	/**
	 * 设置用户手机.
	 * @param phone 用户手机
	 */
	public final void setPhone(final String phone) {
		this.phone = phone;
	}
	
	/**
	 * 获取用户角色.
	 * @return role.
	 */
	public final String getRole() {
		return role;
	}
	
	/**
	 * 设置用户角色.
	 * @param role 用户角色
	 */
	public final void setRole(final String role) {
		this.role = role;
	}
	 
	 
}
