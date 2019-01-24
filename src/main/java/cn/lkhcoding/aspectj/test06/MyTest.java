package cn.lkhcoding.aspectj.test06;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {

	public static void main(String[] args) {
		test01();
	}
	public static void test01(){
		String configLocation="applicationContext06.xml";
		ApplicationContext ctx = new ClassPathXmlApplicationContext(configLocation);
		SomeService proxy  = (SomeService) ctx.getBean("someServiceTarget");
		System.out.println("proxy:"+proxy.getClass().getName());
		//使用代理执行的方法
		proxy.doSome("abc");
	}
	
	
}
