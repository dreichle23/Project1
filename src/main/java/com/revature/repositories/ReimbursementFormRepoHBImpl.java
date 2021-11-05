package com.revature.repositories;

import com.revature.models.ReimburseFile;
import com.revature.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ReimbursementFormRepoHBImpl implements ReimbursementForm{
    @Override
    public ReimburseFile getForm(int id) {
        Session session = HibernateUtil.getSession();
        ReimburseFile f = null;

        try{
            f = session.get(ReimburseFile.class, id);

        }catch(HibernateException e){
            e.printStackTrace();
        }finally {
            session.close();
        }

        return f;
    }

    @Override
    public List<ReimburseFile> getAllForms() {
        Session session = HibernateUtil.getSession();
        List<ReimburseFile> files = null;

        try{
            //hql hibernate query language, hb wants to
            //simplify any sql ypu have to write by
            //1 only having to reference java classes
            //2not having to adjust this code per each RDBMS
            files = session.createQuery("From ReimburseFile").list();

        }catch (HibernateException e){
            e.printStackTrace();
        }finally {
            session.close();
        }

        return files;
    }

    @Override
    public ReimburseFile addForm(ReimburseFile f) {
        Session session = HibernateUtil.getSession();
        try{
            session.beginTransaction();

            f.setFileId((int) session.save(f));

            session.getTransaction().commit();
        }catch(HibernateException e){
            e.printStackTrace();
            session.getTransaction().rollback();
            f = null;

        }finally {
            session.close();
        }
        return f;
    }

    @Override
    public ReimburseFile updateForm(ReimburseFile change) {
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
    public ReimburseFile deleteForm(ReimburseFile f) {
        Session session = HibernateUtil.getSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();

            session.delete(f);
            tx.commit();
        }catch (HibernateException e){
            e.printStackTrace();
            if(tx!=null) tx.rollback();
        }finally {
            session.close();
        }

        return f;
    }
}
