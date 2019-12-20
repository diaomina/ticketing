package com.cn.util;

import java.io.FileReader;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.mchange.v2.c3p0.ComboPooledDataSource;


/**
 * @Description 连接数据库的工具类
 * @author ljy
 * @since 1.0
 * @version 1.0
 * @date 2019年8月14日
 *
 */
public class JDBCUtil {

	private static String driver;
	private static String url;
	private static String user;
	private static String password;
	
	private static ComboPooledDataSource dataSource = null;;
	
	
	private static Logger logger = Logger.getLogger(JDBCUtil.class.getName());
	
	static {
        //读取文件，获取值
        try {
            //1.创建Properties集合类
            Properties pro = new Properties();
            //获取src路径下的文件--->ClassLoader类加载器
            ClassLoader classLoader = JDBCUtil.class.getClassLoader();
            URL resource = classLoader.getResource("jdbc.properties");
            String path = resource.getPath();
            //2.加载文件
            pro.load(new FileReader(path));
            //3获取数据
            url = pro.getProperty("jdbc.url");
            user = pro.getProperty("jdbc.user");
            password = pro.getProperty("jdbc.password");
            driver = pro.getProperty("jdbc.driver");
            //4.注册驱动
//            Class.forName(driver);
            
            //5.配置数据源
            dataSource = new ComboPooledDataSource();
            dataSource.setDriverClass(driver);
            dataSource.setJdbcUrl(url);
            dataSource.setUser(user);
            dataSource.setPassword(password);
            dataSource.setInitialPoolSize(10);
            dataSource.setMaxPoolSize(50);
            dataSource.setMinPoolSize(1);
            dataSource.setAcquireIncrement(3);
        } catch (Exception e) {
        	logger.error("注册Driver驱动发生异常。", e);
        	e.printStackTrace();
        }
    }

	
	
	/**
	 * 返回数据库链接
	 * @return
	 */
	public static Connection getConnection() {
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
//			conn = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			logger.error("获取Connection连接发生异常。", e);
			e.printStackTrace();
		}
		return conn;
	}

}
	
