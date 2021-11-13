/**
 * ProjectManagementSystem. Module 4. JDBC
 *
 * @autor Valentin Mozul
 * @version of 13.11.2021
 */

package ua.goit.console.commands;

import ua.goit.console.Command;
import ua.goit.dao.CompaniesDao;
import ua.goit.model.Companies;
import java.text.ParseException;
import java.util.List;
import java.util.Optional;

public class CompaniesCommand implements Command {

    private final CompaniesDao companiesDao = new CompaniesDao();

    @Override
    public void handle(String params) throws ParseException {
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

    // companies update ID NAME_ city
    private void update(String params) throws ParseException {
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

    // companies create ID NAME_ city
    private void create(String params) throws ParseException {
        String[] paramsArray = params.split(" ");
        Companies companies = new Companies();
        companies.setId(Long.parseLong(paramsArray[0]));
        companies.setName_(paramsArray[1]);
        companies.setCity(paramsArray[2]);
        companiesDao.create(companies);
    }

    private void get(String params) { //companies get id
        String[] paramsArray = params.split(" ");
        Optional<Companies> companies = companiesDao
                .get(Long.parseLong(paramsArray[0]));
        if (companies.isPresent()) {
            System.out.println(companies.get());
        } else {
            System.out.println("Companies with id " + paramsArray[0] + " not found");
        }
    }

    private void delete(String params) { //companies delete id
        String[] paramsArray = params.split(" ");
        Optional<Companies> companies = companiesDao
                .get(Long.parseLong(paramsArray[0]));
        if (companies.isPresent()) {
            companiesDao.delete(companies.get());
        } else {
            System.out.println("Companies with id " + paramsArray[0] + " not found");
        }
    }
}
