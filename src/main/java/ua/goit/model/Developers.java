/**
 * ProjectManagementSystem. Module 4. JDBC
 *
 * @autor Valentin Mozul
 * @version of 12.11.2021
 */

package ua.goit.model;

import ua.goit.dao.Identity;

import java.util.*;

public class Developers implements Identity {

    private long id;
    private String name_;
    private long Age;
    private String Gender;
    private int Salary;

    @Override
    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName_() {
        return name_;
    }

    public void setName_(String name_) {
        this.name_ = name_;
    }

    public long getAge() {
        return Age;
    }

    public void setAge(long age) {
        Age = age;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public int getSalary() {
        return Salary;
    }

    public void setSalary(int salary) {
        Salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Developers that = (Developers) o;
        return id == that.id && Age == that.Age && Salary == that.Salary && Objects.equals(name_, that.name_) && Objects.equals(Gender, that.Gender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name_, Age, Gender, Salary);
    }

    @Override
    public String toString() {
        return "Developers{" +
                "id=" + id +
                ", name_='" + name_ + '\'' +
                ", Age=" + Age +
                ", Gender='" + Gender + '\'' +
                ", Salary=" + Salary +
                '}';
    }
}
