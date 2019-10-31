package com.soholy.dogmanager.common.aop;
//package com.shl.aop;
//
//import org.apache.log4j.Logger;
//import org.aspectj.lang.JoinPoint;
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.After;
//import org.aspectj.lang.annotation.AfterReturning;
//import org.aspectj.lang.annotation.AfterThrowing;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Before;
//import org.aspectj.lang.annotation.Pointcut;
//
///**
// * @ClassName GlobalLogAspect
// * @Description TODO(全局日志切面)
// * @author guanY
// * @Date 2018年4月9日 下午6:43:53
// * @version 1.0.0
// */
//@Aspect
//public class GlobalLogAspect {
//
//    private static Logger logger = Logger.getLogger(GlobalLogAspect.class);
//
//    // 定义切入点，提供一个方法，这个方法的名字就是改切入点的id
//    @Pointcut("execution(* *com.shl.sssssssssssssssss.*(..))")
//    private void pointcut() {
//    }
//
//    // 针对指定的切入点表达式选择的切入点应用前置通知
//    @Before("pointcut()")
//    public void before(JoinPoint joinPoint) {
//        String className = joinPoint.getTarget().getClass().getName();
//        String methodName = joinPoint.getSignature().getName();
//        Object[] args = joinPoint.getArgs();
//        StringBuilder log = new StringBuilder("入参为");
//        for (Object arg : args) {
//            log.append(arg + " ");
//        }
//        logger.debug(className + "的" + methodName + "执行了," + log.toString());
//    }
//
//    // 访问命名切入点来应用后置通知
//    @AfterReturning(value = "pointcut()", returning = "returnVal")
//    public void afterReturn(JoinPoint joinPoint, Object returnVal) {
//        String className = joinPoint.getTarget().getClass().getName();
//        String methodName = joinPoint.getSignature().getName();
//        logger.debug(className + "." + methodName + "()方法正常执行结束, 返回值：" + returnVal);
//    }
//
//    // 应用最终通知
//    @After("pointcut()")
//    public void after(JoinPoint joinPoint) {
//        String className = joinPoint.getTarget().getClass().getName();
//        String methodName = joinPoint.getSignature().getName();
//        logger.info(className + "." + methodName + "()最终执行步骤(finally)...");
//    }
//
//    // 应用异常抛出后通知
//    @AfterThrowing(value = "pointcut()", throwing = "e")
//    public void afterThrowing(JoinPoint joinPoint, Throwable e) {
//        String className = joinPoint.getTarget().getClass().getName();
//        String methodName = joinPoint.getSignature().getName();
//        logger.error(className + "." + methodName + "()方法抛出了异常,异常信息：" + e);
//    }
//
//    // 应用周围通知
//    @Around(value = "pointcut()")
//    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
//        Object result = null;
//        this.before(joinPoint);// 相当于前置通知
//        try {
//            result = joinPoint.proceed();
//            this.afterReturn(joinPoint, result); // 相当于后置通知
//        } catch (Throwable e) {
//            this.afterThrowing(joinPoint, e); // 相当于异常抛出后通知
//            throw e;
//        } finally {
//            this.after(joinPoint); // 相当于最终通知
//        }
//        return result;
//    }
//}
