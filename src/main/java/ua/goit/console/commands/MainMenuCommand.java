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

import java.util.*;
import java.util.Optional;
import java.util.function.Consumer;

public class MainMenuCommand implements Command {

    private static final Logger LOGGER = LogManager.getLogger(MainMenuCommand.class);

    Map<String, Command> commands = Map.of(
            "developers", new DevelopersCommand()

    );

    @Override
    public void handle(String params, Consumer<Command> setActive) {
        Optional<String> commandString = getCommandString(params);
        commandString.map(commands::get)
                .ifPresent(command -> {
                    setActive.accept(command);
                    command.handle(params.replace(commandString.get(),
                            "").trim(), setActive);
                });
    }

    @Override
    public void printActiveMenu() {
        LOGGER.info("---------Main menu----------");
        LOGGER.info("Command list: " + this.commands.keySet());
    }
}
