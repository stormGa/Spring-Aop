# Spring-Aop


## 第一部分 minispring包
先用反射和集合模拟了Spring IOC特性

## 第二部分 aop包
使用jdk中的Proxy实现动态代理

## 第三部分 cglib包
使用cglib实现动态代理

## 第四部分 aspectj包
### test01
使用aspectj 前置通知
### test02
使用aspectj 后置通知
### test03
使用aspectj 环绕通知
### test04
使用aspectj 异常通知 （优雅的处理异常）
### test05
使用aspectj 最终通知
### test06
使用aspectj  @Pointcut对切入点集中定义和管理。
### test07
如果没有接口，spring使用cglib实现动态代理
如果有接口，默认使用Proxy类
### test08
目标类有接口也可以使用cglib动态代理，在配置文件中声明
```
  <!-- 声明自动代理生成器
         proxy-target-class：true，表示使用cglib动态代理
     -->
    <aop:aspectj-autoproxy proxy-target-class="true"/>
```
