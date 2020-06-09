package com.amarsoft.Service;

import com.amarsoft.pojo.User;

import java.util.List;

public interface UserService {

    List<User> getAll();

    void save(User user);

    User findByName(String username);

}
