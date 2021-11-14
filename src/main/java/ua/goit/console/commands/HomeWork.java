/**
 * ProjectManagementSystem. Module 4. JDBC
 *
 * @autor Valentin Mozul
 * @version of 14.11.2021
 */

package ua.goit.console.commands;

import ua.goit.config.DataSourceHolder;
import ua.goit.console.Command;
import java.sql.Connection;
import java.sql.*;

public class HomeWork implements Command {

    @Override
    public void handle(String params) throws SQLException {
        String[] paramsArray = params.split(" ");
        String subParams = String.join(" "
                , params.replace(paramsArray[0] + " ", ""));
        if ("javaDevelopers".equals(paramsArray[0])) {
            javaDevelopers();
        }
    }

    public static void javaDevelopers() throws SQLException {
        Connection connection = DataSourceHolder.getDataSource().getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from list_java_developers;");
        while (resultSet.next()) {
            System.out.println("Java developer: " + resultSet.getString(1));
        }
        connection.close();
    }

    
}
