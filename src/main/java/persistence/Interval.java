package persistence;

public class Interval {
  private Long id;
  private int time;
  private Long ticket;
  private Long workday;

  public Interval() {

  }

  public Interval(int time, long ticket, long workday) {
    this.time = time;
    this.ticket = ticket;
    this.workday = workday;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public int getTime() {
    return time;
  }

  public void setTime(int time) {
    this.time = time;
  }

  public Long getTicket() {
    return ticket;
  }

  public void setTicket(Long ticket) {
    this.ticket = ticket;
  }

  public Long getWorkday() {
    return workday;
  }

  public void setWorkday(Long workday) {
    this.workday = workday;
  }
}
