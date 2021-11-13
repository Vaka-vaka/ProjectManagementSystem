/**
 * ProjectManagementSystem. Module 4. JDBC
 *
 * @autor Valentin Mozul
 * @version of 02.11.2021
 */

package ua.goit;

import ua.goit.console.CommandHandler;
import java.util.*;

public class Main {

        public static void main (String[]args){

            System.out.println("Start application");
            CommandHandler commandHandler = new CommandHandler();
            Scanner scanner = new Scanner(System.in);
            while (scanner.hasNext()) {
                commandHandler.handleCommand(scanner.nextLine());
            }
            System.out.println("And application");
        }
    }