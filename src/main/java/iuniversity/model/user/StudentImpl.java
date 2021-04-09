package iuniversity.model.user;


import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import iuniversity.model.didactics.*;
import iuniversity.model.user.TeacherImpl.Builder;
import iuniversity.model.user.User.Gender;

public class StudentImpl extends AbstractUser implements Student, Serializable {

    private static final long serialVersionUID = 1L;
    private int registrationNumber;
    private DegreeProgramme degreeProgramme;
    
    public StudentImpl(String name, String lastName, String username, LocalDate dateOfBirth, Gender gender,
            String address, int id, int registrationNumber, DegreeProgramme degreeProgramme) {
        super(name, lastName, username, dateOfBirth, gender, address, id);
        this.registrationNumber = registrationNumber;
        this.degreeProgramme = degreeProgramme;
    }

    @Override
    public int getRegistrationNumber() {
        return this.registrationNumber;
    }

    @Override
    public DegreeProgramme getDegreeProgramme() {
        return this.degreeProgramme;
    }

    @Override
    public String toString() {
        return  "[" + registrationNumber + "] " + super.toString();
    }
    
    public static class Builder{
            
            private String name;
            private String lastName;
            private String username;
            private LocalDate dateOfBirth;
            private Gender gender;
            private String address;
            private int id;
            private int registrationNumber;
            private DegreeProgramme degreeProgramme;
            
            public Builder(String name, String lastName, int id, int registrationNumber) { 
                this.name = name;
                this.lastName = lastName;
                this.id = id;
                this.registrationNumber = registrationNumber;
            }
            
            public Builder username(String username) {
                this.username=username;
                return this;
            }
            
            public Builder dateOfBirth(LocalDate dateOfBirth) {
                this.dateOfBirth = dateOfBirth;
                return this;
            }
            
            public Builder gender(Gender gender) {
                this.gender=gender;
                return this;
            }
            
            public Builder address(String address) {
                this.address=address;
                return this;
            }
     
            public Builder degreeProgramme(DegreeProgramme degreeProgramme) {
                this.degreeProgramme=degreeProgramme;
                return this;
            }
            
            public StudentImpl build() throws IllegalStateException{
                if (this.name == null || this.lastName == null || this.username == null || this.dateOfBirth == null || this.gender == null ||
                        this.address == null || this.degreeProgramme == null ) {
                    throw new IllegalStateException("");
                }
                return new StudentImpl(this.name,this.lastName,this.username,this.dateOfBirth,this.gender,this.address,this.id,this.registrationNumber,this.degreeProgramme);
            }
        }
}
