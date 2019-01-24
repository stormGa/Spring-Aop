package cn.lkhcoding.minispring.service.impl;

import cn.lkhcoding.minispring.dao.UserDao;
import cn.lkhcoding.minispring.service.UserService;

public class UserServiceImpl implements UserService {
    private UserDao userDao;

    public void setUserDao(UserDao userDao){
        this.userDao = userDao;
    }

    @Override
    public void addUser() {
        userDao.insertUser();
    }
}
