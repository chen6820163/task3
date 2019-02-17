package com.jnshu.task3.common.aop;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

/**
 * @program: task3
 * @description: 日志切面类 把这个类声明为一个切面:首先需要把该类放入到IOC容器中，通过注解@Component,再声明为一个切面,通过注解@Aspect, 并且在配置文件中加入配置通过Order注解来指定切面的优先级，优先级数字越小代表优先级越高,越先执行
 * @author: Mr.Chen
 * @create: 2018-12-24 17:40
 * @contact:938738637@qq.com
 **/
@Aspect
@Component
public class LoggingAspect {
    private static Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);

    // 一定时间打印 执行方法统计信息
    private static final long ONE_MINUTE = 10000;

    @Around(value = "execution(* com.jnshu.task3.web.*.*(..)) || execution(* com.jnshu.task3.service.interfaces.*.*(..)) ")

    public Object log(ProceedingJoinPoint joinPoint) throws Throwable {

        // 定义返回对象、得到方法需要的参数
        Object obj = null;
        Object[] args = joinPoint.getArgs();
        long startTime = System.currentTimeMillis();

        try {
            obj = joinPoint.proceed(args);
        } catch (Throwable e) {
            logger.error("统计某方法执行耗时环绕通知出错", e);
        }
        // 获取执行的方法名
        long endTime = System.currentTimeMillis();
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        String methodName = signature.getDeclaringTypeName() + "." + signature.getName();

        // 打印耗时的信息
        this.printExecTime(methodName, startTime, endTime);
        return obj;
    }

    /**
     * 打印方法执行耗时的信息，如果超过了一定的时间，才打印
     *
     * @param methodName 方法名
     * @param startTime  开始时间
     * @param endTime    结束时间
     */
    private void printExecTime(String methodName, long startTime, long endTime) {
        long diffTime = endTime - startTime;
        logger.info("*****" + methodName + " 方法执行耗时：" + diffTime + " ms");
        if (diffTime > ONE_MINUTE) {
            logger.warn("*****" + methodName + " 方法执行耗时：" + diffTime + " ms");
        }
    }
}
