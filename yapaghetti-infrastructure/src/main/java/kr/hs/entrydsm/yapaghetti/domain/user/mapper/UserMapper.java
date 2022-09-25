package kr.hs.entrydsm.yapaghetti.domain.user.mapper;

import kr.hs.entrydsm.yapaghetti.domain.user.domain.User;
import kr.hs.entrydsm.yapaghetti.domain.user.persistence.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User entityToDomain(UserEntity userEntity) {
        return User.builder()
                .id(userEntity.getId())
                .email(userEntity.getEmail())
                .password(userEntity.getPassword())
                .name(userEntity.getName())
                .profileImagePath(userEntity.getProfileImagePath())
                .phoneNumber(userEntity.getPhoneNumber())
                .location(userEntity.getLocation())
                .isVisited(userEntity.isVisited())
                .role(userEntity.getRole())
                .build();
    }

    public UserEntity domainToEntity(User user) {
        return UserEntity.builder()
                .id(user.getId())
                .email(user.getEmail())
                .password(user.getPassword())
                .name(user.getName())
                .profileImagePath(user.getProfileImagePath())
                .phoneNumber(user.getPhoneNumber())
                .location(user.getLocation())
                .role(user.getRole())
                .isVisited(user.isVisited())
                .build();

    }

}
