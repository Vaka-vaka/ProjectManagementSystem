/**
 * ProjectManagementSystem. Module 4. JDBC
 *
 * @autor Valentin Mozul
 * @version of 02.11.2021
 */

package ua.goit;

import ua.goit.console.CommandHandler;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.*;

public class Main {

        public static void main (String[]args) throws ParseException, SQLException {
            System.out.println("--Developers, Skills, Projects, Companies, Customers menu--");
            System.out.println("Command list: ");
            System.out.println("---------------------------------------------------------------------");
            System.out.println("Developers create id name_ age gender salary");
            System.out.println("Skills create id language level_skills");
            System.out.println("Projects create id name_ language cost creation_date");
            System.out.println("Companies create id name_ city");
            System.out.println("Customers create id name_ city");
            System.out.println("---------------------------------------------------------------------");
            System.out.println("Developers update id name_ age gender salary");
            System.out.println("Skills update id language level_skills");
            System.out.println("Projects update id name_ language cost creation_date");
            System.out.println("Companies update id name_ city");
            System.out.println("Customers update id name_ city");
            System.out.println("---------------------------------------------------------------------");
            System.out.println("Developers getAll");
            System.out.println("Skills getAll");
            System.out.println("Projects getAll");
            System.out.println("Companies getAll");
            System.out.println("Customers getAll");
            System.out.println("---------------------------------------------------------------------");
            System.out.println("Developers get");
            System.out.println("Skills get");
            System.out.println("Projects get");
            System.out.println("Companies get");
            System.out.println("Customers get");
            System.out.println("---------------------------------------------------------------------");
            System.out.println("Developers delete id");
            System.out.println("Skills delete id");
            System.out.println("Projects delete id");
            System.out.println("Companies delete id");
            System.out.println("Customers delete id");
            System.out.println("=====================================");
            System.out.println("-------------------------HomeWork menu------------------------");
            System.out.println("1. Salary (amount) of all developers of a single project:"
            + " please enter the words - sum salary.");
            System.out.println("2. List of developers for a single project:" + " please " +
                    "enter the words - developer project.");
            System.out.println("3. List of all Java developers:" + " please " +
                    "enter the words - java developers.");
            System.out.println("4. List of all middle developers:" + " please " +
                    "enter the words - middle developer.");
            System.out.println("5. List of projects:" + " please enter the words - list go.");
            System.out.println("Start application.......");
            CommandHandler commandHandler = new CommandHandler();
            Scanner scanner = new Scanner(System.in);
            while (scanner.hasNext()) {
                commandHandler.handleCommand(scanner.nextLine());
            }
            System.out.println("And application");
        }
    }