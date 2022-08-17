package kr.hs.entrydsm.yapaghetti.global.aop;

import lombok.RequiredArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

@Aspect
@Component
@RequiredArgsConstructor
public class TransactionAspect {

    private final PlatformTransactionManager transactionManager;

    @Pointcut("execution(public * kr.hs.entrydsm.yapaghetti.annotation..*UseCase.*(..))")
    public void getUseCases() {
    }

    @Around("getUseCases()")
    public Object applyTransaction(ProceedingJoinPoint joinPoint) {
        TransactionStatus transaction = transactionManager.getTransaction(new DefaultTransactionDefinition());
        try {
            Object object = joinPoint.proceed();
            transactionManager.commit(transaction);
            return object;
        } catch (Throwable e) {
            e.printStackTrace();
            transactionManager.rollback(transaction);
            return null;
        }
    }
}
