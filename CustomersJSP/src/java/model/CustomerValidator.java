/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author danecek
 */
public class CustomerValidator {

    private String name = "";
    private String age = "";
    private String validationError = "";

    public CustomerValidator() {
    }

    public CustomerValidator(String name, String age) {
        this.name = name;
        this.age = age;
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

    public Customer validate() {
        if (name.isEmpty()) {
            validationError = "Name is empty";
            return null;
        }
        int a = 0;
        try {
            a = Integer.parseInt(age);
        } catch (NumberFormatException e) {
            validationError = "Invalid age";
            return null;
        }
        return new Customer(name, a);
    }
}
