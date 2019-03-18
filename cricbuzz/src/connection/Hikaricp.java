package connection;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class Hikaricp {
	private static HikariDataSource ds;
	static {

		/* using hikari properties file */
		HikariConfig config = new HikariConfig("/hikari.properties");

		config.setMaximumPoolSize(5);
		config.setMinimumIdle(1);
		config.setIdleTimeout(60000);
		config.setConnectionTimeout(3000);
		config.setAutoCommit(false);

		ds = new HikariDataSource(config);

		if (config == null || ds == null) {
			System.out.print("connection not connect");
		}
	}

	public static Connection getConn() throws SQLException {

		return ds.getConnection();
	}

}
