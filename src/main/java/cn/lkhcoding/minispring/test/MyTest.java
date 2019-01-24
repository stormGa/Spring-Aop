package cn.lkhcoding.minispring.test;

import java.io.File;
import java.io.IOException;

import cn.lkhcoding.minispring.Container;
import cn.lkhcoding.minispring.service.UserService;
public class MyTest {

	public static void main(String[] args) throws SecurityException, IllegalArgumentException, IllegalAccessException, IOException, Exception {
		//创建对象，调用它的方法
		//UserService service  = new UserServiceImpl();
		//service.addUser();
		
		String path  = MyTest.class.getClassLoader().getResource("UserDao.txt").getPath();
		//path = "D:\course\JavaProjects\16-Spring4\01-miniSpring\bin";
		File file  = new File(path);
		Container cc = new Container(file);

		//从Container中获取对象
		UserService myService = (UserService) cc.getBean("service");
		myService.addUser();
	}

}
