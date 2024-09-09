package tourism.model;

public class TouristAttraction {
    private String name;
    private String descriptition;

    public TouristAttraction(String name, String descriptition) {
        this.name = name;
        this.descriptition = descriptition;
    }

    public String getName() {
        return name;
    }

    public String getDescriptition() {
        return descriptition;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescriptition(String descriptition) {
        this.descriptition = descriptition;
    }
}
