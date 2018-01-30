package devweb.dao.impl;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.util.Properties;

public class DataSourceProvider {
    private static MysqlDataSource dataSource;

    public static DataSource getDataSource() {

        if (dataSource == null) {
            initDataSource();
        }
        return dataSource;
    }

    private static void initDataSource(){
        Properties jdbcProperties = new Properties();
        try{
            jdbcProperties.load(DataSourceProvider.class.getClassLoader().getResourceAsStream("jdbc.properties"));
            dataSource = new MysqlDataSource();

            dataSource.setServerName(jdbcProperties.getProperty("jdbc.server.host"));
            dataSource.setPort(Integer.parseInt(jdbcProperties.getProperty("jdbc.server.port")));
            dataSource.setDatabaseName(jdbcProperties.getProperty("jdbc.database"));
            dataSource.setUser(jdbcProperties.getProperty("jdbc.user"));
            dataSource.setPassword(jdbcProperties.getProperty("jdbc.password"));
        }catch(Exception e){
            e.printStackTrace();
        }

    }

}