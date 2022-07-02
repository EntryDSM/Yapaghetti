package kr.hs.entrydsm.yapaghetti.domain.user.persistence;

import kr.hs.entrydsm.yapaghetti.domain.user.domain.User;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

public class UserQuerydslImpl extends QuerydslRepositorySupport implements UserQuerydslExtension {

    public UserQuerydslImpl() {
        super(User.class);
    }
    
}
