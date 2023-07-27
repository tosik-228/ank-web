package com.ank.service;

import com.ank.model.XUser;
import com.ank.repo.UserRepositoryJPA;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepositoryJPA repo;

    public void save(XUser user) {
        repo.save(user);
    }
}
