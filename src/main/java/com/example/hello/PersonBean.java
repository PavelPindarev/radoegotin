package com.example.hello;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.inject.Named;
import java.io.Serializable;

@Named("personBean")
@SessionScoped
public class PersonBean implements Serializable {
    private String firstName;
    private String lastName;
    private String email;
    private int age;
    private String country;
    private String programmingLanguage;

    public PersonBean() {
    }

    public String welcome() {
        return "welcome.xhtml";
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getProgrammingLanguage() {
        return programmingLanguage;
    }

    public void setProgrammingLanguage(String programmingLanguage) {
        this.programmingLanguage = programmingLanguage;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void validateFirstName(FacesContext facesContext, UIComponent uiComponent, Object o) throws ValidatorException {

        if (o == null || o.toString().trim().isEmpty()) {
            FacesMessage message = new FacesMessage("First Name is required");
            throw new ValidatorException(message);

        }
        if (!o.toString().startsWith("LUV")) {
            FacesMessage message = new FacesMessage("First Name must start with 'LUV'");
            throw new ValidatorException(message);
        }

    }
}
