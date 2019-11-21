package com.vvzorichev.dao;

import com.vvzorichev.SessionFactoryUtil;
import com.vvzorichev.entities.LoginHash;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

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
        Query query = session.createQuery("From LoginHash where Login= :login");
        query.setParameter("login", login);
        List<LoginHash> lhList = query.list();
        for (LoginHash lh : lhList) {
            if (lh.GetHash().equals(hash))
                isContain = true;
        }
        session.getTransaction().commit();
        session.close();
        return isContain;
    }
}
