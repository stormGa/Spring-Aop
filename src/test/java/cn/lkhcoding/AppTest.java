package cn.lkhcoding;

import static org.junit.Assert.assertTrue;

import cn.lkhcoding.aspectj.test01.service.UserServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Unit test01 for simple App.
 */
public class AppTest {
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {
        assertTrue(true);
    }

    @Test
    public void test() {
        String configLocation = "applicationContext01.xml";
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(configLocation);
        UserServiceImpl userService = (UserServiceImpl) applicationContext.getBean("UserService");
        userService.insertUser();
    }
}
