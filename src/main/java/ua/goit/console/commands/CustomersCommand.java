/**
 * ProjectManagementSystem. Module 4. JDBC
 *
 * @autor Valentin Mozul
 * @version of 13.11.2021
 */

package ua.goit.console.commands;

import ua.goit.console.Command;
import ua.goit.dao.CustomersDao;
import ua.goit.model.Customers;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

public class CustomersCommand implements Command {

    private final CustomersDao customersDao = new CustomersDao();

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
        List<Customers> all = customersDao.getAll();
        System.out.println("Returned " + all.size() + " companies");
        for (Customers customers : all) {
            System.out.println(customers);
        }
    }

    // customers update ID NAME_ city
    private void update(String params) throws ParseException {
        String[] paramsArray = params.split(" ");
        Optional<Customers> optionalCustomers = customersDao
                .get(Long.parseLong(paramsArray[0]));
        if (optionalCustomers.isPresent()) {
            Customers customers = optionalCustomers.get();
            customers.setName_(paramsArray[1]);
            customers.setCity(paramsArray[2]);
            customersDao.update(customers);
        } else {
            System.out.println("Customers with id " + paramsArray[0] + " not found");
        }
    }

    // customers create ID NAME_ city
    private void create(String params) throws ParseException {
        String[] paramsArray = params.split(" ");
        Customers customers = new Customers();
        customers.setId(Long.parseLong(paramsArray[0]));
        customers.setName_(paramsArray[1]);
        customers.setCity(paramsArray[2]);
        customersDao.create(customers);
    }

    private void get(String params) { //customers get id
        String[] paramsArray = params.split(" ");
        Optional<Customers> customers = customersDao
                .get(Long.parseLong(paramsArray[0]));
        if (customers.isPresent()) {
            System.out.println(customers.get());
        } else {
            System.out.println("Customers with id " + paramsArray[0] + " not found");
        }
    }

    private void delete(String params) { //customers delete id
        String[] paramsArray = params.split(" ");
        Optional<Customers> customers = customersDao
                .get(Long.parseLong(paramsArray[0]));
        if (customers.isPresent()) {
            customersDao.delete(customers.get());
        } else {
            System.out.println("Customers with id " + paramsArray[0] + " not found");
        }
    }
}
