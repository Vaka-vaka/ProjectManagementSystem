/**
 * ProjectManagementSystem. Module 4. JDBC
 *
 * @autor Valentin Mozul
 * @version of 13.11.2021
 */

package ua.goit.dao;

import ua.goit.model.Customers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class CustomersDao extends AbstractDao<Customers> {

    @Override
    String getTableName() {
        return "customers";
    }

    @Override
    Customers mapToEntity(ResultSet resultSet) throws SQLException {
        Customers customers = new Customers();
        customers.setId(resultSet.getLong("id"));
        customers.setName_(resultSet.getString("name_"));
        customers.setCity(resultSet.getString("city"));
        return customers;
    }

    @Override
    public Optional<Customers> create(Customers entity) {
        String sql = "insert into customers(id, name_, city)" +
                " values (?, ?, ?)";
        int count = DbHelper.executeWithPreparedStatement(sql, ps -> {
            ps.setLong(1, entity.getId());
            ps.setString(2, entity.getName_());
            ps.setString(3, entity.getCity());
        });
        System.out.println("Created " + count + " records");
        return Optional.empty();
    }

    @Override
    public void update(Customers entity) {
        String sql = "update customers set name_ = ?, city = ? where id = ?";
        int count = DbHelper.executeWithPreparedStatement(sql, ps -> {
            ps.setString(1, entity.getName_());
            ps.setString(2, entity.getCity());
            ps.setLong(3, entity.getId());
        });
        System.out.println("Updated " + count + " records");
    }
}

