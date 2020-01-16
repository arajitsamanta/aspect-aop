package com.arajit.aspect;

import java.util.function.Supplier;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class Log4j2Aspect {

  @Before("execution(* org.apache.logging.log4j.Logger.*(*))")
  public void methodCallWithoutSupplierArgument(JoinPoint thisJoinPoint) throws Exception {
    System.out.println("methodCallWithoutSupplierArgument: " + thisJoinPoint);
    Object[] args = thisJoinPoint.getArgs();
    for (int i = 0; i < args.length; i++) {
      System.out.println("arsg:" + args[i]);
    }
  }

  @Before("execution(public * org.apache.logging.log4j.Logger.*(*)) && args(supplier)")
  public void methodCallWitSupplierArgument(JoinPoint thisJoinPoint, Supplier<?> supplier)
      throws Exception {
    System.out.println("methodCallWitSupplierArgument: " + thisJoinPoint + " -> " + supplier);
    Object obj = thisJoinPoint.getArgs();

    Object[] args = thisJoinPoint.getArgs();
    for (int i = 0; i < args.length; i++) {
      System.out.println("arsg:" + args[i]);
    }
  }
}
