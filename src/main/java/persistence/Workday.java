package persistence;

import java.sql.Date;

public class Workday {
  private Long id;
  private Long doctor;
  private Date date;

  public Workday() {

  }

  public Workday(long doctor, Date date) {
    this.doctor = doctor;
    this.date = date;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getDoctor() {
    return doctor;
  }

  public void setDoctor(Long doctor) {
    this.doctor = doctor;
  }

  public java.sql.Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

}
