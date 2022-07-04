package kr.hs.entrydsm.yapaghetti.domain.feedback.persistence.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.UUID;

@Getter
@SuperBuilder
@NoArgsConstructor
@Embeddable
@EqualsAndHashCode
public class FeedBackEntityId implements Serializable {

    @Column(nullable = false)
    private Integer sequence;

    @Column(nullable = false)
    private UUID documentId;

}
