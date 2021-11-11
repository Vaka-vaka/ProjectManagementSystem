/**
 * JavaDeveloper3. Module 4. JDBC
 *
 * @autor Valentin Mozul
 * @version of 10.11.2021
 */

package ua.goit.config;

import org.flywaydb.core.Flyway;

public class DbMigrations {

    public static void migrate() {

//        Flyway flyway = Flyway.configure()
//                .dataSource("jdbc:postgresql://localhost:5432/Developer",
//                        "postgres", "A1S5nkO/J2*33Wu").load();
//        flyway.migrate();


        Flyway flyway = Flyway.configure()
                .dataSource(DataSourceHolder.getDataSource())
                .load();
        flyway.migrate();
    }
}
