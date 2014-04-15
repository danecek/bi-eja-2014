/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "CUSTOMERS")
@XmlRootElement
public class Customer {

    @Id
    @GeneratedValue
    private Long id;

    public Customer(Long id) {
        this.id = id;
    }
    private String name;
    private int age;
    @ManyToOne
    private CustomerGroup group;

    public Customer() {
    }

    public Customer(String name, int age, CustomerGroup group) {
        this.name = name;
        this.age = age;
        this.group = group;
    }


    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the age
     */
    public int getAge() {
        return age;
    }

    /**
     * @param age the age to set
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * @return the group
     */
    public CustomerGroup getGroup() {
        return group;
    }

    /**
     * @param group the group to set
     */
    public void setGroup(CustomerGroup group) {
        this.group = group;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }
}
