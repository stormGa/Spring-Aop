package cn.lkhcoding.cglib.test;

import cn.lkhcoding.cglib.proxy.ProxyFactory;
import cn.lkhcoding.cglib.service.UserService;

public class Test {
    public static void main(String[] args) {
        UserService userService = new UserService();

        ProxyFactory factory = new ProxyFactory();

        UserService proxyUserService = (UserService) factory.getProxy(userService);

        System.out.println(proxyUserService.getClass().getName());

        proxyUserService.doSomething();

    }
}
