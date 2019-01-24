package cn.lkhcoding.aspectj.test02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {


    public static void main(String[] args) {
       // test01();
        test02();
    }

    public static void test01() {
        String configLocation = "applicationContext02.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(configLocation);
        SomeService proxy = (SomeService) ctx.getBean("someServiceTarget");
        //使用代理执行的方法
        String str = proxy.doOther();
        System.out.println("通过代理执行目标方法的结果：" + str);
    }


    public static void test02() {
        String configLocation = "applicationContext02.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(configLocation);
        SomeService proxy = (SomeService) ctx.getBean("someServiceTarget");
        //使用代理执行的方法
        Student myStudent = proxy.doOtherObject();
        System.out.println("通过代理执行目标方法的结果：" + myStudent); // [name=李四, age=20]
    }
}
