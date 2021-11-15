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
        switch (paramsArray[0]) {
            case "salary":
                getSumProjectSalary();
                break;
            case "project":
                getListDevelopersProject();
                break;
            case "developers":
                getJavaDevelopers();
                break;
            case "developer":
                getMiddleDevelopers();
                break;
            case "go":
                getListDevelopers();
                break;
        }
    }

    private void getSumProjectSalary() throws SQLException { //sum salary
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

    private void getListDevelopersProject() throws SQLException { // developer project
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

    private static void getJavaDevelopers() throws SQLException { //java developers
        Connection connection = DataSourceHolder.getDataSource().getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from list_java_developers;");
        while (resultSet.next()) {
            System.out.println("Java developer: " + resultSet.getString(1));
        }
        connection.close();
    }

    private static void getMiddleDevelopers() throws SQLException { //middle developer
        Connection connection = DataSourceHolder.getDataSource().getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from  list_middleDevelopers;");
        while (resultSet.next()) {
            System.out.println("Middle developer: " + resultSet.getString(1));
        }
        connection.close();
    }

    private void getListDevelopers() throws SQLException { // list go
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
}
