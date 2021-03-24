package iuniversity.model.didactics;
import iuniversity.model.user.Student;
import iuniversity.model.user.Student.StudentState;
import iuniversity.model.user.User.Gender;

import static iuniversity.model.didactics.AdmissionRequest.RequestStatus;

import java.time.LocalDate;

public class AdmissionRequestImpl implements AdmissionRequest {

    private String name;
    private String lastName;
    private String username;
    private LocalDate dateOfBirth;
    private Gender gender;
    private String address;
    private int id;
    private int registrationNumber;
    private StudentState state;
    private DegreeProgramme degreeProgramme;
    private AcademicYear immatriculationYear;
    private RequestStatus status;

    public AdmissionRequestImpl(String name, String lastName, LocalDate dateOfBirth, Gender gender, String address,
            iuniversity.model.didactics.DegreeProgramme degreeProgramme) {
        this.name = name;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.address = address;
        this.degreeProgramme = degreeProgramme;
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

    @Override
    public LocalDate getDateOfBirth() {
        return this.dateOfBirth;
    }

    @Override
    public Gender getGender() {
        return this.gender;
    }

    @Override
    public String getAddress() {
        return this.address;
    }

    @Override
    public int getId() {
        return this.id++;
    }

    @Override
    public int getRegistrationNumber() {
        return this.registrationNumber++;
    }

    @Override
    public StudentState getState() {
        this.state = StudentState.ACTIVE;
        return this.state;
    }

    @Override
    public iuniversity.model.didactics.DegreeProgramme getDegreeProgramme() {
        return this.degreeProgramme;
    }

    @Override
    public AcademicYear getAcademicYear() {
        this.immatriculationYear = 
        return this.immatriculationYear;
    }

    @Override
    public RequestStatus getStatus() {
        return this.status;
    }
     
    @Override
    public Student accept() {
        this.status = RequestStatus.ACCEPTED;
        return Student;
    }

    @Override
    public void decline() {
        this.status = RequestStatus.DECLINED;
    }
    
}
