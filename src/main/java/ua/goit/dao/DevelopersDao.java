/**
 * JavaDeveloper3. Module 4. JDBC
 *
 * @autor Valentin Mozul
 * @version of 10.11.2021
 */

package ua.goit.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.goit.model.Developers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class DevelopersDao extends AbstractDao<Developers> {

    private static DevelopersDao instance;

    private DevelopersDao() {
    }

    public static DevelopersDao getInstance() {
        if (instance == null) {
            instance = new DevelopersDao();
        }
        return instance;
    }

    private static final Logger LOGGER = LogManager.getLogger(DevelopersDao.class);

    String getTableName() {
        return "developers";
    }

    @Override
    public Developers mapToEntity(ResultSet resultSet) throws SQLException {
        Developers developers = new Developers();
        developers.setId(resultSet.getLong("id"));
        developers.setName(resultSet.getString("name"));
        developers.setAge(resultSet.getLong("age"));
        developers.setGender(resultSet.getString("gender"));
        return developers;
    }

    @Override
    public Optional<Developers> create(Developers developers) {
        String sql = "insert into developers(name, age, gender) values (?, ?, ?)";
        DbHelper.executeWithPreparedStatement(sql, ps -> {
            ps.setString(1, developers.getName());
            ps.setLong(2, developers.getAge());
            ps.setString(3, developers.getGender());
        });
        LOGGER.info("Record was created");
        return Optional.empty();
    }

    @Override
    public void update(Developers developers) {
        String sql = "update developers set name = ?, age = ?, gender = ? where id = ?";
        DbHelper.executeWithPreparedStatement(sql, ps -> {
            ps.setString(1, developers.getName());
            ps.setLong(2, developers.getAge());
            ps.setString(3, developers.getGender());
            ps.setLong(4, developers.getId());
        });
        LOGGER.info("Record was updated");
    }
}
