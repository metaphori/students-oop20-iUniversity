package iuniversity.model.didactics;

public class CourseImpl implements Course {

    private int id;
    private String name;
    private int CFU;
    private int totalHours;
    
    public CourseImpl(int id, String name, int cFU, int totalHours) {
        super();
        this.id = id;
        this.name = name;
        CFU = cFU;
        this.totalHours = totalHours;
    }

    @Override
    public int getId() {
        return this.id;    
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getCFU() {
        return this.CFU;
    }

    @Override
    public int getTotalHours() {
        return this.totalHours;
    }
}
