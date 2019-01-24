package cn.lkhcoding.aspectj.test02;

//目标类
public class SomeServiceImpl implements SomeService {

	@Override
	public void doSome(String name) { //切入点
		System.out.println("业务方法doSome" + name);

	}

	@Override
	public String doOther() {
		System.out.println("===========业务方法doOther==========");
		return "abcd";
	}

	@Override
	public Student doOtherObject() {
		System.out.println("===========业务方法doOtherObject==========");
		Student student = new Student();
		student.setAge(20);
		student.setName("李四");
		return student;
	}

}
