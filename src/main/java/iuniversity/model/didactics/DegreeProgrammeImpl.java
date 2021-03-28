package iuniversity.model.didactics;

public class DegreeProgrammeImpl implements DegreeProgramme {

    private String name;
    private DegreeType type;
    
    public DegreeProgrammeImpl(String name, DegreeType type) {
        this.name = name;
        this.type = type;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public DegreeType getType() {
        return this.type;
    }
    
}
