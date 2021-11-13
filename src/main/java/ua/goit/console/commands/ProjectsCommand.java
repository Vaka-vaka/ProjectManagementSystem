/**
 * ProjectManagementSystem. Module 4. JDBC
 *
 * @autor Valentin Mozul
 * @version of 13.11.2021
 */

package ua.goit.console.commands;

import ua.goit.console.Command;
import ua.goit.dao.ProjectsDao;
import ua.goit.model.Projects;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class ProjectsCommand implements Command {

    private final ProjectsDao projectsDao = new ProjectsDao();
    SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");

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
        List<Projects> all = projectsDao.getAll();
        System.out.println("Returned " + all.size() + " projects");
        for (Projects projects : all) {
            System.out.println(projects);
        }
    }

    // projects update ID NAME_ language cost creation_date
    private void update(String params) throws ParseException {
        String[] paramsArray = params.split(" ");
        Optional<Projects> optionalProjects = projectsDao
                .get(Long.parseLong(paramsArray[0]));
        if (optionalProjects.isPresent()) {
            Projects projects = optionalProjects.get();
            projects.setName_(paramsArray[1]);
            projects.setLanguage(paramsArray[2]);
            projects.setCost(Integer.parseInt(paramsArray[3]));
            projects.setCreation_date(new Date(format.parse(paramsArray[4]).getTime()));
            projectsDao.update(projects);
        } else {
            System.out.println("Projects with id " + paramsArray[0] + " not found");
        }
    }

    // projects create ID NAME_ language cost creation_date
    private void create(String params) throws ParseException {
        String[] paramsArray = params.split(" ");
        Projects projects = new Projects();
        projects.setId(Long.parseLong(paramsArray[0]));
        projects.setName_(paramsArray[1]);
        projects.setLanguage(paramsArray[2]);
        projects.setCost(Integer.parseInt(paramsArray[3]));
        projects.setCreation_date(new Date(format.parse(paramsArray[4]).getTime()));
        projectsDao.create(projects);
    }

    private void get(String params) { //projects get id
        String[] paramsArray = params.split(" ");
        Optional<Projects> projects = projectsDao
                .get(Long.parseLong(paramsArray[0]));
        if (projects.isPresent()) {
            System.out.println(projects.get());
        } else {
            System.out.println("Projects with id " + paramsArray[0] + " not found");
        }
    }

    private void delete(String params) { //projects delete id
        String[] paramsArray = params.split(" ");
        Optional<Projects> projects = projectsDao
                .get(Long.parseLong(paramsArray[0]));
        if (projects.isPresent()) {
            projectsDao.delete(projects.get());
        } else {
            System.out.println("Projects with id " + paramsArray[0] + " not found");
        }
    }
}