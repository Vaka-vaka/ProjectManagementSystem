/**
 * ProjectManagementSystem. Module 4. JDBC
 *
 * @autor Valentin Mozul
 * @version of 16.11.2021
 */

package ua.goit.console;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.goit.console.commands.*;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.*;
import java.util.function.Consumer;

public class MainMenuCommand implements Command {

    private static final Logger LOGGER = LogManager.getLogger(MainMenuCommand.class);

    Map<String, Command> commandMap = new HashMap<>();

    public MainMenuCommand() {
        commandMap.put("developers", new DevelopersCommand());
        commandMap.put("skills", new SkillsCommand());
        commandMap.put("projects", new ProjectsCommand());
        commandMap.put("companies", new CompaniesCommand());
        commandMap.put("customers", new CustomersCommand());
        commandMap.put("home_work", new HomeWork());
    }

    @Override
    public void handle(String params, Consumer<Command> setActive) {
        Optional<String> commandString = getCommandString(params);
        commandString.map(commandMap::get)
                .ifPresent(command -> {
                    try {
                        setActive.accept(command);
                        command.handle(params.replace(commandString.get(), "").trim(), setActive);
                    } catch (ParseException | SQLException e) {
                        LOGGER.error("ParseException error: " + e);
                    }
                });
    }

    @Override
    public void printActiveMenu() {
        LOGGER.info("---------------------Main menu---------------------");
        LOGGER.info("Main commands: [main, active, exit]");
        LOGGER.info("Command list: " + this.commandMap.keySet());
    }
}
