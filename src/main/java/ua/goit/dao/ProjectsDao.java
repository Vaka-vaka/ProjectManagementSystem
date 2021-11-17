/**
 * ProjectManagementSystem. Module 4. JDBC
 *
 * @autor Valentin Mozul
 * @version of 13.11.2021
 */

package ua.goit.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.goit.model.Projects;
import java.sql.*;
import java.util.*;

public class ProjectsDao extends AbstractDao<Projects> {

    private static final Logger LOGGER = LogManager.getLogger(ProjectsDao.class);

    @Override
    String getTableName() {
        return "projects";
    }

    @Override
    Projects mapToEntity(ResultSet resultSet) throws SQLException {
        Projects projects = new Projects();
        projects.setId(resultSet.getLong("id"));
        projects.setName_(resultSet.getString("name_"));
        projects.setLanguage(resultSet.getString("language"));
        projects.setCost(resultSet.getInt("cost"));
        projects.setCreation_date(resultSet.getDate("creation_date"));
        return projects;
    }

    @Override
    public Optional<Projects> create(Projects entity) {
        String sql = "insert into projects(id, name_, language, creation_date, cost)" +
                " values (?, ?, ?, ?, ?)";
        int count = DbHelper.executeWithPreparedStatement(sql, ps -> {
            ps.setLong(1, entity.getId());
            ps.setString(2, entity.getName_());
            ps.setString(3, entity.getLanguage());
            ps.setDate(4, (java.sql.Date) entity.getCreation_date());
            ps.setInt(5, entity.getCost());
        });
        LOGGER.info("Created " + count + " records");
        return Optional.empty();
    }

    @Override
    public void update(Projects entity) {
        String sql = "update projects set name_ = ?, language = ?, creation_date = ?, " +
                "cost = ? where id = ?";
        int count = DbHelper.executeWithPreparedStatement(sql, ps -> {
            ps.setString(1, entity.getName_());
            ps.setString(2, entity.getLanguage());
            ps.setDate(3, (java.sql.Date) entity.getCreation_date());
            ps.setInt(4, entity.getCost());
            ps.setLong(5, entity.getId());
        });
        LOGGER.info("Updated " + count + " records");
    }
}
