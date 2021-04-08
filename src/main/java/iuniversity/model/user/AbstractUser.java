package iuniversity.model.user;

import java.io.Serializable;
import java.time.LocalDate;

public abstract class AbstractUser implements User, Serializable {

    /**
     * Is the abstract user class, it is subsequently extended to student, professor and admin
     */
    private String name;
    private String lastName;
    private String username;
    private LocalDate dateOfBirth;
    private Gender gender;
    private String address;
    private int id;
    
    public AbstractUser() {
    }
    
    public AbstractUser(String name, String lastName, String username, LocalDate dateOfBirth, Gender gender,
            String address, int id) {
        this.name = name;
        this.lastName = lastName;
        this.username = username;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.address = address;
        this.id = id;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getLastName() {
        return this.lastName;
    }

    @Override
    public String getUsername() {
        return this.username;
    }
    
    public LocalDate getDateOfBirth() {
        return this.dateOfBirth;
    }

    public Gender getGender() {
        return this.gender;
    }

    public String getAddress() {
        return this.address;
    }

    public int getId() {
        return this.id;
    }

    @Override
    public String toString() {
        return name + " " + lastName;
    }
}
