/**
 * JavaDeveloper3. Module 4. JDBC
 *
 * @autor Valentin Mozul
 * @version of 02.11.2021
 */

package ua.goit.dao;

import ua.goit.model.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class UserDao extends AbstractDao<User> {

    String getTableName() {
        return "users";
    }

    @Override
    User mapToEntity(ResultSet resultSet) throws SQLException {
        User user = new User();
        user.setId(resultSet.getLong("id"));
        user.setName(resultSet.getString("name"));
        user.setDescription(resultSet.getString("description"));
        return user;
    }

    @Override
    public Optional<User> create(User user) {
        String sql = "insert into users(name, description) values (?, ?)";
        int count = DbHelper.executeWithPreparedStatement(sql, ps -> {
            ps.setString(1, user.getName());
            ps.setString(2, user.getDescription());
        });
        System.out.println("Created " + count + " records");
        return Optional.empty();
    }

    @Override
    public void update(User user) {
        String sql = "update users set name = ?, description = ? where id = ?";
        int count = DbHelper.executeWithPreparedStatement(sql, ps -> {
            ps.setString(1, user.getName());
            ps.setString(2, user.getDescription());
            ps.setLong(3, user.getId());
        });
        System.out.println("Updated " + count + " records");
    }

}
