package ua.nure.itkn.miroshnyk.usermanagement.ua.nure.itkn.miroshnyk.usermanagement;

import java.io.Serializable;
import java.rmi.registry.LocateRegistry;
import java.time.LocalDate;;

public class User implements Serializable {
    private Long id;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;


    public User(Long id, String firstName, String lastName, LocalDate dateOfBirth) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
    }

    public User() {}

    public Long getId() {
        return id;
    }

    public void setId(long id) {
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

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    String testGetFullName() {
        return lastName + ", " + firstName;
    }

    long getAge() {
        LocalDate date = LocalDate.now();
        int age = date.getYear() - dateOfBirth.getYear();
        if (date.getMonthValue() < dateOfBirth.getMonthValue() ||
                (date.getMonthValue() == dateOfBirth.getMonthValue() && date.getDayOfMonth() < dateOfBirth.getDayOfMonth())) {
            --age;
        }

        return age;
    }
}
