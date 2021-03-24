package iuniversity.model.user;

import iuniversity.model.didactics.AcademicYear;

public class StudentImpl extends AbstractUser implements Student {

    private int registrationNumber;
    private StudentState state;
    private DegreeProgramme degreeProgramme;
    private AcademicYear immatriculationYear;
    
    public StudentImpl(int registrationNumber, StudentState state, DegreeProgramme degreeProgramme,
            AcademicYear immatriculationYear) {
        super();
        this.registrationNumber = registrationNumber;
        this.state = state;
        this.degreeProgramme = degreeProgramme;
        this.immatriculationYear = immatriculationYear;
    }

    @Override
    public int getRegistrationNumber() {
        return this.registrationNumber;
    }
    
    @Override
    public StudentState getState() {
        return this.state;
    }

    @Override
    public DegreeProgramme getDegreeProgramme() {
        return this.degreeProgramme;
    }
    
    @Override
    public AcademicYear getImmatriculationYear() {
        return this.immatriculationYear;
    }

    @Override
    public DidacticPlan getDidacticPlan() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void suspendCareer() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void resumeCareer() {
        // TODO Auto-generated method stub
        
    }

}
