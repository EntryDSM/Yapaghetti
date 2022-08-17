package kr.hs.entrydsm.yapaghetti.global.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Aspect
@Component
public class TransactionAspect {

    @Pointcut("annotation(kr.hs.entrydsm.yapaghetti.annotation.UseCase)")
    public void applyTransaction() {
        transaction();
    }

    @Transactional
    protected void transaction() { }
}
