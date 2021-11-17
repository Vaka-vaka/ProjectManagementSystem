/**
 * ProjectManagementSystem. Module 4. JDBC
 *
 * @autor Valentin Mozul
 * @version of 12.11.2021
 */

package ua.goit.console.commands;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.goit.console.Command;
import ua.goit.dao.DevelopersDao;
import ua.goit.model.Developers;

import java.util.*;
import java.util.function.Consumer;


public class DevelopersCommand implements Command {

    private static final Logger LOGGER = LogManager.getLogger(DevelopersCommand.class);

    private final DevelopersDao developersDao = new DevelopersDao();

    @Override
    public void handle(String params, Consumer<Command> setActive) {
        String[] paramsArray = params.split(" ");
        String subParams = String.join(" "
                , params.replace(paramsArray[0] + " ", ""));
        switch (paramsArray[0]) {
            case "create":
                create(subParams);
                break;
            case "get":
                get(subParams);
                break;
            case "getAll":
                getAll();
                break;
            case "delete":
                delete(subParams);
                break;
            case "update":
                update(subParams);
                break;
        }
    }

    private void getAll() {
        List<Developers> all = developersDao.getAll();
        System.out.println("Returned " + all.size() + " developers");
        for (Developers developers : all) {
            System.out.println(developers);
        }
    }

    private void update(String params) {
        String[] paramsArray = params.split(" ");
        Optional<Developers> optionalDevelopers = developersDao
                .get(Long.parseLong(paramsArray[0]));
        if (optionalDevelopers.isPresent()) {
            Developers developers = optionalDevelopers.get();
            developers.setName_(paramsArray[1]);
            developers.setAge(Long.parseLong(paramsArray[2]));
            developers.setGender(paramsArray[3]);
            developers.setSalary(Integer.parseInt(paramsArray[4]));
            developersDao.update(developers);
        } else {
            System.out.println("User with id " + paramsArray[0] + " not found");
        }
    }

    private void create(String params) {
        /** без ID не виходить, кидає помилку сама база SQL
         * (Error [23505]: ПОМИЛКА: повторювані значення ключа порушують обмеження унікальності "developers_pkey"
         *  Подробности: Ключ (id)=(1) вже існує.
         *  ПОМИЛКА: повторювані значення ключа порушують обмеження унікальності "developers_pkey"
         *  Подробности: Ключ (id)=(1) вже існує.
         *  ПОМИЛКА: повторювані значення ключа порушують обмеження унікальності "developers_pkey"
         *  Подробности: Ключ (id)=(1) вже існує.)
         *автоматично не може призначить ID
         */
        String[] paramsArray = params.split(" ");
        Developers developers = new Developers();
        developers.setId(Long.parseLong(paramsArray[0]));
        developers.setName_(paramsArray[1]);
        developers.setAge(Long.parseLong(paramsArray[2]));
        developers.setGender(paramsArray[3]);
        developers.setSalary(Integer.parseInt(paramsArray[4]));
        developersDao.create(developers);
    }

    private void get(String params) {
        String[] paramsArray = params.split(" ");
        Optional<Developers> developers = developersDao
                .get(Long.parseLong(paramsArray[0]));
        if (developers.isPresent()) {
            System.out.println(developers.get());
        } else {
            System.out.println("Developers with id " + paramsArray[0] + " not found");
        }
    }

    private void delete(String params) {
        String[] paramsArray = params.split(" ");
        Optional<Developers> developers = developersDao
                .get(Long.parseLong(paramsArray[0]));
        if (developers.isPresent()) {
            developersDao.delete(developers.get());
        } else {
            System.out.println("Developers with id " + paramsArray[0] + " not found");
        }
    }

    @Override
    public void printActiveMenu() {
        LOGGER.info("---------------------Developers menu---------------------");
        LOGGER.info("Developers command list:");
        LOGGER.info("create [id] [name_] [age] [gender] [salary]");
        LOGGER.info("get [id]");
        LOGGER.info("getAll");
        LOGGER.info("update [id] [name_] [age] [gender] [salary]");
        LOGGER.info("delete [id]");
    }
}
