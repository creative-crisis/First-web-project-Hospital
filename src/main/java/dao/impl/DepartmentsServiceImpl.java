package dao.impl;


import dao.DepartmentsService;
import org.hibernate.Session;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import persistence.Department;
import persistence.HibernateUtil;

import javax.persistence.Query;
import java.util.List;

@Repository
public class DepartmentsServiceImpl implements DepartmentsService {

    public List<Department> getDepartments() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query= session.createQuery("from Department");
        List<Department> list = query.getResultList();
        return list;
    }
}
