package com.vvzorichev.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="loginhash")
public class LoginHash {
    @Id
    private String Login;
    private String Hash;

    public LoginHash() {};

    public LoginHash(String login, String hash) {
        this.Login = login;
        this.Hash = hash;
    }

    public String GetHash() {
        return Hash;
    }

    public void SetHash(String hash) {
        this.Hash = hash;
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
