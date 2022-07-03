package kr.hs.entrydsm.yapaghetti.domain.user.persistence.entity;

import kr.hs.entrydsm.yapaghetti.domain.user.domain.UserRole;
import kr.hs.entrydsm.yapaghetti.global.entity.BaseIDEntity;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import java.util.UUID;

@Getter
@SuperBuilder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "tbl_user")
public class UserEntity extends BaseIDEntity {

    @Column(columnDefinition = "VARCHAR(255)", nullable = false)
    private String email;

    @Column(columnDefinition = "CHAR(60)", nullable = false)
    private String password;

    @Column(columnDefinition = "VARCHAR(10)", nullable = false)
    private String name;

    @Column(columnDefinition = "VARCHAR(255)", nullable = false)
    private String profileImagePath;

    @Column(columnDefinition = "VARCHAR(11)")
    private String phoneNumber;

    @Column(columnDefinition = "VARCHAR(255)", nullable = false)
    private String location;

    @Column(columnDefinition = "BIT(1)", nullable = false)
    private boolean isVisited;

    @Column(columnDefinition = "BINARY(16)", nullable = false)
    private UUID publicId;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(7)", nullable = false)
    private UserRole role;
}
