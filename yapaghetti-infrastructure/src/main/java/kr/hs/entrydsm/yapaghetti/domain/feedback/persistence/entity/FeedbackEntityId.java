package kr.hs.entrydsm.yapaghetti.domain.feedback.persistence.entity;

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
@Embeddable
@EqualsAndHashCode
public class FeedbackEntityId implements Serializable {

    @Column(nullable = false)
    private Integer sequence;

    @Column(nullable = false)
    private UUID documentId;

}
