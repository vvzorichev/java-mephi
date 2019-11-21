package com.vvzorichev.dao;

import com.vvzorichev.entities.LoginPassword;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import java.util.List;
import com.vvzorichev.SessionFactoryUtil;

public class DAOLoginPassword {

    private SessionFactory SessFact;

    public DAOLoginPassword() {
        this.SessFact = SessionFactoryUtil.GetSessionFactory();
    }

    public void AddLoginPassword(String login, String password) {
        Session session = SessFact.openSession();
        session.beginTransaction();
        LoginPassword lp = new LoginPassword(login, password);
        session.save(lp);
        session.getTransaction().commit();
        session.close();
    }

    public boolean IsContainLoginPassword(String login, String password) {
        boolean isContain = false;
        Session session = SessFact.openSession();
        session.beginTransaction();
        LoginPassword lp = session.get(LoginPassword.class, login);
        if (lp != null) {
            if (lp.GetPassword().equals(password)) {
                isContain = true;
            }
        }
        session.getTransaction().commit();
        session.close();
        return isContain;
    }

    public boolean IsContainLogin(String login) {
        boolean isContain = false;
        Session session = SessFact.openSession();
        session.beginTransaction();
        LoginPassword lp = session.get(LoginPassword.class, login);
        if (lp != null) {
            isContain = true;
        }
        session.getTransaction().commit();
        session.close();
        return isContain;
    }

    public List<LoginPassword> FindAll() {
        Session session = SessFact.openSession();
        session.beginTransaction();
        List<LoginPassword> lpList = (List<LoginPassword>) session.createQuery("From LoginPassword").list();
        session.getTransaction().commit();
        session.close();
        return lpList;
    }
}