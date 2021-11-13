/**
 * ProjectManagementSystem. Module 4. JDBC
 *
 * @autor Valentin Mozul
 * @version of 13.11.2021
 */

package ua.goit.console.commands;

import ua.goit.console.Command;
import ua.goit.dao.SkillsDao;
import ua.goit.model.Skills;

import java.util.*;

public class SkillsCommand implements Command {

    private final SkillsDao skillsDao = new SkillsDao();

    @Override
    public void handle(String params) {
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
        List<Skills> all = skillsDao.getAll();
        System.out.println("Returned " + all.size() + " skills");
        for (Skills skills : all) {
            System.out.println(skills);
        }
    }

    private void update(String params) { // skills update ID NAME AGE GENDER SALARY
        String[] paramsArray = params.split(" ");
        Optional<Skills> optionalSkills = skillsDao
                .get(Long.parseLong(paramsArray[0]));
        if (optionalSkills.isPresent()) {
            Skills skills = optionalSkills.get();
            skills.setLanguage(paramsArray[1]);
            skills.setLevel_skills(paramsArray[2]);
            skillsDao.update(skills);
        } else {
            System.out.println("Skills with id " + paramsArray[0] + " not found");
        }
    }

    private void create(String params) { //skills create ID Language Level_skills
        String[] paramsArray = params.split(" ");
        Skills skills = new Skills();
        skills.setId(Long.parseLong(paramsArray[0]));
        skills.setLanguage(paramsArray[1]);
        skills.setLevel_skills(paramsArray[2]);
        skillsDao.create(skills);
    }

    private void get(String params) { //skills get id
        String[] paramsArray = params.split(" ");
        Optional<Skills> skills = skillsDao
                .get(Long.parseLong(paramsArray[0]));
        if (skills.isPresent()) {
            System.out.println(skills.get());
        } else {
            System.out.println("Skills with id " + paramsArray[0] + " not found");
        }
    }

    private void delete(String params) { //skills delete id
        String[] paramsArray = params.split(" ");
        Optional<Skills> skills = skillsDao
                .get(Long.parseLong(paramsArray[0]));
        if (skills.isPresent()) {
            skillsDao.delete(skills.get());
        } else {
            System.out.println("Skills with id " + paramsArray[0] + " not found");
        }
    }
}
