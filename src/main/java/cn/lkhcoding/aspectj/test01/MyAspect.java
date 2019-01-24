package cn.lkhcoding.aspectj.test01;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * @Aspect: 切面类注解
 *   位置：类的上面
 * 切面类：是用来给目标类增加功能的。
 *
 */
@Aspect
public class MyAspect {

    /**
     * 前置通知：@Before
     *    属性：value,切入点表达式
     *    位置：在方法的上面
     * 特点：
     *  1.在目标方法之前执行的（执行时间）。
     *  2.不会改变目标方法的执行的。
     */
    @Before(value = "execution(* cn.lkhcoding.aspectj.test01.service.UserServiceImpl.insert*(..))")
    public void MyBefore(JoinPoint joinPoint) {
        System.out.println("方法签名：" + joinPoint.getSignature());
        System.out.println("方法名：" + joinPoint.getSignature().getName());


        //Object[] args = joinPoint.getArgs();


        // System.out.println("第一个参数：" + args[0]);


        System.out.println("----增强方法----");

    }
}
