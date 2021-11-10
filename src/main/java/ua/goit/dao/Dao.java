/**
 * JavaDeveloper3. Module 4. JDBC
 *
 * @autor Valentin Mozul
 * @version of 10.11.2021
 */

package ua.goit.dao;

import ua.goit.dao.interfaces.Identity;

import java.util.*;

public interface Dao<T extends Identity> {
    List<T> getAll();

    Optional<T> get(Long id);

    Optional<T> create(T entity);

    void update(T entity);

    void delete(T entity);
}