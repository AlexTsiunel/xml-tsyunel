package com.company.xml;

import javax.xml.bind.annotation.*;

@XmlType(propOrder = {"firstName", "lastName", "email", "phoneNumber", "password", "tag", "userRoledId" })
@XmlRootElement( name = "employee" )
public class Employee {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String password;
    private String tag;
    private Byte userRoledId;

    public Employee(Long id, String firstName, String lastName, String email, String phoneNumber, String password,
            String tag, Byte userRoledId) {
        super();
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.tag = tag;
        this.userRoledId = userRoledId;
    }

    public Employee() {
    }
    @XmlAttribute
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public Byte getUserRoledId() {
        return userRoledId;
    }

    public void setUserRoledId(Byte userRoledId) {
        this.userRoledId = userRoledId;
    }

    @Override
    public String toString() {
        return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
                + ", phoneNumber=" + phoneNumber + ", password=" + password + ", tag=" + tag + ", userRoledId="
                + userRoledId + "]";
    }

}
