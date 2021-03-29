package iuniversity.model.exams;

import java.util.stream.Collectors;
import java.util.stream.Stream;


public class StudentRegistrationStrategyFactoryImpl implements StudentRegistrationStrategyFactory {

    /**
     * {@inheritDoc}
     */
    @Override
    public StudentRegistrationStrategy atTheEndOfList() {
        return (list, student) -> list.add(student);
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public StudentRegistrationStrategy atTheTopOfList() {
        return (list, student) -> list.add(0, student);
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public StudentRegistrationStrategy alfabeticalOrder() {
        return (list, student) -> Stream.concat(Stream.of(student), list.stream())
                .sorted((a, b) -> a.getLastName().compareToIgnoreCase(b.getLastName()))
                .collect(Collectors.toList());
    }

}
