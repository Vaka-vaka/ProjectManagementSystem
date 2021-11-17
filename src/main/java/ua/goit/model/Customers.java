/**
 * ProjectManagementSystem. Module 4. JDBC
 *
 * @autor Valentin Mozul
 * @version of 13.11.2021
 */

package ua.goit.model;

import ua.goit.dao.to_interface.Identity;

import java.util.Objects;

public class Customers implements Identity {

    private Long id;
    private String name_;
    private String city;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName_() {
        return name_;
    }

    public void setName_(String name_) {
        this.name_ = name_;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customers customers = (Customers) o;
        return Objects.equals(id, customers.id) &&
                Objects.equals(name_, customers.name_) &&
                Objects.equals(city, customers.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name_, city);
    }

    @Override
    public String toString() {
        return "Customers{" +
                "id=" + id +
                ", name_='" + name_ + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
