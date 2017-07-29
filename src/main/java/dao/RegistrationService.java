package dao;


import persistence.Interval;
import persistence.Workday;

import java.sql.Date;
import java.util.List;

public interface RegistrationService {

    List<Interval> findWorkday(long docId, Date date);
    long saveTicket(long id, String name, String message);

}
