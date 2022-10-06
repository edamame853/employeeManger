package tech.getarrays.employeeManger.model;

// The reason why we're implementing serializable is due to...
// Helps transforming this java class into different types of stream
// Since this class will be passed to: different databases, different front end (as json)...
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
// This class will contain the basic info of an Employee
public class Employee implements Serializable {
    @Id // For mapping use, this is the primary key of the database
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Will tell us how to generate the  ID
    // GenerationType. xxx <-- Anything would work here, since we're not concerned about database performence here
    
    
    @Column (nullable = false, updatable = false) // Allows you to specify column information
    private Long id;
    private String name;
    private String jobTitle;
    private Long salary;
    private String email;
    private String phoneNumber;
    private String imageUrl; // Best way of showcasing your image to users (pointing the right domain/ link)
    
    @Column (nullable = false, updatable = false) // Making employeeNumber same as id, it'll be UNABLE to be modified
    private String employeeNumber;

 // What we need now is: Mapping this class to the database: so we can modify it on the database
/*
 The method of doing so: @Entity of any database we have setup
 */

    public Employee() {}


    // This will be our constructor
    public Employee (String name, String jobTitle, Long salary, String email, String phoneNumber, String imageUrl, String employeeNumber){
        this.name = name;
        this.jobTitle = jobTitle;
        this.salary = salary;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.imageUrl = imageUrl;
        this.employeeNumber = employeeNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    // public String getPhone() {
    //     return phone;
    // }

    // public void setPhone(String phone) {
    //     this.phone = phone;
    // }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(String employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", jobTitle='" + jobTitle + '\'' +
                // ", phone='" + phone + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}