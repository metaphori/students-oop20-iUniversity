package iuniversity.model.didactics;

public class DegreeProgrammeImpl implements DegreeProgramme {

    private String name;
    private DegreeType type;
    private DidacticPlan didacticPlan;
    
    public DegreeProgrammeImpl(String name, DegreeType type, DidacticPlan didacticPlan) {
        this.name = name;
        this.type = type;
        this.didacticPlan = didacticPlan;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public DegreeType getType() {
        return this.type;
    }

    @Override
    public DidacticPlan getDidacticPlan() {
        return this.didacticPlan;
    }
    
}
