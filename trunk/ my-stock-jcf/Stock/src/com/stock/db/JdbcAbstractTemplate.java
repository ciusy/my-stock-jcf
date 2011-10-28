package com.stock.db;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * 这就是模板模式中的模板,用于处理数据库连接的相关操作
 */
public class JdbcAbstractTemplate{
	
	private static final String JDBC_PROPERTIES = "jdbc.properties";
	private static String driverClass;
	private static String url;
	private static String username;
	private static String password;
	
	private PreparedStatement pstmt = null;
	private static Connection conn = null;
	private ResultSet rs = null;
	
	/**
	 * 注册JDBC驱动
	 */
//	public void registerDriver() {
//		try {
//			readProperties(this.getClass().getResource("/").getPath()+"/"+JDBC_PROPERTIES);
//			Class.forName(driverClass);
//		} catch (ClassNotFoundException e) {
//			System.out.println("注册驱动失败!");
//			e.printStackTrace();
//		}
//	}
	
	static {
		try {
			readProperties(JdbcAbstractTemplate.class.getResource("/").getPath()+"/"+JDBC_PROPERTIES);
			Class.forName(driverClass);
		} catch (ClassNotFoundException e) {
			System.out.println("注册驱动失败!");
			e.printStackTrace();
		}
	}

	/**
	 * 取得连接
	 */
	public Connection getConnection() {
		try {
			if(conn == null)conn = DriverManager.getConnection(url, username, password);
			return conn;
		} catch (SQLException e) {
			System.out.println("数据库连接失败!");
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 关闭连接
	 */
	public void closeConnection() {
		if (conn != null)
			try {
				conn.close();
				conn = null;
			} catch (SQLException e) {
				System.out.println("数据库关闭失败!");
				e.printStackTrace();
			}
	}

	/**
	 * 关闭语句
	 */
	public void closeStatement() {
		if (pstmt != null)
			try {
				pstmt.close();
				pstmt = null;
			} catch (SQLException e) {
				System.out.println("语句关闭失败!");
				e.printStackTrace();
			}
	}
	
	public void close(){
		closeStatement();
		closeConnection();
	}

	/**
	 * 保存
	 */
	public void save(String sql,Object[] params) {

		try {
//			registerDriver();
//			conn = getConnection();
			pstmt = getConnection().prepareStatement(sql);
			
			if(params!=null && params.length>0){
				for(int i=0; i<params.length; i++){
					pstmt.setObject(i+1, params[i]);
				}
			}
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("数据操作失败!");
			e.printStackTrace();
			closeStatement();
			closeConnection();
		} finally {
//			closeStatement();
//			closeConnection();
		}
	}
	
	/**
	 * 删除
	 * @param sql
	 * @param params
	 */
	public void delete(String sql,Object[] params) {
//		public void delete(String sql,Date params) {
		try {
//			registerDriver();
//			conn = getConnection();
			pstmt = getConnection().prepareStatement(sql);
			
			if(params!=null && params.length>0){
				for(int i=0; i<params.length; i++){
					pstmt.setObject(i+1, params[i]);
				}
			}
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("数据操作失败!");
			e.printStackTrace();
		} finally {
//			closeStatement();
//			closeConnection();
		}
	}

	/**
	 * 模板方法----获取数据
	 */
	public ResultSet get(String sql,Object[] params) {

		try {
//			registerDriver();
//			conn = getConnection();
			pstmt = getConnection().prepareStatement(sql);
//			System.out.println("[sql:]"+sql);
			if(params!=null && params.length>0){
				for(int i=0; i<params.length; i++){
					pstmt.setObject(i+1, params[i]);
				}
			}
			
			rs = pstmt.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
		
	}
	
	/**
	 * 模板方法创建表
	 */
	public void create(String sql) {
		try {
//			registerDriver();
//			conn = getConnection();
			pstmt = getConnection().prepareStatement(sql);
			pstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 读取配置文件
	 * @param filePath
	 */
	public static void readProperties(String filePath) {
	  Properties props = new Properties();
	  try {
		  InputStream in = new BufferedInputStream(new FileInputStream(filePath));
		  props.load(in);
		  driverClass = props.getProperty("jdbc.driverClassName");
		  url =  props.getProperty("jdbc.url");
		  username = props.getProperty("jdbc.username");
		  password = props.getProperty("jdbc.password");
	  } catch (Exception e) {
	  e.printStackTrace();
	  }
	}
}

