package com.revature.repositories;

import com.revature.models.Employee;
import com.revature.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class EmployeeRepoHBImpl implements EmployeeRepo{


    @Override
    public Employee getEmployee(int id) {
        Session session = HibernateUtil.getSession();
        Employee em = null;

        try{
            em = session.get(Employee.class, id);

        }catch(HibernateException e){
            e.printStackTrace();
        }finally {
            session.close();
        }

        return em;
    }

    @Override
    public Employee getEmployee(String username) {
        Session session = HibernateUtil.getSession();

        Employee em = null;


        try{
            Criteria crit = session.createCriteria(Employee.class);
            crit.add(Restrictions.eq("username", username));

            //a = (Actor) crit.uniqueResult();
            List<Employee> employees = crit.list();

            if(employees.size() > 0){
                em = (Employee) employees.get(0);
            }

            //CriteriaQuery crit2 = session.getCriteriaBuilder().createQuery().from(Actor.class);

        }catch (HibernateException e){
            e.printStackTrace();
        }finally {
            session.close();
        }
        return em;
    }

    @Override
    public List<Employee> getAllEmployees() {
        Session session = HibernateUtil.getSession();
        List<Employee> employees = null;

        try{
            //hql hibernate query language, hb wants to
            //simplify any sql ypu have to write by
            //1 only having to reference java classes
            //2not having to adjust this code per each RDBMS
            employees = session.createQuery("From Employee").list();

        }catch (HibernateException e){
            e.printStackTrace();
        }finally {
            session.close();
        }

        return employees;
    }

    @Override
    public Employee addEmployee(Employee em) {
        Session session = HibernateUtil.getSession();
        try{
            session.beginTransaction();

            em.setEmployeeId((int) session.save(em));

            session.getTransaction().commit();
        }catch(HibernateException e){
            e.printStackTrace();
            session.getTransaction().rollback();
            em = null;

        }finally {
            session.close();
        }


        return em;
    }

    @Override
    public Employee updateEmployee(Employee change) {
        Session session = HibernateUtil.getSession();
        Transaction tx  = null;
        try{
            tx = session.beginTransaction();
            session.update(change);
            tx.commit();

        }catch (HibernateException e){
            e.printStackTrace();
            tx.rollback();
            return null;
        }finally {
            session.close();
        }

        return change;
    }

    @Override
    public Employee deleteEmployee(Employee em) {
        Session session = HibernateUtil.getSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();

            session.delete(em);
            tx.commit();
        }catch (HibernateException e){
            e.printStackTrace();
            if(tx!=null) tx.rollback();
        }finally {
            session.close();
        }

        return em;
    }
}
