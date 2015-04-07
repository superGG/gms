package cn.gms.me.dao.basedao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 1:连接、关闭数据库. 
 * 2：数据库增删改查操作.
 * @author Administrator
 */
public class BaseDao {	
	/**
	 * 驱动类.
	 */
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	/**
	 * 数据库地址.
	 */
	private static final String URL = "jdbc:mysql://localhost:3306/groundmessage";
	/**
	 * 数据库账号.
	 */
	private static final String USERNAME = "root";
	/**
	 * 数据库密码.
	 */
	private static final String PASSWORD = "123";
	
	/**
	 * 数据库连接.
	 * @return con.
	 */
	public final Connection getConnection() {
		Connection con = null;
		
		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	
	/**
	 * 倒关数据库连接.
	 * @param con   数据库连接对象.
	 * @param pstmt 预编辑.
	 * @param rs  查询.
	 */
	public final void closeAll(final Connection con,
			final PreparedStatement pstmt, final ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
			if (con != null) {
				con.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	  * @param sql  数据库执行语句
	 * @param param  222
	 * @param type   数据类型
	 * @return 执行行数.
	 */
	public final int executeUpdate(final String sql, final Object[] param,
			final int[] type) {
		Connection con = this.getConnection();
		PreparedStatement pstmt = null;
		int rows = 0;
		
		try {
			pstmt = con.prepareStatement(sql);
			for (int i = 1; i <= param.length; i++) {  
				pstmt.setObject(i, param[i - 1], type[i - 1]);
			}
			rows = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.closeAll(con, pstmt, null);
		}
		return rows;	
	}
	
	/**
	 * 数据库查询.
	 * @param sql 执行语句.
	 * @param param 数据.
	 * @param type 数据类型.
	 * @return List.
	 */
	public final List<Object> executeQuery(final String sql, final Object[] param,
			final int[] type) {
		ResultSet re = null;
		List<Object> list = null;
		Connection con = this.getConnection();
		PreparedStatement pstmt = null;
		
		try {
			pstmt = con.prepareStatement(sql);
			for (int i = 1; i <= param.length; i++) {  
				pstmt.setObject(i, param[i - 1], type[i - 1]);
			}
			re = pstmt.executeQuery();
			list = new ArrayList<Object>();
			ResultSetMetaData rsm = re.getMetaData(); //获取此 ResultSet 对象的列的编号、类型和属性
            Map<String, Object> map = null; //Map<key,value>是一个映射，key表示键，value表示所映射的值的类型
            while (re.next()) { 
            	map = new HashMap<String, Object>();
            	/*
            	 * getClmnCount():返回 ResultSet 中的列数
            	 * getClomnnName(i):返回列序号为 i 的列名
            	 * map.put(x,y):x位置，y值
            	 * getObject():取此 ResultSet 对象的当前行中指定列的值
            	 */
            	for (int i = 1; i <= rsm.getColumnCount(); i++) {
            		map.put(rsm.getColumnName(i), re.getObject(rsm.getColumnName(i)));
            	}
            	list.add(map);
            }
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.closeAll(con, pstmt, re);
		}
//		System.out.println(list);
		return list;
	}

	
	
	
	
	
	
	
	
	
}
