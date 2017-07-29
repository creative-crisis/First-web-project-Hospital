package dao.impl;

import dao.RegistrationService;
import org.hibernate.Session;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import persistence.HibernateUtil;
import persistence.Interval;
import persistence.Ticket;
import persistence.Workday;

import javax.persistence.Query;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Repository
public class RegistrationServiceImpl implements RegistrationService {

    public List<Interval> findWorkday(long docId, Date date) {
        Workday day;
        Interval interval;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query= session.createQuery("from Workday where doctor = :s1 and date = :s2");
        query.setParameter("s1", docId);
        query.setParameter("s2", date);
        List list = query.getResultList();
        if (list.isEmpty()) {

            session.beginTransaction();
            day = new Workday();
            day.setDoctor(docId);
            day.setDate(date);
            session.save(day);
            day.getId();

            for (int i = 0; i < 96; i++) {
                interval = new Interval();
                interval.setTime(i);
                interval.setWorkday(day.getId());
                //interval.setTicket(0l);
                session.save(interval);
            }
            session.getTransaction().commit();

        } else {
            day = (Workday) list.get(0);
        }

        query= session.createQuery("from Interval where workday = :s1");
        query.setParameter("s1", day.getId());
        list = query.getResultList();
        Collections.sort(list, new Comparator<Interval>() {
                    public int compare(Interval o1, Interval o2) {
                        return o1.getTime() - (o2.getTime());
                    }
                });
        session.close();
        return list;
    }

    public long saveTicket(long time, String name, String message) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Ticket ticket = new Ticket();
        ticket.setName(name);
        ticket.setMessage(message);
        session.save(ticket);

        Interval interval = session.load(Interval.class, time);
        interval.setTicket(ticket.getId());
        session.update(interval);

        session.getTransaction().commit();
        session.close();
        return ticket.getId();
    }

}
