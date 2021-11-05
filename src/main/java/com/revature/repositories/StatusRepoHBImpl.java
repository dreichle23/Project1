package com.revature.repositories;

import com.revature.models.Status;
import com.revature.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class StatusRepoHBImpl implements StatusRepo{
    @Override
    public Status getStatus(int id) {
        Session session = HibernateUtil.getSession();
        Status s = null;

        try{
            s = session.get(Status.class, id);

        }catch(HibernateException e){
            e.printStackTrace();
        }finally {
            session.close();
        }

        return s;
    }

    @Override
    public List<Status> getAllStatuses() {
        Session session = HibernateUtil.getSession();
        List<Status> statuses = null;

        try{
            //hql hibernate query language, hb wants to
            //simplify any sql ypu have to write by
            //1 only having to reference java classes
            //2not having to adjust this code per each RDBMS
            statuses = session.createQuery("From Status").list();

        }catch (HibernateException e){
            e.printStackTrace();
        }finally {
            session.close();
        }

        return statuses;
    }

    @Override
    public Status addStatus(Status s) {
        Session session = HibernateUtil.getSession();
        try{
            session.beginTransaction();

            s.setStatus_id((int) session.save(s));

            session.getTransaction().commit();
        }catch(HibernateException e){
            e.printStackTrace();
            session.getTransaction().rollback();
            s = null;

        }finally {
            session.close();
        }
        return s;
    }

    @Override
    public Status updateStatus(Status change) {
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
    public Status deleteStatus(Status s) {
        Session session = HibernateUtil.getSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();

            session.delete(s);
            tx.commit();
        }catch (HibernateException e){
            e.printStackTrace();
            if(tx!=null) tx.rollback();
        }finally {
            session.close();
        }

        return s;
    }
}
