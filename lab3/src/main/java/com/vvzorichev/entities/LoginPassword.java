package com.vvzorichev.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="loginpassword")
public class LoginPassword {
    @Id
    private String Login;
    private String Password;

    public LoginPassword() {};

    public LoginPassword(String login, String password) {
        this.Login = login;
        this.Password = password;
    }

    public String GetPassword() {
        return Password;
    }

    public void SetPassword(String password) {
        this.Password = password;
    }

    public String GetLogin() {
        return Login;
    }

    public void SetLogin(String login) {
        this.Login = login;
    }

    @Override
    public String toString() { return Login; }
}