package iuniversity.model.didactics;

public interface DegreeProgramme {

    String getName();
    
    DegreeType getType();
    
    DidacticPlan getDidacticPlan();
    
    public enum DegreeType {
        BACHELOR, MASTER
    }
    
}
