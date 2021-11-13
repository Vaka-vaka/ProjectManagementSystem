/**
 * ProjectManagementSystem. Module 4. JDBC
 *
 * @autor Valentin Mozul
 * @version of 13.11.2021
 */

package ua.goit.model;

import ua.goit.dao.Identity;
import java.util.*;

public class Skills implements Identity {

    private Long id;
    private String language;
    private String level_skills;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getLevel_skills() {
        return level_skills;
    }

    public void setLevel_skills(String level_skills) {
        this.level_skills = level_skills;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Skills skills = (Skills) o;
        return Objects.equals(id, skills.id)
                && Objects.equals(language, skills.language)
                && Objects.equals(level_skills, skills.level_skills);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, language, level_skills);
    }

    @Override
    public String toString() {
        return "Skills{" +
                "id=" + id +
                ", language='" + language + '\'' +
                ", level_skills='" + level_skills + '\'' +
                '}';
    }
}
