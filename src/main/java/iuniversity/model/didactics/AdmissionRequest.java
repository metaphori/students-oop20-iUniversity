package iuniversity.model.didactics;

import java.time.LocalDate;

import iuniversity.model.didactics.AdmissionRequest.RequestStatus;
import iuniversity.model.user.Student;
import iuniversity.model.user.Student.StudentState;
import iuniversity.model.user.User.Gender;

public interface AdmissionRequest {

    String getName();
    
    String getLastName();
    
    String getUsername();
    
    LocalDate getDateOfBirth();
    
    Gender getGender();
    
    String getAddress();
    
    int getId();
    
    int getRegistrationNumber();
    
    StudentState getState();
    
    DegreeProgramme getDegreeProgramme();
    
    AcademicYear getAcademicYear();
    
    RequestStatus getStatus();
    
    Student accept();
    
    void decline();
    
    public enum RequestStatus {
        SUBMITTED, ACCEPTED, DECLINED
    }
    
}
