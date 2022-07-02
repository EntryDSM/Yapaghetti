package kr.hs.entrydsm.yapaghetti.domain.user.domain;

import kr.hs.entrydsm.yapaghetti.annotation.Aggregate;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Aggregate
@Getter
@Builder
public class User {

    private final Long id;

    private final String email;

    private final String password;

    private final String name;

    private final String profileImagePath;

    private final String phoneNumber;

    private final String location;

    private final boolean isVisited;

    private final UUID publicId;

    private final UserRole role;
    
    public User setUserPasswordAndVisitedTrue(String password) {
        return new User (
                this.id,
                this.email,
                password,
                this.name,
                this.profileImagePath,
                this.phoneNumber,
                this.location,
                true,
                this.publicId,
                this.role
        );
    }

}
