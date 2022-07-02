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
                .publicId(userEntity.getPublicId())
                .role(userEntity.getRole())
                .build();
    }

}
