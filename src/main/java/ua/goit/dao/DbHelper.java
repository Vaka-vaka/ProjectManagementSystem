/**
 * ProjectManagementSystem. Module 4. JDBC
 *
 * @autor Valentin Mozul
 * @version of 03.11.2021
 */

package ua.goit.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.goit.config.DataSourceHolder;
import java.sql.*;

public class DbHelper {

    private static final Logger LOGGER = LogManager.getLogger(DbHelper.class);

    public static int executeWithPreparedStatement(String sql, ParameterSetter psCall) {
        try (Connection connection = DataSourceHolder.getDataSource().getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            psCall.set(ps);
            return ps.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error("Exception while trying do SQL request", e);
            return 0;
        }
    }

    public static ResultSet getWithPreparedStatement(String sql, ParameterSetter psCall) throws SQLException {
        try (Connection connection = DataSourceHolder.getDataSource().getConnection();
                PreparedStatement ps = connection.prepareStatement(sql)) {
            psCall.set(ps);
            return ps.executeQuery();
        }
    }

    @FunctionalInterface
    public interface ParameterSetter {
        void set(PreparedStatement ps) throws SQLException;
    }

}
