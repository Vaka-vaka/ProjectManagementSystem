/**
 * ProjectManagementSystem. Module 4. JDBC
 *
 * @autor Valentin Mozul
 * @version of 13.11.2021
 */

package ua.goit.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.goit.model.Companies;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class CompaniesDao extends AbstractDao<Companies>{

    private static final Logger LOGGER = LogManager.getLogger(CompaniesDao.class);

    @Override
    String getTableName() {
        return "companies";
    }

    @Override
    Companies mapToEntity(ResultSet resultSet) throws SQLException {
        Companies companies = new Companies();
        companies.setId(resultSet.getLong("id"));
        companies.setName_(resultSet.getString("name_"));
        companies.setCity(resultSet.getString("city"));
        return companies;
    }

    @Override
    public Optional<Companies> create(Companies entity) {
        String sql = "insert into companies(id, name_, city)" +
                " values (?, ?, ?)";
        int count = DbHelper.executeWithPreparedStatement(sql, ps -> {
            ps.setLong(1, entity.getId());
            ps.setString(2, entity.getName_());
            ps.setString(3, entity.getCity());
        });
        LOGGER.info("Created " + count + " records");
        return Optional.empty();
    }

    @Override
    public void update(Companies entity) {
        String sql = "update companies set name_ = ?, city = ? where id = ?";
        int count = DbHelper.executeWithPreparedStatement(sql, ps -> {
            ps.setString(1, entity.getName_());
            ps.setString(2, entity.getCity());
            ps.setLong(3, entity.getId());
        });
        LOGGER.info("Updated " + count + " records");
    }
}
