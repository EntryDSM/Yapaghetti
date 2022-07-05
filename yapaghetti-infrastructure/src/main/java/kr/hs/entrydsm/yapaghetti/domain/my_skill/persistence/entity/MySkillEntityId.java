package kr.hs.entrydsm.yapaghetti.domain.my_skill.persistence.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.UUID;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode
@Embeddable
public class MySkillEntityId implements Serializable {

    @Column(nullable = false)
    private UUID userId;

    @Column(nullable = false)
    private UUID tagId;

}
