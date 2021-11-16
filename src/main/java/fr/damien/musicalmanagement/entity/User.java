package fr.damien.musicalmanagement.entity;

import java.util.Date;

public class User {

    private int id;
    private String firstname;
    private String lastname;
    private Date birthDay;
    private String email;
    private String phone;
    private String fax;
    private int role_id;
    private int civility_id;
    private int responsibility_id;

    public User() {
    }

    public User( String firstname, String lastname, Date birthDay, String email, String phone, String fax) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthDay = birthDay;
        this.email = email;
        this.phone = phone;
        this.fax = fax;
    }

    public User(String firstname, String lastname, Date birthDay, String email, String phone, String fax, int role_id, int civility_id, int responsibility_id) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthDay = birthDay;
        this.email = email;
        this.phone = phone;
        this.fax = fax;
        this.role_id = role_id;
        this.civility_id = civility_id;
        this.responsibility_id = responsibility_id;
    }

    public User(int id, String firstname, String lastname, Date birthDay, String email, String phone, String fax, int role_id, int civility_id, int responsibility_id) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthDay = birthDay;
        this.email = email;
        this.phone = phone;
        this.fax = fax;
        this.role_id = role_id;
        this.civility_id = civility_id;
        this.responsibility_id = responsibility_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    public int getCivility_id() {
        return civility_id;
    }

    public void setCivility_id(int civility_id) {
        this.civility_id = civility_id;
    }

    public int getResponsibility_id() {
        return responsibility_id;
    }

    public void setResponsibility_id(int responsibility_id) {
        this.responsibility_id = responsibility_id;
    }

    @Override
    public String toString() {
        return "User{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }
}
