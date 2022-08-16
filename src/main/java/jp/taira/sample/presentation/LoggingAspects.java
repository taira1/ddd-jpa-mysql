package jp.taira.sample.presentation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j2;

/**
 * コントローラ境界ログクラス
 */
@Aspect
@Component
@Log4j2
public class LoggingAspects {

    private static final String ENTER = "[ENTER] ";
    private static final String ERROR = "[ERROR] ";
    private static final String EXIT = "[EXIT] ";

    /**
     * コントローラのメソッドのENTERログを出力する
     *
     * @param joinPoint
     */
    @Before("execution(* jp.isols.skate.presentation.controller..*.*(..))")
    public void invokeControllerBefore(JoinPoint joinPoint) {
        log.info(ENTER + getSignatureName(joinPoint));
    }

    /**
     * コントローラのメソッドのEXITログを出力する
     *
     * @param joinPoint
     * @param returnValue
     */
    @AfterReturning(pointcut = "execution(* jp.isols.skate.presentation.controller..*.*(..))", returning = "returnValue")
    public void invokeControllerAfterReturning(JoinPoint joinPoint, Object returnValue) {
        log.info(EXIT + getSignatureName(joinPoint));
    }

    /**
     * コントローラのメソッドのERRORログを出力する
     *
     * @param joinPoint
     * @param e
     */
    @AfterThrowing(value = "execution(* jp.isols.skate.presentation.controller..*.*(..))", throwing = "e")
    public void invokeControllerAfterThrowing(JoinPoint joinPoint, Throwable e) {
        log.info(ERROR + getSignatureName(joinPoint));
    }

    /**
     * メソッド名を取得する
     *
     * @param joinPoint
     * @return
     */
    private String getSignatureName(JoinPoint joinPoint) {
        return joinPoint.getTarget().getClass().getSimpleName() + " " + joinPoint.getSignature().getName() + " routing. ";
    }
}
