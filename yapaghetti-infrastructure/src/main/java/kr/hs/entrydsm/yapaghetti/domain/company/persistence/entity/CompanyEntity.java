package kr.hs.entrydsm.yapaghetti.domain.company.persistence.entity;

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
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Table(name = "tbl_company")
@Entity
public class CompanyEntity {

	@Id
	private Long userId;

	@MapsId
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private UserEntity user;

	@Column(columnDefinition = "VARCHAR(40)", nullable = false)
	private String companyName;
}
