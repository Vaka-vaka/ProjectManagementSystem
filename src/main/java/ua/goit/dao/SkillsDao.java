/**
 * ProjectManagementSystem. Module 4. JDBC
 *
 * @autor Valentin Mozul
 * @version of 13.11.2021
 */

package ua.goit.dao;

import ua.goit.model.Skills;
import java.sql.*;
import java.util.*;

public class SkillsDao extends AbstractDao<Skills> {

    @Override
    String getTableName() {
        return "skills";
    }

    @Override
    Skills mapToEntity(ResultSet resultSet) throws SQLException {
        Skills skills = new Skills();
        skills.setId(resultSet.getLong("id"));
        skills.setLanguage(resultSet.getString("language"));
        skills.setLevel_skills(resultSet.getString("level_skills"));
        return skills;
    }

    @Override
    public Optional<Skills> create(Skills entity) {
        String sql = "insert into skills(id, language, level_skills) values (?, ?, ?)";
        int count = DbHelper.executeWithPreparedStatement(sql, ps -> {
            ps.setLong(1, entity.getId());
            ps.setString(2, entity.getLanguage());
            ps.setString(3, entity.getLevel_skills());
        });
        System.out.println("Created " + count + " records");
        return Optional.empty();
    }

    @Override
    public void update(Skills entity) {
        String sql = "update skills set language = ?, level_skills = ? where id = ?";
        int count = DbHelper.executeWithPreparedStatement(sql, ps -> {
            ps.setString(1, entity.getLanguage());
            ps.setString(2, entity.getLevel_skills());
            ps.setLong(3, entity.getId());
        });
        System.out.println("Updated " + count + " records");
    }
}
