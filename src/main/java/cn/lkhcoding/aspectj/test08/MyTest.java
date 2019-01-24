package cn.lkhcoding.aspectj.test08;
;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
	public static void main(String[] args) {
		test01();
	}
	public static void test01(){
		String configLocation="applicationContext08.xml";
		ApplicationContext ctx = new ClassPathXmlApplicationContext(configLocation);
		SomeService proxy  = (SomeService) ctx.getBean("someServiceTarget");
		
		//目标类有接口也可以使用cglib动态代理
		System.out.println("proxy:"+proxy.getClass().getName());
		//使用代理执行的方法
		proxy.doSome("abc");
	}
	
	
}
