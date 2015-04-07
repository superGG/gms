package cn.gms.me.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import cn.gms.me.domain.UserBean;
import cn.gms.me.service.UserService;

import com.opensymphony.xwork2.ActionContext;

/**
 * 登陆操作.
 * @author Administrator
 *
 */
public class LoginAction {
	/**
	 * 获取页面用户参数.
	 */
	private UserBean user = new UserBean();
	
	/**
	 * 调用service中的查询数据库方法.
	 */
	private UserService service = new UserService();
	
	/**
	 * 获取从数据库中查询的用户信息.
	 */
	private List<Object> list = new ArrayList<Object>();
	/**
	 * 存放单个用户的信息.
	 */
	private Map<String, Object> map = null;
	
	
	/**
	 * 登陆.
	 * @return 是否登陆成功.
	 */
	public final String execute() {
		list = service.queryUser(user);
		map = (Map) list.get(0);
		
		System.out.println(user.getPassword()); //测试输出用户登陆密码
		System.out.println(map.get("password")); //测试输出数据库相应用户名的密码
		
		if (user.getPassword().equals(map.get("password"))) {
			return "success";
		} else {
			return "error";
		}	
	}
	
	/**
	 * 注册.
	 * @return 是否注册成功.
	 */
	public final String register() {
		Boolean result = null;
		user.setRole("普通用户");
		list = service.queryUser(user);
		if (list.size() == 0) {
			result = service.addUser(user);
			if (result) {
				return "success";
			}
		} 
		return "error";
			
	}
	
	/**
	 * 参数传值.
	 * @return 参数传值.
	 */
	public final UserBean getUser() {
		return user;
	}

	/**
	 * 参数传值.
	 * @param user 用户信息
	 */
	public final void setUser(final UserBean user) {
		this.user = user;
	}
}
