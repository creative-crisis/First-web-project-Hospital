package dao.impl;

import dao.DoctorsService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import persistence.Doctor;

import javax.persistence.Query;
import java.util.List;


public class DoctorsServiceImpl implements DoctorsService{

    private SessionFactory sessionFactory;

    public DoctorsServiceImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Doctor getDoctorById(long id) {
        Session session = sessionFactory.openSession();
        //Doctor doc =  session.load(Doctor.class, new Long(id));
        Query query = session.createQuery("from Doctor where id = :id ");
        query.setParameter("id", id);
        Doctor doc = (Doctor) query.getSingleResult();
        session.close();
        return doc;
    }

    public void addDoctor(Doctor doc) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(doc);
        session.getTransaction().commit();
        session.close();
    }

    public Doctor addDoctor(String firstName, String lastName, long specialization) {
        Doctor doc = new Doctor(firstName, lastName, specialization);
        addDoctor(doc);
        return doc;
    }

    public Doctor updateDoctor
            (Doctor doc, String firstName, String lastName, long specialization) {
        Session session = sessionFactory.openSession();
//        doc.setFirstName(firstName);
//        doc.setLastName(lastName);
//        doc.setSpecialization(specialization);
        session.beginTransaction();
        doc.setDoctor(firstName, lastName, specialization);
        session.update(doc);
        session.getTransaction().commit();
        session.close();
        return doc;
    }

    public Doctor updateDoctor
            (long id, String firstName, String lastName, long specialization) {
        return updateDoctor(getDoctorById(id),firstName,lastName,specialization);
    }

    public void deleteDoctor(Doctor doc) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(doc);
        session.getTransaction().commit();
        session.close();
    }

    public void deleteDoctor(long id) {
        deleteDoctor(getDoctorById(id));
    }

    public List<Doctor> getAllDoctors() {
        Session session = sessionFactory.openSession();
        Query query= session.createQuery("from Doctor");
        List<Doctor> list = query.getResultList();
        session.close();
        return list;
    }

    public List<Doctor> getDoctorsBySpecialization(long spec) {
        if (spec == 0) { return getAllDoctors(); }
        Session session = sessionFactory.openSession();
        Query query= session.createQuery("from Doctor where specialization = :s");
        query.setParameter("s", spec);
        List<Doctor> list = query.getResultList();
        session.close();
        return list;
    }
}
