package com.revature.repositories;

import com.revature.models.Department;
import com.revature.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class DepartmentRepoHBImpl implements DepartmentRepo{

    @Override
    public Department getDepartment(int id) {
        Session session = HibernateUtil.getSession();
        Department d = null;

        try{
            d = session.get(Department.class, id);

        }catch(HibernateException e){
            e.printStackTrace();
        }finally {
            session.close();
        }

        return d;
    }

    @Override
    public List<Department> getAllDepartments() {
        Session session = HibernateUtil.getSession();
        List<Department> departments = null;

        try{
            //hql hibernate query language, hb wants to
            //simplify any sql ypu have to write by
            //1 only having to reference java classes
            //2not having to adjust this code per each RDBMS
            departments = session.createQuery("From Department").list();

        }catch (HibernateException e){
            e.printStackTrace();
        }finally {
            session.close();
        }

        return departments;
    }

    @Override
    public Department addDepartment(Department d) {
        Session session = HibernateUtil.getSession();
        try{
            session.beginTransaction();

            d.setDepartment_id((int) session.save(d));

            session.getTransaction().commit();
        }catch(HibernateException e){
            e.printStackTrace();
            session.getTransaction().rollback();
            d = null;

        }finally {
            session.close();
        }


        return d;
    }

    @Override
    public Department updateDepartment(Department change) {
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
    public Department deleteDepartment(Department d) {
        Session session = HibernateUtil.getSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();

            session.delete(d);
            tx.commit();
        }catch (HibernateException e){
            e.printStackTrace();
            if(tx!=null) tx.rollback();
        }finally {
            session.close();
        }

        return d;
    }
}
