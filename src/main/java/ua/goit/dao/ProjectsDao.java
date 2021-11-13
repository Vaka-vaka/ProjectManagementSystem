/**
 * ProjectManagementSystem. Module 4. JDBC
 *
 * @autor Valentin Mozul
 * @version of 13.11.2021
 */

package ua.goit.dao;

import ua.goit.model.Projects;
import java.sql.*;
import java.sql.Date;
import java.util.*;

public class ProjectsDao extends AbstractDao<Projects> {

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
        projects.setCreation_date(resultSet.getDate("Creation_date"));
        return projects;
    }

    @Override
    public Optional<Projects> create(Projects entity) {
        String sql = "insert into projects(id, name_, language, cost, creation_date) values (?, ?, ?, ?, ?)";
        int count = DbHelper.executeWithPreparedStatement(sql, ps -> {
            ps.setLong(1, entity.getId());
            ps.setString(2, entity.getName_());
            ps.setString(3, entity.getLanguage());
            ps.setInt(4, entity.getCost());
            ps.setDate(5, (Date) entity.getCreation_date());
        });
        System.out.println("Created " + count + " records");
        return Optional.empty();
    }

    @Override
    public void update(Projects entity) {
        String sql = "update projects set name_ = ?, language = ?, cost = ?, creation_date = ? where id = ?";
        int count = DbHelper.executeWithPreparedStatement(sql, ps -> {
            ps.setString(1, entity.getName_());
            ps.setString(2, entity.getLanguage());
            ps.setInt(3, entity.getCost());
            ps.setDate(3, (Date) entity.getCreation_date());
            ps.setLong(4, entity.getId());
        });
        System.out.println("Updated " + count + " records");
    }
}
