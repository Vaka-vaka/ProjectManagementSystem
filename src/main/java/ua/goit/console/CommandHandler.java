/**
 * ProjectManagementSystem. Module 4. JDBC
 *
 * @autor Valentin Mozul
 * @version of 08.11.2021
 */

package ua.goit.console;

import ua.goit.console.commands.DevelopersCommand;
import ua.goit.console.commands.SkillsCommand;
import ua.goit.console.commands.UsersCommand;
import java.util.*;

public class CommandHandler {

    Map<String, Command> commandMap = new HashMap<>();

    public CommandHandler() {
        commandMap.put("users", new UsersCommand());
        commandMap.put("developers", new DevelopersCommand());
        commandMap.put("skills", new SkillsCommand());

    }

    public void handleCommand(String params) {
        int firstSpace = params.indexOf(" ");
        if (firstSpace > -1) {
            Command command = commandMap
                    .get(params.substring(0, firstSpace));
            if(command != null) {
                command.handle(params.substring(firstSpace + 1));
            }else {
                System.out.println("Unknown command");
            }
        }else {
            System.out.println("Unknown command");
        }
    }

}
