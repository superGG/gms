package cn.gms.me.service;

import java.util.List;

import cn.gms.me.dao.yhgl.UserDao;
import cn.gms.me.domain.UserBean;


/**
 * @author Administrator
 *
 */
public class UserService {
	
	/**
	 * 存放查询数据库所得数据.
	 */
	private List<Object> list = null;
	/**
	 * 判断是否成功执行增删改查.
	 */
	private Boolean result = false; 
	
	/**
	 * 调用UserDao的增删改查方法.
	 */
	private UserDao userdao = new UserDao();
	
	/**
	 * 
	 * @param user 获取用户信息.
	 * @return 执行结果.
	 */
	public final Boolean addUser(final UserBean user) {
		result = userdao.add(user);
		return result;
	}
	
	/**
	 * @param user 获取用户信息.
	 * @return 执行结果.
	 */
	public final Boolean deleUser(final UserBean user) {
		result = userdao.delete(user);
		return result;
	}
	
	/**
	 * @param user 获取用户信息.
	 * @return 执行结果.
	 */
	public final Boolean updateUser(final UserBean user) {		
		result = userdao.update(user);
		return result;
	}
	
	/**
	 * @param user 所要查询的用户信息.
	 * @return 所查询的数据组list.
	 */
	public final List<Object> queryUser(final UserBean user) {
		list = userdao.queryUser(user);
		return list;
	}
	
	
	
	
	
	
	
}
