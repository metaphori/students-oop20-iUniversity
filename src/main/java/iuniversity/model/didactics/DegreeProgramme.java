package iuniversity.model.didactics;

public interface DegreeProgramme {

    String getName();
    
    DegreeType getType();
    
    public enum DegreeType {
        BACHELOR, MASTER
    }
    
}
