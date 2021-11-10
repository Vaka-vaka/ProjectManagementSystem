/**
 * JavaDeveloper3. Module 4. JDBC
 *
 * @autor Valentin Mozul
 * @version of 10.11.2021
 */

package ua.goit.console.commands;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.goit.console.Command;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.*;
import java.util.Optional;
import java.util.function.Consumer;

public class MainMenuCommand implements Command {

    private static final Logger LOGGER = LogManager.getLogger(MainMenuCommand.class);

    Map<String, Command> commands = new HashMap<>();

    public MainMenuCommand() {
        commands.put("developer", new DevelopersCommand());
//        commands.put("customer", new CustomerCommand());
//        commands.put("company", new CompanyCommand());
//        commands.put("project", new ProjectCommand());
//        commands.put("skill", new SkillCommand());
    }
//    Map<String, Command> commands = Map.of(
//            "developers", new DevelopersCommand()
//
//    );

    @Override
    public void handle(String params, Consumer<Command> setActive) {
        Optional<String> commandString = getCommandString(params);
        commandString.map(commands::get)
                .ifPresent(command -> {
                    try {
                        setActive.accept(command);
                        command.handle(params.replace(commandString.get(), "")
                                .trim(), setActive);
                    } catch (ParseException | SQLException e) {
                        LOGGER.error("ParseException error: " + e);
                    }
                });
    }

    @Override
    public void printActiveMenu() {
        LOGGER.info("---------------------Main menu---------------------");
        LOGGER.info("Main commands: [main, active, exit]");
        LOGGER.info("Command list: " + this.commands.keySet());
    }
}