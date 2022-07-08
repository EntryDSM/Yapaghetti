package kr.hs.entrydsm.yapaghetti.domain.company.persistence.entity;

import javax.persistence.OneToOne;
import kr.hs.entrydsm.yapaghetti.domain.user.persistence.entity.UserEntity;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Table(name = "tbl_company")
@Entity
public class CompanyEntity {

	@Id
	private UUID userId;

	@MapsId
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", columnDefinition = "BINARY(16)")
	private UserEntity userEntity;

	@Column(columnDefinition = "VARCHAR(40)", nullable = false)
	private String companyName;

	@Column(columnDefinition = "DATETIME", nullable = false)
	private LocalDateTime startAt;

	@Column(columnDefinition = "DATETIME", nullable = false)
	private LocalDateTime endAt;
}
