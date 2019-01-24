package cn.lkhcoding.aspectj.test05;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {

    public static void main(String[] args) {
        test01();
    }

    public static void test01() {
        String configLocation = "applicationContext05.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(configLocation);
        SomeService proxy = (SomeService) ctx.getBean("someServiceTarget");
        //使用代理执行的方法
        proxy.doThird();
    }


}
