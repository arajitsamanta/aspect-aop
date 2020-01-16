package com.arajit.aspect;

import org.apache.logging.log4j.util.Supplier;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class Log4j2Aspect {
  @Before("execution(* org.apache.logging.log4j.Logger.*(*)) && args(message)")
  public void methodCallWithoutSupplierArgument(JoinPoint thisJoinPoint, Object message) throws Exception {
    System.out.println("methodCallWithoutSupplierArgument: " + thisJoinPoint);
    System.out.println("  message: " + message);
  }

  @Before("execution(* org.apache.logging.log4j.Logger.*(*)) && args(messageSupplier)")
  public void methodCallWithSupplierArgument(JoinPoint thisJoinPoint, Supplier messageSupplier) throws Exception {
    Object message = messageSupplier/*.get()*/;  // no 'get()' call anymore
    System.out.println("methodCallWithSupplierArgument: " + thisJoinPoint);
    System.out.println("  message: " + message);
  }

  @AfterReturning(pointcut = "call(public * org.apache.logging.log4j.util.Supplier+.get())", returning = "result")
  public void supplierEvaluated(JoinPoint thisJoinPoint, Object result) throws Exception {
    System.out.println("supplierEvaluated: " + thisJoinPoint);
    System.out.println("  result: " + result);
  }
}
