package com.vvzorichev.dao;

import com.vvzorichev.SessionFactoryUtil;
import com.vvzorichev.entities.LoginHash;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class DAOLoginHash {

    private SessionFactory SessFact;

    public DAOLoginHash() {
        this.SessFact = SessionFactoryUtil.GetSessionFactory();
    }

    public void AddLoginHash(String login, String hash) {
        Session session = SessFact.openSession();
        session.beginTransaction();
        LoginHash lh = new LoginHash(login, hash);
        session.save(lh);
        session.getTransaction().commit();
        session.close();
    }

    public boolean IsContainLoginHash(String login, String hash) {
        boolean isContain = false;
        Session session = SessFact.openSession();
        session.beginTransaction();
        LoginHash lh = session.get(LoginHash.class, login);
        if (lh != null) {
            if (lh.GetHash().equals(hash)) {
                isContain = true;
            }
        }
        session.getTransaction().commit();
        session.close();
        return isContain;
    }

    public boolean IsHashContainInTable(String hash) {
        boolean isContain = false;
        Session session = SessFact.openSession();
        session.beginTransaction();
        List<LoginHash> lhList = (List<LoginHash>) session.createQuery("From LoginHash").list();
        for (LoginHash lh : lhList) {
            if (lh.GetHash().equals(hash))
                isContain = true;
        }
        session.getTransaction().commit();
        session.close();
        return isContain;
    }
}
