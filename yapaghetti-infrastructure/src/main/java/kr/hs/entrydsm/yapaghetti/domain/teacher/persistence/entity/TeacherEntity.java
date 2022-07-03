package kr.hs.entrydsm.yapaghetti.domain.teacher.persistence.entity;

import kr.hs.entrydsm.yapaghetti.domain.user.persistence.entity.UserEntity;

import javax.persistence.*;

import lombok.AccessLevel;

import lombok.Getter;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.UUID;


@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name = "tbl_teacher")
public class TeacherEntity {

    @Id
    private UUID userId;

    @MapsId
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserEntity userEntity;

}
