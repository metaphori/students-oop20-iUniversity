package iuniversity.model.user;


import java.io.Serializable;
import java.time.LocalDate;
import iuniversity.model.didactics.*;
import iuniversity.model.user.User.Gender;

public class StudentImpl extends AbstractUser implements Student, Serializable {

    /**
     * 
     */
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

}
