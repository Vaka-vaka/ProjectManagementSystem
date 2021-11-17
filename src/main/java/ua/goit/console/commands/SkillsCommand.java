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
import ua.goit.dao.SkillsDao;
import ua.goit.model.Skills;

import java.util.*;
import java.util.function.Consumer;

public class SkillsCommand implements Command {

    private static final Logger LOGGER = LogManager.getLogger(SkillsCommand.class);

    private final SkillsDao skillsDao = new SkillsDao();

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
        List<Skills> all = skillsDao.getAll();
        System.out.println("Returned " + all.size() + " skills");
        for (Skills skills : all) {
            System.out.println(skills);
        }
    }

    private void update(String params) {
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

    private void create(String params) {
        String[] paramsArray = params.split(" ");
        Skills skills = new Skills();
        skills.setId(Long.parseLong(paramsArray[0]));
        skills.setLanguage(paramsArray[1]);
        skills.setLevel_skills(paramsArray[2]);
        skillsDao.create(skills);
    }

    private void get(String params) {
        String[] paramsArray = params.split(" ");
        Optional<Skills> skills = skillsDao
                .get(Long.parseLong(paramsArray[0]));
        if (skills.isPresent()) {
            System.out.println(skills.get());
        } else {
            System.out.println("Skills with id " + paramsArray[0] + " not found");
        }
    }

    private void delete(String params) {
        String[] paramsArray = params.split(" ");
        Optional<Skills> skills = skillsDao
                .get(Long.parseLong(paramsArray[0]));
        if (skills.isPresent()) {
            skillsDao.delete(skills.get());
        } else {
            System.out.println("Skills with id " + paramsArray[0] + " not found");
        }
    }

    @Override
    public void printActiveMenu() {
        LOGGER.info("---------------------Skills menu---------------------");
        LOGGER.info("Skills command list:");
        LOGGER.info("create [id] [language] [level_skills]");
        LOGGER.info("get [id]");
        LOGGER.info("getAll");
        LOGGER.info("update [id] [language] [level_skills]");
        LOGGER.info("delete [id]");
    }
}
