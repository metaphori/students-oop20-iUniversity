package iuniversity.model;

import java.time.LocalDate;

public interface AcademicYear {

    LocalDate getStart();
    
    LocalDate getEnd();
    
    LocalDate getFirstTermStart();
    
    LocalDate getFirstTermEnd();
    
    LocalDate getSecondTermStart();
    
    LocalDate getSecondTermEnd();
    
}
