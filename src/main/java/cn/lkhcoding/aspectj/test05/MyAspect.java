package cn.lkhcoding.aspectj.test05;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;

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
	@After(value="execution(* *..SomeServiceImpl.doThird(..))")
	public void myAfter(){
		//程序结束时，执行的工作， 资源回收， 内存释放等等。
		System.out.println("最终通知：总是会执行的代码");
	}
}
