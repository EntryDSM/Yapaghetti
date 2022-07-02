package kr.hs.entrydsm.yapaghetti.domain.user.persistence;

import com.querydsl.jpa.impl.JPAQueryFactory;
import kr.hs.entrydsm.yapaghetti.domain.user.domain.User;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

public class UserQuerydslImpl extends QuerydslRepositorySupport implements UserQuerydslExtension {

    private final JPAQueryFactory jpaQueryFactory;

    public UserQuerydslImpl(JPAQueryFactory jpaQueryFactory) {
        super(User.class);
        this.jpaQueryFactory = jpaQueryFactory;
    }
    
}
