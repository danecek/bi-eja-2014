/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author danecek
 */
public class CustomerBB {

    private String name = "";
    private String age ="";
    private String validationError ="";

    public CustomerBB(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public CustomerBB() {
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
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
    public String getAge() {
        return age;
    }

    /**
     * @param age the age to set
     */
    public void setAge(String age) {
        this.age = age;
    }

    public Customer validate() {
        if (name == null || name.isEmpty()) {
            validationError = "Name is empty";
            return null;
        }
        int ag = 0;
        try {
            ag = Integer.parseInt(age);


        } catch (NumberFormatException ex) {
            validationError = "Agi illegal format";
            return null;
        }
        return new Customer(name, ag);
    }

    /**
     * @return the validationError
     */
    public String getValidationError() {
        return validationError;
    }

    /**
     * @param validationError the validationError to set
     */
    public void setValidationError(String validationError) {
        this.validationError = validationError;
    }
}
