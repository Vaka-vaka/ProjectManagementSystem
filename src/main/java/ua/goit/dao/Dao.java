/**
 * ProjectManagementSystem. Module 4. JDBC
 *
 * @autor Valentin Mozul
 * @version of 02.11.2021
 */

package ua.goit.dao;

import java.util.*;

public interface Dao<T extends Identity> {
    List<T> getAll();

    Optional<T> get(long id);

    Optional<T> create(T entity);

    void update(T entity);

    void delete(T entity);
}
