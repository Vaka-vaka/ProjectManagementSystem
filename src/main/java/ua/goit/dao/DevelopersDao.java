/**
 * ProjectManagementSystem. Module 4. JDBC
 *
 * @autor Valentin Mozul
 * @version of 12.11.2021
 */

package ua.goit.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.goit.model.Developers;
import java.sql.*;
import java.util.*;

public class DevelopersDao extends AbstractDao<Developers> {

    private static final Logger LOGGER = LogManager.getLogger(DevelopersDao.class);

    @Override
    String getTableName() {
        return "developers";
    }

    @Override
    Developers mapToEntity(ResultSet resultSet) throws SQLException {
        Developers developers = new Developers();
        developers.setId(resultSet.getLong("id"));
        developers.setName_(resultSet.getString("name_"));
        developers.setAge(resultSet.getLong("age"));
        developers.setGender(resultSet.getString("gender"));
        developers.setSalary(resultSet.getInt("salary"));
        return developers;
    }

    @Override
    public Optional<Developers> create(Developers entity) {
        String sql = "insert into developers(id, name_, age, gender, salary) values (?, ?, ?, ?, ?)";
        int count = DbHelper.executeWithPreparedStatement(sql, ps -> {
            ps.setLong(1, entity.getId());
            ps.setString(2, entity.getName_());
            ps.setLong(3, entity.getAge());
            ps.setString(4, entity.getGender());
            ps.setInt(5, entity.getSalary());
        });
        LOGGER.info("Created " + count + " records");
        return Optional.empty();
    }

    @Override
    public void update(Developers entity) {
        String sql = "update developers set name_ = ?, age = ?, gender = ?," +
                " salary = ? where id = ?";
        int count = DbHelper.executeWithPreparedStatement(sql, ps -> {
            ps.setString(1, entity.getName_());
            ps.setLong(2, entity.getAge());
            ps.setString(3, entity.getGender());
            ps.setInt(4, entity.getSalary());
            ps.setLong(5, entity.getId());
        });
        LOGGER.info("Updated " + count + " records");
    }
}
