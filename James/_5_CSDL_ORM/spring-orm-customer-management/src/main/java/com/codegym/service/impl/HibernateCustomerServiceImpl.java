package com.codegym.service.impl;

import com.codegym.model.Customer;
import com.codegym.service.HibernateCustomerService;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class HibernateCustomerServiceImpl implements HibernateCustomerService {
    private static SessionFactory sessionFactory;
    private static EntityManager entityManager;
    static List<Customer> customerList = new ArrayList<>();

    static {
        try {
            sessionFactory = new Configuration()
                    .configure("hibernate.conf.xml")
                    .buildSessionFactory();
            entityManager = sessionFactory.createEntityManager();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

//    private Customer customer;

    @Override
    public boolean exists(Long id) {
        return false;
    }

    @Override
    public List<Customer> findAll() {
        String queryStr = "SELECT c FROM Customer AS c";
        TypedQuery<Customer> query = entityManager.createQuery(queryStr, Customer.class);
        return query.getResultList();
    }

    @Override
    public Customer findOne(Long id) {
        String queryStr = "SELECT c FROM Customer AS c WHERE c.id = :id";
        TypedQuery<Customer> query = entityManager.createQuery(queryStr, Customer.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public Customer save(Customer customer) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();

            Customer origin = new Customer();
            if (customer.getId() != null) {
                origin = findOne(customer.getId());
            }

            origin.setFullName(customer.getFullName());
            origin.setEmail(customer.getEmail());
            origin.setPhone(customer.getPhone());
            origin.setAddress(customer.getAddress());

            session.saveOrUpdate(origin);
            transaction.commit();
            return origin;
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return null;
    }
    @Override
    public void remove(Long id) {
        Customer customer = findOne(id);
        if (customer != null) {
            entityManager.remove(customer);
        }
    }
    @Override
    @Transactional
    public void delete(Long id) {

//        Transaction transaction = null;
//        Session session = sessionFactory.openSession();
//        transaction = session.beginTransaction();

        String queryStr = "DELETE FROM Customer AS c WHERE c.id = :id ";

//        session.createQuery(queryStr, Customer.class);
//        transaction.commit();

//        Query query = entityManager.createQuery(queryStr, Customer.class);
        TypedQuery<Customer> query = entityManager.createQuery(queryStr, Customer.class);
        query.setParameter("id", id);
        query.executeUpdate();

//        Transaction transaction = null;
//        try {
//            Session session = sessionFactory.openSession();
//            transaction = session.beginTransaction();
//
//            Customer customer = findOne(id);
//
//            if (customer != null) {
//                session.delete(customer);
//                transaction.commit();
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            if (transaction != null) {
//                transaction.rollback();
//            }
//        }
    }

    @Override
    public void delete(Customer customer) {
        String queryStr = "DELETE FROM Customer AS c WHERE c.id = :id";
        TypedQuery<Customer> query = entityManager.createQuery(queryStr, Customer.class);
        query.setParameter("id", customer);
        query.executeUpdate();
    }

//    @Override
//    public List<Customer> searchByName(Customer customer) {
//        List<Customer> listSearchByName = new ArrayList<>();
//
//        for (int i = 0; i < customerList.size(); i++) {
//            if (customerList.get(i).getFullName().contains(customer.getFullName())) {
//                listSearchByName.add(customerList.get(i));
//            }
//        }
//        return listSearchByName;
//    }

}


