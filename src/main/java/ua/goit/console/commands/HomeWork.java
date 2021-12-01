/**
 * ProjectManagementSystem. Module 4. JDBC
 *
 * @autor Valentin Mozul
 * @version of 14.11.2021
 */

package ua.goit.console.commands;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.goit.config.DataSourceHolder;
import ua.goit.console.Command;

import java.sql.Connection;
import java.sql.*;
import java.util.function.Consumer;

public class HomeWork implements Command {

    private static final Logger LOGGER = LogManager.getLogger(HomeWork.class);

    @Override
    public void handle(String params, Consumer<Command> setActive) throws SQLException {
        String[] paramsArray = params.split(" ");
        String subParams = String.join(" "
                , params.replace(paramsArray[0] + " ", ""));
        switch (paramsArray[0]) {
            case "salary":
                getSumProjectSalary();
                break;
            case "project":
                getListDevelopersProject();
                break;
            case "java":
                getJavaDevelopers();
                break;
            case "middle":
                getMiddleDevelopers();
                break;
            case "list":
                getListDevelopers();
                break;
        }
    }

    private void getSumProjectSalary() throws SQLException {
        Connection connection = DataSourceHolder.getDataSource().getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement
                .executeQuery("select * from sum_salary_developers_project;");

        while (resultSet.next()) {
            System.out.println("Project name: " + resultSet.getString(1) +
                    " ; " + "Sum salary developer: " + resultSet.getString(2));
        }
        connection.close();
    }

    private void getListDevelopersProject() throws SQLException {
        Connection connection = DataSourceHolder.getDataSource().getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement
                .executeQuery("select p.name_, trim(d.name_ || ' ' || d.age) as d_name_ \n" +
                        "from projects p\n" +
                        "join developers_projects dp on dp.projects_id = p.id\n" +
                        "join developers d on dp.dev_id = d.id\n" +
                        "group by p.name_, trim(d.name_ || ' ' || d.age)\n" +
                        "order by 1;");
        while (resultSet.next()) {
            System.out.println("Project name: " + resultSet.getString(1) +
                    " ; " + "List developer: " + resultSet.getString(2));
        }
        connection.close();
    }

    private static void getJavaDevelopers() throws SQLException {
        Connection connection = DataSourceHolder.getDataSource().getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from list_java_developers;");
        while (resultSet.next()) {
            System.out.println("Java developer: " + resultSet.getString(1));
        }
        connection.close();
    }

    private static void getMiddleDevelopers() throws SQLException {
        Connection connection = DataSourceHolder.getDataSource().getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from  list_middleDevelopers;");
        while (resultSet.next()) {
            System.out.println("Middle developer: " + resultSet.getString(1));
        }
        connection.close();
    }

    private void getListDevelopers() throws SQLException {
        Connection connection = DataSourceHolder.getDataSource().getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement
                .executeQuery("SELECT count (dp.dev_id) || ' - ' || p.name_" +
                        " || ' - ' || to_char (p.creation_date, 'dd.mm.yyyy') as list_project\n" +
                        "FROM projects p\n" +
                        "JOIN developers_projects dp on dp.projects_id = p.id\n" +
                        "GROUP BY creation_date, p.name_;");
        while (resultSet.next()) {
            System.out.println("Count developer: " + resultSet.getString(1) + " ; ");
        }
        connection.close();
    }

    @Override
    public void printActiveMenu() {
        LOGGER.info("---------------------home_work menu---------------------");
        LOGGER.info("1. Salary (amount) of all developers of a single project:"
                + " please enter the words - salary.");
        LOGGER.info("2. List of developers for a single project:" +
                " please enter the words - project.");
        LOGGER.info("3. List of all Java developers:" +
                " please enter the words - java.");
        LOGGER.info("4. List of all middle developers: " +
                "please enter the words - middle.");
        LOGGER.info("5. List of projects: please enter the words - list.");
    }
}
