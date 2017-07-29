package persistence;


public class Department {
    private Long id;
    private String name;
    private Long chief;

    public Department() {

    }

    public Department(String name, Long chief) {
        this.name = name;
        this.chief = chief;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getChief() {
        return chief;
    }

    public void setChief(Long chief) {
        this.chief = chief;
    }
}


