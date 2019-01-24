package cn.lkhcoding.aspectj.test03;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
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
	 * 环绕通知： @Around
	 *   属性：value ，切入点表达式
	 *   位置：方法的上面
	 * 特点：
	 *  1.在目标方法的前和后都能增强功能。
	 *  2.能够控制目标的执行
	 *  3.能够改变目标方法的执行结果
	 *
	 *参数：
	 *  ProceedingJoinPoint：执行目标方法，获取切入点的信息
	 *返回值：
	 *  目标方法的执行结果（可以是修改后的其他结果）
	 *  
	 */
	@Around(value="execution(* *..SomeServiceImpl.doFirst(..))")
	public Object myAround(ProceedingJoinPoint pjp) throws Throwable{
		
		//获取切入点的签名
		System.out.println("签名信息："+pjp.getSignature());
		Object args [] = pjp.getArgs();
		System.out.println("参数的个数："+args.length);
		
		Object result = null;
		System.out.println("环绕通知：在目标方法之前，增加日志的功能");
		//调用执行，目标方法
		
		result = pjp.proceed(); //jdk中的动态代理 method.invoke();
		
		//修改目标方法的执行结果
		if( result != null){
			result = "Hello AspectJ Around";
		}
		
		System.out.println("环绕通知：在目标方法之后，增加事务的功能");
		//目标方法的执行结果
		return result;
	}
}
