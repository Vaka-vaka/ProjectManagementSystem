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
import ua.goit.dao.DevelopersDao;
import ua.goit.model.Developers;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

public class DevelopersCommand implements Command{

    private static final Logger LOGGER = LogManager.getLogger(DevelopersCommand.class);

    private static final DevelopersDao developersDao = DevelopersDao.getInstance();

    SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");

    @Override
    public void handle(String params, Consumer<Command> setActive) {
        String[] paramsArray = params.split(" ");
        String subParams = String.join(" ", params.replace(paramsArray[0]+ " ", ""));
        switch (paramsArray[0]) {
            case "create": create(subParams);break;
            case "get": get(subParams);break;
            case "getAll": getAll();break;
            case "delete": delete(subParams);break;
            case "update": update(subParams);break;
        }
    }

    private void getAll() {
        List<Developers> all = developersDao.getAll();
        System.out.println("Returned "+ all.size() + "developers");
        for (Developers developers : all) {
            System.out.println(developers);
        }
    }

    private void update(String params) { // developers update ID NAME AGE GENDER SALARY
        String[] paramsArray = params.split(" ");
        Optional<Developers> optionalDevelopers = developersDao
                .get(Long.parseLong(paramsArray[0]));
        if (optionalDevelopers.isPresent()) {
            Developers developers = optionalDevelopers.get();
            developers.setName(paramsArray[1]);
            developers.setAge(Long.parseLong(paramsArray[2]));
            developers.setGender(paramsArray[3]);
            developers.setSalary(Integer.parseInt(paramsArray[4]));
            developersDao.update(developers);
        } else {
            System.out.println("Developers with id "  + paramsArray[0] + " not found");
        }
    }

    private void create(String params) { // developers create NAME AGE GENDER SALARY
        String[] paramsArray = params.split(" ");
        Developers developers = new Developers();
        developers.setName(paramsArray[0]);
        developers.setAge(Long.parseLong(paramsArray[1]));
        developers.setGender(paramsArray[2]);
        developers.setSalary(Integer.parseInt(paramsArray[3]));
        developersDao.create(developers);
    }

    private void get(String params) { // developers get 1
        String[] paramsArray = params.split(" ");
        Optional<Developers> developers = developersDao
                .get(Long.parseLong(paramsArray[0]));
        if (developers.isPresent()) {
            System.out.println(developers.get());
        } else {
            System.out.println("Developers with id "  + paramsArray[0] + " not found");
        }
    }

    private void delete(String params) { // developers ID
        String[] paramsArray = params.split(" ");
        Optional<Developers> developers = developersDao
                .get(Long.parseLong(paramsArray[0]));
        if (developers.isPresent()) {
            developersDao.delete(developers.get());
        } else {
            System.out.println("Developers with id "  + paramsArray[0] + " not found");
        }
    }

    @Override
    public void printActiveMenu() {
        LOGGER.info("-------Developers menu-----------");
        LOGGER.info("Developers command list:");
//        LOGGER.info("create [last_name] [first_name] [surname] [age] [birth(format dd-MM-yyyy)] [gender] [company_id] [salary]");
//        LOGGER.info("get [id]");
//        LOGGER.info("getAll");
//        LOGGER.info("update [last_name] [first_name] [surname] [age] [birth(format dd-MM-yyyy)] [gender] [company_id] [salary]");
//        LOGGER.info("delete [id]");
    }
}
