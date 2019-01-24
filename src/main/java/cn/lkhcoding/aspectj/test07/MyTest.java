package cn.lkhcoding.aspectj.test07;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
	public static void main(String[] args) {
		test01();
	}
	public static void test01(){
		String configLocation="applicationContext07.xml";
		ApplicationContext ctx = new ClassPathXmlApplicationContext(configLocation);
		SomeServiceImpl proxy  = (SomeServiceImpl) ctx.getBean("someServiceTarget");
		//当你的目标类没有接口，使用的是cglib动态代理
		System.out.println("proxy:"+proxy.getClass().getName());
		//使用代理执行的方法
		proxy.doSome();
	}
	
	
}
