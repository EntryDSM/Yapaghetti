package kr.hs.entrydsm.yapaghetti.domain.user.domain;

import kr.hs.entrydsm.yapaghetti.annotation.Aggregate;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@Builder
@Aggregate
public class User {

    private final UUID id;

    private final String email;

    private final String password;

    private final String name;

    private final String profileImagePath;

    private final String phoneNumber;

    private final String location;

    private final boolean isVisited;

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
                .role(this.role)
                .build();
    }

    public User setInformation(String location, String name, String phoneNumber, String profileImagePath) {
        return User.builder()
                .id(this.id)
                .email(this.email)
                .password(this.password)
                .name(name)
                .profileImagePath(profileImagePath)
                .phoneNumber(phoneNumber)
                .location(location)
                .isVisited(this.isVisited)
                .role(this.role)
                .build();
    }

    public User setPhoneNumber(String phoneNumber) {
        return User.builder()
                .id(this.id)
                .email(this.email)
                .password(this.password)
                .name(this.name)
                .profileImagePath(this.profileImagePath)
                .phoneNumber(phoneNumber)
                .location(this.location)
                .isVisited(this.isVisited)
                .role(this.role)
                .build();
    }

    public User setPassword(String password) {
        return User.builder()
                .id(this.id)
                .email(this.email)
                .password(password)
                .name(this.name)
                .profileImagePath(this.profileImagePath)
                .phoneNumber(this.phoneNumber)
                .location(this.location)
                .isVisited(this.isVisited)
                .role(this.role)
                .build();
    }

    public User updatePassword(String password) {
        return User.builder()
                .id(this.id)
                .email(this.email)
                .password(password)
                .name(this.name)
                .profileImagePath(this.profileImagePath)
                .phoneNumber(this.phoneNumber)
                .location(this.location)
                .isVisited(this.isVisited)
                .role(this.role)
                .build();
    }

    public User updateInformation(String name, String email, String phoneNumber, String location, String profileImagePath, UserRole role) {
        return User.builder()
                .id(this.id)
                .email(email)
                .password(this.password)
                .name(name)
                .profileImagePath(profileImagePath)
                .phoneNumber(phoneNumber)
                .location(location)
                .isVisited(this.isVisited)
                .role(role)
                .build();
    }

}
