package cn.lkhcoding.aspectj.test04;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
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
	 * 异常通知： @AfterThrowing
	 *   属性：1.value ，切入点表达式
	 *       2.throwing,自定义的变量名，表示目标方法抛出的异常对象， 和通知方法的参数名一样。
	 *   位置： 方法的上面
	 * 特点：
	 *   1.在目标方法的抛出异常时，才执行的。
	 *   2.它不是异常处理代码， 异常还是抛出的。 
	 *   3.主要是监控目标方法的执行情况， 可以记录异常。发送通知
	 *   
	 *  try{
	 *      proxy.doSecond();
	 *  }catch(Exception e){
	 *      myAfterThrowing(e)
	 *  }
	 */
	@AfterThrowing(value="execution(* *..SomeServiceImpl.doSecond(..))",throwing="ex")
	public void myAfterThrowing(Throwable ex){
		//记录异常到数据库， 日志文件， 可以发送邮件给开发人员，发送短信等
		System.out.println("异常通知：在目标方法抛出异常时执行的："+ex.getMessage());
	}
}
