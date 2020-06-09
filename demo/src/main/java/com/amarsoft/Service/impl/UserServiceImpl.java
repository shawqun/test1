package com.amarsoft.Service.impl;

import com.amarsoft.Service.UserService;
import com.amarsoft.dao.UserDao;
import com.amarsoft.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private BCryptPasswordEncoder encoder;
    @Autowired(required = false)
    private UserDao userDao;

    @Override
    public List<User> getAll() {
        return userDao.selectAll();
    }

    @Override
    public void save(User user) {
        String password = user.getPassword();
        user.setPassword(encoder.encode(password));
        userDao.insertSelective(user);
    }

    @Override
    public User findByName(String username) {
        User user = new User(username);
        return userDao.selectOne(user);
    }
}
