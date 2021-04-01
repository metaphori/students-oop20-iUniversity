package iuniversity.controller;

import java.time.LocalDate;

import iuniversity.model.didactics.DegreeProgramme;
import iuniversity.model.user.User.Gender;

public interface StudentCreationController {

    void createStudent(String firstName, String lastName, LocalDate dateOfBirth, Gender gender, String address,
            DegreeProgramme degreeProgramme);
    
    void initializeChoices();
}
