package cn.lkhcoding.aspectj.test08;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

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
	 * 最终通知：@After
	 *    属性：value ，切入点表达式
	 *    位置：方法的上面
	 * 特点：
	 *  1.在目标方法之后执行的。
	 *  2.总是会被执行的
	 *  
	 *  try{
	 *    doThird();
	 *  }finally{
	 *    myAfter();
	 *  }
	 */
	@After(value="mypt()")
	public void myAfter(){
		//程序结束时，执行的工作， 资源回收， 内存释放等等。
		System.out.println("最终通知：总是会执行的代码");
	}
	
	@Before(value="mypt()")
	public void myBefore(){
		//日志功能的代码。
		System.out.println("前置通知：在目标方法之前，加入非业务功能，日志");
	}
	
	/**
	 * @Pointcut:定义和管理切入点的注解。当程序中有多个通知使用同一个切入点。
	 *  此时使用 @Pointcut对切入点集中定义和管理。
	 *  
	 *  属性： value , 切入点表达式
	 *  位置: 在自定义的方法上面，使用@Pointcut修饰的方法名称，就是切入点的别名。
	 *       在其他通知方法中，value属性值就可以直接使用方法名称。
	 *
	 */
	@Pointcut(value="execution(* *..SomeServiceImpl.doSome(..))")
	private void mypt(){
		//无需代码
	}
	
	
}
