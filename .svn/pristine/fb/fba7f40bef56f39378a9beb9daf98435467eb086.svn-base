package com.soholy.dogmanager.common.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

/**
 * @ClassName GlobalLogAspect
 * @Description TODO(全局日志切面)
 * @author guanY
 * @Date 2018年4月9日 下午6:43:53
 * @version 1.0.0
 */
public class GlobalLogConfiguration {

    private static Logger logger = Logger.getLogger(GlobalLogConfiguration.class);

    // 前置通知
    public void before(JoinPoint joinPoint) {
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        StringBuilder log = new StringBuilder("入参为");
        for (Object arg : args) {
            log.append(arg + " ");
        }
        logger.debug(className + "的" + methodName + "执行了," + log.toString());
    }

    // 后置通知
    public void afterReturn(JoinPoint joinPoint, Object returnVal) {
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        logger.debug(className + "." + methodName + "()方法正常执行结束, 返回值：" + returnVal);
    }

    // 最终通知
    public void after(JoinPoint joinPoint) {
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        logger.info(className + "." + methodName + "()最终执行步骤(finally)...");
    }

    // 异常通知
    public void afterThrowing(JoinPoint joinPoint, Throwable e) {
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        logger.error(className + "." + methodName + "()方法抛出了异常,异常信息：" + e);
    }

    // 周围通知
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
        Object result = null;
        this.before(joinPoint);// 相当于前置通知
        try {
            result = joinPoint.proceed();
            this.afterReturn(joinPoint, result); // 相当于后置通知
        } catch (Throwable e) {
            this.afterThrowing(joinPoint, e); // 相当于异常抛出后通知
            throw e;
        } finally {
            this.after(joinPoint); // 相当于最终通知
        }
        return result;
    }
}
