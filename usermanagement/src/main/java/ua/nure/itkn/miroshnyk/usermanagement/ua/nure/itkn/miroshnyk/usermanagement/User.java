package ua.nure.itkn.miroshnyk.usermanagement.ua.nure.itkn.miroshnyk.usermanagement;

import java.io.Serializable;
import java.rmi.registry.LocateRegistry;
import java.time.LocalDate;;

public class User implements Serializable {
    private long id;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;

    public User(long id, String firstName, String lastName, LocalDate dateOfBirth) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
    }

    public int getAge() {
        LocalDate date = LocalDate.of(2018, 11, 12);
        int age = date.getYear() - dateOfBirth.getYear();
        if (date.getMonthValue() < dateOfBirth.getMonthValue() || (date.getMonthValue() == dateOfBirth.getMonthValue()
                && date.getDayOfMonth() < dateOfBirth.getDayOfMonth())) {
            --age;
        }
        return age;
    }

    public String testGetFullName(){
        return getFirstName() + ", " + getLastName();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getLastName() {

        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {

        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}
