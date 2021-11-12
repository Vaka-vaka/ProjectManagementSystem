/**
 * JavaDeveloper3. Module 4. JDBC
 *
 * @autor Valentin Mozul
 * @version of 09.11.2021
 */

package ua.goit.dao;

import ua.goit.model.Category;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class CategoryDao extends AbstractDao<Category>{

    @Override
    String getTableName() {
        return "category";
    }

    @Override
    Category mapToEntity(ResultSet resultSet) throws SQLException {
        Category category = new Category();
        category.setId(resultSet.getLong("id"));
        category.setName(resultSet.getString("name"));
        category.setDescription(resultSet.getString("description"));
        category.setParentId(resultSet.getLong("parent_id"));
        return category;
    }

    @Override
    public Optional<Category> create(Category category) {
        String sql = "insert into category(name, description, parent_id) values (?, ?, ?)";
        int count = DbHelper.executeWithPreparedStatement(sql, ps -> {
            ps.setString(1, category.getName());
            ps.setString(2, category.getDescription());
            ps.setLong(3, category.getParentId());
        });
        System.out.println("Created " + count + " records");
        return Optional.empty();
    }

    @Override
    public void update(Category entity) {
        String sql = "update category set name = ?, description = ?, parent_id = ? where id = ?";
        int count = DbHelper.executeWithPreparedStatement(sql, ps -> {
            ps.setString(1, entity.getName());
            ps.setString(2, entity.getDescription());
            ps.setLong(3, entity.getParentId());
            ps.setLong(4, entity.getId());
        });
        System.out.println("Updated " + count + " records");
    }
}
