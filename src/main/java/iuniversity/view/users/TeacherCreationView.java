package iuniversity.view.users;

import java.util.Set;

import iuniversity.model.didactics.Course;
import iuniversity.model.user.User.Gender;

public interface TeacherCreationView {
    
    void createTeacher();
    
    void showTeacherCredentials(String username, String password);
    
    void setGenderChoices(Set<Gender> genders);
    
    void setCourseChoices(Set<Course> course);
    

}
