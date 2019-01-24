package cn.lkhcoding.aop;


import cn.lkhcoding.aop.proxy.MyInvocationHandler;
import cn.lkhcoding.aop.service.UserService;
import cn.lkhcoding.aop.service.UserServiceImpl;


import java.lang.reflect.Proxy;

public class Test {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();

        UserService proxyUserService = (UserService) Proxy.newProxyInstance
                (userService.getClass().getClassLoader(), userService.getClass().getInterfaces(), new MyInvocationHandler(userService));
        proxyUserService.insertUser();
    }
}
