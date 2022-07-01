package kr.hs.entrydsm.yapaghetti.domain.user.persistence.entity;

import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import kr.hs.entrydsm.yapaghetti.domain.user.domain.UserRole;
import kr.hs.entrydsm.yapaghetti.global.entity.BaseIDEntity;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Entity(name = "tbl_user")
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
	@Column(length = 7, nullable = false)
	private UserRole role;
}
