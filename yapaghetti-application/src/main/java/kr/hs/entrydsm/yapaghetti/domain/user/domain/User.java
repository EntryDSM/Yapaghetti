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
        return User.builder()
                .id(this.id)
                .email(this.email)
                .password(password)
                .name(this.name)
                .profileImagePath(this.profileImagePath)
                .phoneNumber(this.phoneNumber)
                .location(this.location)
                .isVisited(true)
                .publicId(this.publicId)
                .role(this.role)
                .build();
    }

}
