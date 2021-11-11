/**
 * JavaDeveloper3. Module 4. JDBC
 *
 * @autor Valentin Mozul
 * @version of 10.11.2021
 */

package ua.goit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.goit.config.DbMigrations;
import ua.goit.console.CommandHandler;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.Scanner;

public class App {

    private static final Logger LOGGER = LogManager.getLogger(App.class);

    public static void main(String[] args) throws SQLException, ParseException {
        LOGGER.debug("Start application");
        DbMigrations.migrate();

        runMainApp();
        LOGGER.info("END application");
    }

    public static void runMainApp() throws SQLException, ParseException {

        CommandHandler commandHandler = new CommandHandler();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            commandHandler.handleCommand(scanner.nextLine());
        }
    }
}