package com.vvzorichev;

import java.util.HashSet;
import java.util.Set;

public class Singltone1 {

    private Set<String> SetId;

    private Singltone1() {
        SetId = new HashSet<String>();
    }

    private static class SingltoneSetHolder {
        private final static Singltone1 instance = new Singltone1();
    }

    public static Singltone1 getInstance () {
        return SingltoneSetHolder.instance;
    }

    public void addSessionId (String sessionId) {
        SetId.add(sessionId);
    }

    public boolean containsSessionId (String sessionId) {
        return SetId.contains(sessionId);
    }
}