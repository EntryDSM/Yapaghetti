package kr.hs.entrydsm.yapaghetti.domain.user.persistence;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class UserQuerydslImpl implements UserQuerydslExtension {

    private final JPAQueryFactory jpaQueryFactory;

}
