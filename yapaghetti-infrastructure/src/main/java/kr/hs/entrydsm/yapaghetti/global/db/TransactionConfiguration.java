package kr.hs.entrydsm.yapaghetti.global.db;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.interceptor.MatchAlwaysTransactionAttributeSource;
import org.springframework.transaction.interceptor.RuleBasedTransactionAttribute;

@Configuration
public class TransactionConfiguration {

    @Bean
    protected MatchAlwaysTransactionAttributeSource transactionAttributeSources() {
        return new MatchAlwaysTransactionAttributeSource();
    }

    @Bean
    protected RuleBasedTransactionAttribute transactionAttributes() {
        return new RuleBasedTransactionAttribute();
    }

}
