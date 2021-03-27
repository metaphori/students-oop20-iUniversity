package iuniversity.model.exams;

public interface StudentRegistrationStrategyFactory {

    StudentRegistrationStrategy atTheEndOfList();

    StudentRegistrationStrategy atTheTopOfList();

    StudentRegistrationStrategy alfabeticalOrder();

}
