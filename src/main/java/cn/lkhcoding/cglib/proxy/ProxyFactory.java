package cn.lkhcoding.cglib.proxy;

import cn.lkhcoding.cglib.service.UserService;
import net.sf.cglib.proxy.Enhancer;

public class ProxyFactory {
    public Object getProxy(Object target) {
        Enhancer enhancer = new Enhancer();
        //指定需要增强的类
        enhancer.setSuperclass(UserService.class);

        //指定功能增强的拦截器
        enhancer.setCallback(new MyMethodInterceptor(target));
        return enhancer.create();
    }
}
