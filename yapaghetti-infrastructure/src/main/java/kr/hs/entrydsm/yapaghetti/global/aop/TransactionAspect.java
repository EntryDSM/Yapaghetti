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

import java.util.concurrent.atomic.AtomicInteger;

@Aspect
@Component
@RequiredArgsConstructor
public class TransactionAspect {

    private final PlatformTransactionManager transactionManager;

    @Pointcut("@annotation(kr.hs.entrydsm.yapaghetti.annotation.UseCase)")
    public void getUseCases() {
    }

    @Pointcut("@annotation(kr.hs.entrydsm.yapaghetti.annotation.ReadOnlyUseCase)")
    public void getReadOnlyUseCases() {
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

    @Around("getReadOnlyUseCases()")
    public Object applyReadOnlyTransaction(ProceedingJoinPoint joinPoint) {
        try {
            ThreadLocal.withInitial(() -> new AtomicInteger(0)).get().incrementAndGet();
            return joinPoint.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
            return null;
        } finally {
            ThreadLocal.withInitial(() -> new AtomicInteger(0)).get().decrementAndGet();
        }
    }
}
