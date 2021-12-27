package com.akshitbaunthy.crm.service;

import com.akshitbaunthy.crm.entity.Customer;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private SessionFactory sessionFactory;

    private Session session;

    @Autowired
    public CustomerServiceImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
        try {
            session = sessionFactory.getCurrentSession();
        } catch (HibernateException ex) {
            session = sessionFactory.openSession();
        }
    }

    @Override
    @Transactional
    public void insert(Customer customer) {
        Transaction tx = session.beginTransaction();
        session.saveOrUpdate(customer);
        tx.commit();
    }

    @Override
    @Transactional
    // Function that is called by /delete, this does the actual deletion
    public void delete(int id) {
        Transaction tx = session.beginTransaction();
        Customer customer = session.get(Customer.class, id);
        if (customer != null)
            session.delete(customer);
        tx.commit();
    }

    @Override
    // Function that is called by /list, this does the actual listing
    public List<Customer> getAll() {
        Transaction tx = session.beginTransaction();
        List<Customer> customers = session.createQuery("from Customer").list();
        tx.commit();
        return customers;
    }

    @Override
    // Function that is called by /insert (in case of update), this does the finding part (get by ID, as the name suggests)
    public Customer getById(int id) {
        Transaction tx = session.beginTransaction();
        Customer customer = session.get(Customer.class, id);
        tx.commit();
        return customer;
    }
}
