package cn.lkhcoding.aop.proxy;

import cn.lkhcoding.aop.tools.ServiceTools;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyInvocationHandler implements InvocationHandler {

    private Object target;

    public MyInvocationHandler(Object target) {
        this.target = target;
    }

    public MyInvocationHandler() {
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        ServiceTools.doLog();
        Object result = null;

        result = method.invoke(target, args);
        ServiceTools.doLog();
        return result;

    }
}
