package com.vvzorichev.services;

import com.vvzorichev.model.User_;

import java.util.List;

public interface UserService {

    List<User_> listAll();

    User_ getById(Long id);

    User_ saveUser(User_ user);

    boolean checkIfExists(User_ user);

    boolean checkIfEmailIsReserved(User_ user);
}

