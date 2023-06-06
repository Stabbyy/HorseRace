package com.example;

import com.example.entity.Horses;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.Query;
import java.util.List;

public class HorsesHelper {

    private final SessionFactory sessionFactory;

    public HorsesHelper() {
        sessionFactory = HibernateUtil.getSessionFactory();
    }

    public List<Horses> getHorsesList() {
        Session session = sessionFactory.openSession();
        session.get(Horses.class, 1L);

        String hql = "FROM Horses ORDER BY id";
        Query query = session.createQuery(hql);

        List<Horses> horsesList = query.getResultList();

        session.close();

        return horsesList;
    }
}
