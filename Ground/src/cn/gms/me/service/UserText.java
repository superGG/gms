package cn.gms.me.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import cn.gms.me.domain.UserBean;

public class UserText {
	UserService dao = new UserService();
//	/**
//	 * 测试增删改功能.
//	 */
//	@Test
//	public void fun1() {   
//		
//		for (int i = 2; i < 10; i++) {
//			UserBean c = new UserBean();
//
//			c.setUsername("路人甲" + i);
//			c.setPassword("admin" + i);
//			c.setPhone("987654321" + i);
//			c.setRole("普通用戶");
//
//			Boolean result = dao.addUser(c);
//			System.out.println(result);
//		}
//	}
//	
	/**
	 * 测试查询功能
	 */
//	@Test
//	public void fun2() {
//		UserBean user = new UserBean();
//		user.setUsername("普通用户");
//		List<Object> list = new ArrayList();
//		list = dao.queryUser(user);
//		for (int i = 0; i < list.size(); i++) {
//			System.out.println(list.get(i));
//		}
//	}
	
	
	
	
	
	/**
	 * 测试Map数据输出
	 */
	@Test
	public void fun2() {
		Map<String,Object> map = null;
		UserBean user = new UserBean();
		user.setUsername("路人甲1");
		List<Object> list = new ArrayList();
		list = dao.queryUser(user);
		
			map = (Map)list.get(0);
			System.out.println(map.get("username"));
			System.out.println(map.get("password"));
			System.out.println(map.get("phone"));
			System.out.println(map.get("role"));
		
		
//		if(list!=null&&list.size()!=0){
//			for(int i = 0;i<list.size();i++){
//				map = (Map)list.get(i);
//				if(map.get("password").equals("admin")){
//					System.out.println(map.get("password"));
//				}
//			}
//		}
	}
}
