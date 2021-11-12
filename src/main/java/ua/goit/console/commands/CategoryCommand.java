/**
 * JavaDeveloper3. Module 4. JDBC
 *
 * @autor Valentin Mozul
 * @version of 09.11.2021
 */

package ua.goit.console.commands;

import ua.goit.console.Command;
import ua.goit.dao.CategoryDao;
import ua.goit.model.Category;

import java.util.List;
import java.util.Optional;

public class CategoryCommand implements Command {

    private final CategoryDao categoryDao = new CategoryDao();

    @Override
    public void handle(String params) {
        String[] paramsArray = params.split(" ");
        String subParams = String.join(" ", params.replace(paramsArray[0] + " ", ""));
        switch (paramsArray[0]) {
            case "create":
                create(subParams);break;
            case "get":
                get(subParams);break;
            case "getAll":
                getAll();break;
            case "delete":
                delete(subParams);break;
            case "update":
                update(subParams);break;
        }
    }

    private void update(String subParams) {
        String[] paramsArray = subParams.split(" ");
        Optional<Category> optionalCategory = categoryDao
                .get(Long.parseLong(paramsArray[0]));
        if (optionalCategory.isPresent()) {
            Category category = optionalCategory.get();
            category.setName(paramsArray[1]);
            category.setDescription(paramsArray[2]);
            category.setParentId(Long.parseLong(paramsArray[3]));
            categoryDao.update(category);
        } else {
            System.out.println("User with id " + paramsArray[0] + " not found");
        }
    }

    private void delete(String subParams) {
        String[] paramsArray = subParams.split(" ");
        Optional<Category> category = categoryDao
                .get(Long.parseLong(paramsArray[0]));
        if (category.isPresent()) {
            categoryDao.delete(category.get());
        } else {
            System.out.println("Category with id " + paramsArray[0] + " not found");
        }
    }

    private void getAll() {
        List<Category> all = categoryDao.getAll();
        System.out.println("Returned " + all.size() + " categories");
        for (Category category : all) {
            System.out.println(category);
        }
    }

    private void get(String subParams) {
        String[] paramsArray = subParams.split(" ");
        Optional<Category> category = categoryDao
                .get(Long.parseLong(paramsArray[0]));
        if (category.isPresent()) {
            System.out.println(category.get());
        } else {
            System.out.println("Category with id " + paramsArray[0] + " not found");
        }
    }

    private void create(String subParams) {  //category create NAME DISC [PARENT_ID]
        String[] paramsArray = subParams.split(" ");
        Category category = new Category();
        category.setName(paramsArray[0]);
        category.setDescription(paramsArray[1]);
        if(paramsArray.length > 2) {
            category.setParentId(Long.parseLong(paramsArray[2]));
        }
        categoryDao.create(category);
    }
}
