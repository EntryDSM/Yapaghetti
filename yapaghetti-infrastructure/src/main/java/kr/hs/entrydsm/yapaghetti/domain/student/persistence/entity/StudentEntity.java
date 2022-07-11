package kr.hs.entrydsm.yapaghetti.domain.student.persistence.entity;

import kr.hs.entrydsm.yapaghetti.domain.document.persistence.entity.DocumentEntity;
import kr.hs.entrydsm.yapaghetti.domain.my_skill.persistence.entity.MySkillEntity;
import kr.hs.entrydsm.yapaghetti.domain.tag.persistence.entity.TagEntity;
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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Table(name = "tbl_student")
@Entity
public class StudentEntity {

    @Id
    private UUID userId;

    @MapsId
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", columnDefinition = "BINARY(16)")
    private UserEntity userEntity;

    @Column(columnDefinition = "TINYINT", nullable = false)
    private Integer grade;

    @Column(columnDefinition = "TINYINT", nullable = false)
    private Integer classNum;

    @Column(columnDefinition = "TINYINT", nullable = false)
    private Integer number;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "major_tag_id")
    private TagEntity tagEntity;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "userEntity")
    private Set<DocumentEntity> documentList = new HashSet<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "userEntity")
    private Set<MySkillEntity> mySkillList = new HashSet<>();

    public UUID getTagId() {
        return tagEntity.getId();
    }

}
