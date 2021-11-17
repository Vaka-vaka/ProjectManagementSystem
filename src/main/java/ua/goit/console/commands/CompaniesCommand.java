/**
 * ProjectManagementSystem. Module 4. JDBC
 *
 * @autor Valentin Mozul
 * @version of 13.11.2021
 */

package ua.goit.console.commands;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.goit.console.Command;
import ua.goit.dao.CompaniesDao;
import ua.goit.model.Companies;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

public class CompaniesCommand implements Command {

    private static final Logger LOGGER = LogManager.getLogger(CompaniesCommand.class);

    private final CompaniesDao companiesDao = new CompaniesDao();

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
        List<Companies> all = companiesDao.getAll();
        System.out.println("Returned " + all.size() + " companies");
        for (Companies companies : all) {
            System.out.println(companies);
        }
    }

    private void update(String params) {
        String[] paramsArray = params.split(" ");
        Optional<Companies> optionalCompanies = companiesDao
                .get(Long.parseLong(paramsArray[0]));
        if (optionalCompanies.isPresent()) {
            Companies companies = optionalCompanies.get();
            companies.setName_(paramsArray[1]);
            companies.setCity(paramsArray[2]);
            companiesDao.update(companies);
        } else {
            System.out.println("Companies with id " + paramsArray[0] + " not found");
        }
    }

    private void create(String params) {
        String[] paramsArray = params.split(" ");
        Companies companies = new Companies();
        companies.setId(Long.parseLong(paramsArray[0]));
        companies.setName_(paramsArray[1]);
        companies.setCity(paramsArray[2]);
        companiesDao.create(companies);
    }

    private void get(String params) {
        String[] paramsArray = params.split(" ");
        Optional<Companies> companies = companiesDao
                .get(Long.parseLong(paramsArray[0]));
        if (companies.isPresent()) {
            System.out.println(companies.get());
        } else {
            System.out.println("Companies with id " + paramsArray[0] + " not found");
        }
    }

    private void delete(String params) {
        String[] paramsArray = params.split(" ");
        Optional<Companies> companies = companiesDao
                .get(Long.parseLong(paramsArray[0]));
        if (companies.isPresent()) {
            companiesDao.delete(companies.get());
        } else {
            System.out.println("Companies with id " + paramsArray[0] + " not found");
        }
    }

    @Override
    public void printActiveMenu() {
        LOGGER.info("---------------------Companies menu---------------------");
        LOGGER.info("Companies command list: ");
        LOGGER.info("create [name_] [city]");
        LOGGER.info("get [id]");
        LOGGER.info("getAll");
        LOGGER.info(" update [name_] [city]");
        LOGGER.info("delete [id]");
    }
}
