package cn.lkhcoding.aspectj.test01;

import cn.lkhcoding.aspectj.test01.service.UserServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        String configLocation ="applicationContext01.xml";
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(configLocation);
        UserServiceImpl userService = (UserServiceImpl) applicationContext.getBean("UserService");
        userService.insertUser();
    }

}
