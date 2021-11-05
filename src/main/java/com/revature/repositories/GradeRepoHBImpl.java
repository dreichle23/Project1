package com.revature.repositories;

import com.revature.models.Grade;
import com.revature.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class GradeRepoHBImpl implements GradeRepo{
    @Override
    public Grade getGrade(int id) {
        Session session = HibernateUtil.getSession();
        Grade g = null;

        try{
            g = session.get(Grade.class, id);

        }catch(HibernateException e){
            e.printStackTrace();
        }finally {
            session.close();
        }

        return g;
    }

    @Override
    public List<Grade> getAllGrades() {
        Session session = HibernateUtil.getSession();
        List<Grade> grades = null;

        try{
            //hql hibernate query language, hb wants to
            //simplify any sql ypu have to write by
            //1 only having to reference java classes
            //2not having to adjust this code per each RDBMS
            grades = session.createQuery("From Grade").list();

        }catch (HibernateException e){
            e.printStackTrace();
        }finally {
            session.close();
        }

        return grades;
    }

    @Override
    public Grade addGrade(Grade g) {
        Session session = HibernateUtil.getSession();
        try{
            session.beginTransaction();

            g.setGradeId((int) session.save(g));

            session.getTransaction().commit();
        }catch(HibernateException e){
            e.printStackTrace();
            session.getTransaction().rollback();
            g = null;

        }finally {
            session.close();
        }


        return g;
    }

    @Override
    public Grade updateGRade(Grade change) {
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
    public Grade deleteGrade(Grade g) {
        Session session = HibernateUtil.getSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();

            session.delete(g);
            tx.commit();
        }catch (HibernateException e){
            e.printStackTrace();
            if(tx!=null) tx.rollback();
        }finally {
            session.close();
        }

        return g;
    }
}
