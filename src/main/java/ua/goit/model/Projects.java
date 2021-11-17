/**
 * ProjectManagementSystem. Module 4. JDBC
 *
 * @autor Valentin Mozul
 * @version of 13.11.2021
 */

package ua.goit.model;

import ua.goit.dao.to_interface.Identity;
import java.util.*;

public class Projects implements Identity {

    private Long Id;
    private String Name_;
    private String Language;
    private int Cost;
    private Date Creation_date;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName_() {
        return Name_;
    }

    public void setName_(String name_) {
        Name_ = name_;
    }

    public String getLanguage() {
        return Language;
    }

    public void setLanguage(String language) {
        Language = language;
    }

    public int getCost() {
        return Cost;
    }

    public void setCost(int cost) {
        Cost = cost;
    }

    public Date getCreation_date() {
        return Creation_date;
    }

    public void setCreation_date(Date creation_date) {
        Creation_date = creation_date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Projects projects = (Projects) o;
        return Cost == projects.Cost && Objects.equals(Id, projects.Id) && Objects.equals(Name_, projects.Name_) && Objects.equals(Language, projects.Language) && Objects.equals(Creation_date, projects.Creation_date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, Name_, Language, Cost, Creation_date);
    }

    @Override
    public String toString() {
        return "Projects{" +
                "Id=" + Id +
                ", Name_='" + Name_ + '\'' +
                ", Language='" + Language + '\'' +
                ", Cost=" + Cost +
                ", Creation_date=" + Creation_date +
                '}';
    }
}
