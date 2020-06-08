package com.amarsoft.Service;

import com.amarsoft.dao.UserDao;
import com.amarsoft.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Override
    public List<User> getAll() {
        return userDao.selectAll();
    }
}
