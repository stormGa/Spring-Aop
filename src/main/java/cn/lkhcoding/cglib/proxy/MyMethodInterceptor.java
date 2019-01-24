package cn.lkhcoding.cglib.proxy;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 实现对目标方法增强
 */
public class MyMethodInterceptor implements MethodInterceptor {

    private Object target;

    public MyMethodInterceptor(Object target) {
        this.target = target;
    }

    public MyMethodInterceptor() {
    }

    /**
     * 方法作用：拦截对目标方法调用。 用户实际调用执行的是intercept(),在这个方法内部调用目标方法
     * 参数：
     * Object proxyObj:cglib生成的代理对象
     * Method method:目标方法（doSome）
     * Object[] args:方法的参数列表
     * MethodProxy proxy:方法的代理对象
     *
     * 返回值：
     * Object:目标方法执行结果（可以是修改后的结果）
     * @throws Throwable
     */
    @Override
    public Object intercept(Object proxyObj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        Object result = null;
        System.out.println("-----拦截方法-----");
        System.out.println("开始打印日志");
        method.invoke(target, args);
        System.out.println("结束打印日志");
        return result;
    }

}
