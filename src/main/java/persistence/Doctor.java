package persistence;


public class Doctor {

    private long id;
    private String firstName;
    private String lastName;
    private long specialization;

    public Doctor() {

    }

    public Doctor(String firstName, String lastName, long specialization) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.specialization = specialization;
    }

    public Doctor setDoctor(String firstName, String lastName, long specialization) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.specialization = specialization;
        return this;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public long getSpecialization() {
        return specialization;
    }

    public void setSpecialization(long specialization) {
        this.specialization = specialization;
    }

}
