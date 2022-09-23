package kr.hs.entrydsm.yapaghetti.global.aop;

import java.util.Collections;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.interceptor.MatchAlwaysTransactionAttributeSource;
import org.springframework.transaction.interceptor.RollbackRuleAttribute;
import org.springframework.transaction.interceptor.RuleBasedTransactionAttribute;
import org.springframework.transaction.interceptor.TransactionInterceptor;

@RequiredArgsConstructor
@Configuration
@Aspect
public class TransactionAspect {

    private final TransactionManager transactionManager;
    private final MatchAlwaysTransactionAttributeSource source;
    private final RuleBasedTransactionAttribute transactionAttribute;

    @Bean
    public Advisor transactionAdviceAdvisor() {
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
        pointcut.setExpression("@within(kr.hs.entrydsm.yapaghetti.annotation.UseCase)");

        return new DefaultPointcutAdvisor(pointcut, transactionAdvice());
    }

    @Bean
    public Advisor readOnlyTransactionAdviceAdvisor() {
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
        pointcut.setExpression("@within(kr.hs.entrydsm.yapaghetti.annotation.ReadOnlyUseCase)");

        return new DefaultPointcutAdvisor(pointcut, readOnlyTransactionAdvice());
    }

    @Bean
    public TransactionInterceptor transactionAdvice() {
        transactionAttribute.setName("Transaction");
        transactionAttribute.setRollbackRules(
                Collections.singletonList(new RollbackRuleAttribute(Exception.class))
        );
        source.setTransactionAttribute(transactionAttribute);

        return new TransactionInterceptor(transactionManager, source);
    }

    @Bean
    public TransactionInterceptor readOnlyTransactionAdvice() {
        transactionAttribute.setName("Read-Only Transaction");
        transactionAttribute.setReadOnly(true);
        transactionAttribute.setRollbackRules(
                Collections.singletonList(new RollbackRuleAttribute(Exception.class))
        );
        source.setTransactionAttribute(transactionAttribute);

        return new TransactionInterceptor(transactionManager, source);
    }
}
