package iuniversity.view.users;

import java.util.List;

import iuniversity.model.didactics.DegreeProgramme;
import iuniversity.model.user.User.Gender;

public interface StudentCreationView {
    
    void createStudent();
    
    void showStudentCredentials(String username, String password);
    
    void setGenderChoices(List<Gender> genders);
    
    void setDegreeProgrammChoices(List<DegreeProgramme> degreeProgrammes);

}
