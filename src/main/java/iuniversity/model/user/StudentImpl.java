package iuniversity.model.user;


import java.time.LocalDate;
import iuniversity.model.didactics.*;
import iuniversity.model.user.User.Gender;

public class StudentImpl extends AbstractUser implements Student {

    private String name;
    private String lastName;
    private String username;
    private LocalDate dateOfBirth;
    private Gender gender;
    private String address;
    private int id;
    private int registrationNumber;
    private DegreeProgramme degreeProgramme;
    private AcademicYear immatriculationYear;
    
    public StudentImpl(String name, String lastName, String username, LocalDate dateOfBirth, Gender gender,
            String address, int id, int registrationNumber, DegreeProgramme degreeProgramme,
            AcademicYear immatriculationYear) {
        super();
        this.name = name;
        this.lastName = lastName;
        this.username = username;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.address = address;
        this.id = id;
        this.registrationNumber = registrationNumber;
        this.degreeProgramme = degreeProgramme;
        this.immatriculationYear = immatriculationYear;
    }

    public StudentImpl(int registrationNumber, DegreeProgramme degreeProgramme,
            AcademicYear immatriculationYear) {
        this.registrationNumber = registrationNumber;
        this.degreeProgramme = degreeProgramme;
        this.immatriculationYear = immatriculationYear;
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
    public AcademicYear getImmatriculationYear() {
        return this.immatriculationYear;
    }

}
