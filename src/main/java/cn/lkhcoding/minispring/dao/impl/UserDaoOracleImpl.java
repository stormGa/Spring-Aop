package cn.lkhcoding.minispring.dao.impl;

import cn.lkhcoding.minispring.dao.UserDao;

public class UserDaoOracleImpl implements UserDao {
    @Override
    public void insertUser() {
        System.out.println("使用了Oracle的插入操作");
    }
}
