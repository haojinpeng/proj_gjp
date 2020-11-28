package cn.it.zw.tools;

import org.apache.commons.dbcp.BasicDataSource;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.Properties;

/**
 * @author     ：zyx
 * @date       ：Created in 2020/7/3 14:16
 * @description：连接数据库封装
 * 连接池
 * @modified By：
 * @version:     $
 */
public class JDBCPoolUtils {
    private static String driverClassName;
    private static String url;
    private static String username;
    private static String password;
    private static String maxActive;
    private static String maxIdle;
    private static String minIdle;
    private static String initialSize;
    private static String maxWait;
    static BasicDataSource dataSource = null;
    /**
     * 获取4个值
     * Properties类
     * key-value
     * 并且加载驱动
     */
    static {
        dataSource = new BasicDataSource();

        Properties properties = new Properties();

        try {
            properties.load(JDBCPoolUtils.class.getClassLoader().getResourceAsStream("dbpool.properties"));
            driverClassName = properties.getProperty("driverClassName");
            url = properties.getProperty("url");
            username = properties.getProperty("username");
            password = properties.getProperty("password");
            maxActive = properties.getProperty("maxActive");
            maxIdle = properties.getProperty("maxIdle");
            minIdle = properties.getProperty("minIdle");
            initialSize = properties.getProperty("initialSize");
            maxWait = properties.getProperty("maxWait");
            //System.out.println("driverClassName-->"+driverClassName);
            dataSource.setDriverClassName(driverClassName);
            dataSource.setUrl(url);
            dataSource.setUsername(username);
            dataSource.setPassword(password);
            dataSource.setInitialSize(Integer.parseInt(initialSize));
            dataSource.setMaxActive(Integer.parseInt(maxActive));
            dataSource.setMaxIdle(Integer.parseInt(maxIdle));
            dataSource.setMinIdle(Integer.parseInt(minIdle));
            dataSource.setMaxWait(Long.parseLong(maxWait));

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    /**
     * 数据源
     * @return
     */
    public static DataSource getDataSource(){

        return  dataSource;
    }

}
