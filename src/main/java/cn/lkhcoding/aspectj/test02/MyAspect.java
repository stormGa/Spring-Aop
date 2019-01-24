package cn.lkhcoding.aspectj.test02;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
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

	//定义方法，实现功能的增强
	/**
	 * 后置通知：@AfterReturning
	 *   属性：1.value,表示切入点表达式
	 *       2.returning,是String类型的值，自定义的变量，表示目标方法的执行结果。
	 *         必须和通知方法的中的参数名一样。
	 *   位置：方法的上面
	 * 特点：
	 *  1.在目标方法之后执行的
	 *  2.能够获取到目标方法的执行结果
	 *    ①目标方法返回的是：对象类型（不包括String）的，是可以在通知方法中修改他的属性。影响最终的执行结果。
	 *    ②目标方法返回的是：简单类型（String和基本类型）的，不能修改值，改变目标方法的执行结果。
	 *  3.不能影响目标方法的执行。
	 *  
	 *  Object result = doOther();  //String
	 *  myAfterReturning(result)    //传值
	 *  
	 */
	@AfterReturning(value="execution(* *..SomeServiceImpl.doOther(..))",returning="result")
	public void myAfterReturning(Object result){
		//非业务功能，事务的处理
		//修改目标方法的返回值
		if( result != null){
			String str =(String)result;
			result = str.toUpperCase();
		}
		System.out.println("后置通知：在目标方法之后执行的，能够获取到目标方法的执行结果："+result);
	}
	
	/**
	 *  Object result = doOther();  //Student
	 *  myAfterReturning(result)    //传引用
	 */
	@AfterReturning(value="execution(* *..SomeServiceImpl.doOtherObject(..))",returning="result")
	public void myAfterReturning2(JoinPoint jp,Object result){
		//非业务功能，事务的处理
		
		Object args [] = jp.getArgs();
		System.out.println("目标方法的参数个数："+args.length);
		//修改目标方法的返回值
		if( result != null){
			Student stu = (Student)result;
			stu.setAge(30);
			stu.setName("张三");
		}
		System.out.println("后置通知：在目标方法之后执行的，能够获取到目标方法的执行结果："+result);
		
		//日志格式：
		//时间|方法名|目标方法的执行结果|参数0|参数1|参数N
	}
}
