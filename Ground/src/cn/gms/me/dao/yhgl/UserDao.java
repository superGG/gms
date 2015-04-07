package cn.gms.me.dao.yhgl;

import java.sql.Types;
import java.util.List;

import cn.gms.me.dao.basedao.BaseDao;
import cn.gms.me.domain.UserBean;

/**
 * 用户管理调用数据库.
 * 
 * @author Administrator
 * 
 */
public class UserDao extends BaseDao {

	/**
	 * 是否成功添加用户.
	 */
	private Boolean result = null;
	
	/**
	 * 用于存放查询所得用户信息.
	 */
	private List<Object> list = null;

	/**
	 * 执行数据库操作的行数.
	 */
	private int effectLine = 0;

	/**
	 * @param user
	 *            获取用户信息.
	 * @return true or false.
	 */
	public final Boolean add(final UserBean user) {

		String sql = "SELECT username " + "FROM user " + "WHERE username = ?";
		Object[] params = { user.getUsername() };
		int[] type = { Types.VARCHAR };
		list = executeQuery(sql, params, type);
		if (list != null && list.size() != 0) {
			result = false;
		} else {
			result = true;
		}
		/*
		 * 查询数据库没有相同用户名时，返回true,继续执行
		 */
		if (result) {
			sql = "INSERT INTO user VALUES (?,?,?,?)";
			params = new String[] { user.getUsername(), user.getPassword(),
					user.getPhone(), user.getRole() };
			type = new int[] { Types.VARCHAR, Types.VARCHAR, Types.VARCHAR,
					Types.VARCHAR };
			effectLine = executeUpdate(sql, params, type);
			if (effectLine == 0) {
				result = false;
			}
		}
		return result;
	}

	/**
	 * 删除用户.
	 * 
	 * @param user
	 *            获取用户信息
	 * @return true or false
	 */
	public final Boolean delete(final UserBean user) {

		String sql = "SELECT username " + "FROM user " + "WHERE username = ?";
		Object[] params = { user.getUsername() };
		int[] type = { Types.VARCHAR };
		list = executeQuery(sql, params, type);
		if (list == null && list.size() == 0) {
			result = true;
		} else {
			result = false;
		}
		/*
		 * 查询数据库后有该用户名的，返回true,继续执行，将该用户信息删除
		 */
		if (result) {
			sql = "DELETE FROM user WHERE username = ?";
			params = new Object[] { user.getUsername() };
			type = new int[] { Types.VARCHAR };
			effectLine = executeUpdate(sql, params, type);
			if (effectLine == 0) {
				result = false;
			}
		}
		return result;
	}

	/**
	 * 给予普通用户修改密码和电话.
	 * 
	 * @param user
	 *            获取用户信息
	 * @return true or false
	 */
	public final Boolean update(final UserBean user) {
		String sql = "SELECT username " + "FROM user " + "WHERE username = ?";
		Object[] params = { user.getUsername() };
		int[] type = { Types.VARCHAR };
		list = executeQuery(sql, params, type);
		if (list == null && list.size() == 0) {
			result = true;
		} else {
			result = false;
		}
		/*
		 * 查询是否有该用户，返回true时继续执行
		 */
		if (result) {
			sql = "UPDATE user SET password=?,phone=? " + "WHERE username =?";
			params = new Object[] { user.getPassword(), user.getPhone(),
					user.getUsername() };
			type = new int[] { Types.VARCHAR, Types.VARCHAR, Types.VARCHAR };
			effectLine = executeUpdate(sql, params, type);
			if (effectLine == 0) {
				result = false;
			}
		}
		return result;
	}

	/**
	 * 按权限查找.
	 * @param user 获取所要查询权限.
	 * @return 用户信息
	 */
	public final List<Object> queryUser(final UserBean user) {
		String sql = "SELECT * FROM user WHERE username = ? ";
		Object[] params = { user.getUsername() };
		int[] type = { Types.VARCHAR };
		list = executeQuery(sql, params, type);
		
		return list;
	}
	
	
	
	
	
	
	
}
