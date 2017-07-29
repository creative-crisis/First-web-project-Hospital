package persistence;

public class Ticket {

  private Long id;
  private String name;
  private String message;

  public Ticket() {

  }

  public Ticket(String name, String message) {
    this.name = name;
    this.message = message;
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

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }
}
