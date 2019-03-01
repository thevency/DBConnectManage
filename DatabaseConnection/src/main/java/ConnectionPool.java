import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionPool {
    public static HikariConfig config = new HikariConfig();
    private static HikariDataSource dataSource;

    static{
        config.setJdbcUrl("jdbc:oracle:thin:@10.50.172.45:49161:xe");
        config.setUsername("system");
        config.setPassword("oracle");
        config.addDataSourceProperty("implicitCachingEnabled","true");
        config.addDataSourceProperty("prepStmtCacheSize", "250");
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
        config.setMaximumPoolSize(4);
        dataSource = new HikariDataSource(config);
    }

    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }


}
