package cn.lkhcoding.minispring.dao.impl;

import cn.lkhcoding.minispring.dao.UserDao;

public class UserDaoMySqlImpl implements UserDao {
    @Override
    public void insertUser() {
        System.out.println("使用了mysql的插入操作");
    }
}
