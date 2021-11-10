/**
 * JavaDeveloper3. Module 4. JDBC
 *
 * @autor Valentin Mozul
 * @version of 10.11.2021
 */

package ua.goit.dao;

import ua.goit.dao.interfaces.Identity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

abstract class AbstractDao<T extends Identity> implements Dao<T> {

    abstract String getTableName();

    abstract T mapToEntity(ResultSet resultSet) throws SQLException;

    @Override
    public List<T> getAll() {
        return null;
    }

    @Override
    public Optional<T> get(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<T> create(T entity) {
        return Optional.empty();
    }

    @Override
    public void update(T entity) {

    }

    @Override
    public void delete(T entity) {

    }
}
