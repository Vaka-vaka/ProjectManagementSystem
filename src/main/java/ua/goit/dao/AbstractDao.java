/**
 * JavaDeveloper3. Module 4. JDBC
 *
 * @autor Valentin Mozul
 * @version of 05.11.2021
 */

package ua.goit.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

abstract public class AbstractDao<T extends Identity> implements Dao<T> {

    abstract String getTableName();

    abstract T mapToEntity(ResultSet resultSet) throws SQLException;

    @Override
    public void delete(T entity) {
        String sql = String.format("delete from %s where id = ?", getTableName());
        DbHelper.executeWithPreparedStatement(sql, ps -> {
            ps.setLong(1, entity.getId());
        });
        System.out.println("Deleted records from " + getTableName());
    }

    @Override
    public Optional<T> get(long id) {
        String query = String.format("select * from %s where id = ?", getTableName());
        try {
            ResultSet resultSet = DbHelper.getWithPreparedStatement(
                    query, ps -> {
                        ps.setLong(1, id);
                    });
            if (resultSet.next()) {
                System.out.println("Record was selected");
                return Optional.of(mapToEntity(resultSet));
            } else {
                return Optional.empty();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public List<T> getAll() {
        List<T> resultList = new ArrayList<>();
        String query = String.format("select * from %s", getTableName());
        try {
            ResultSet resultSet = DbHelper.getWithPreparedStatement(
                    query, ps -> {
                    });
            while (resultSet.next()) {
                resultList.add(mapToEntity(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultList;
    }
}
