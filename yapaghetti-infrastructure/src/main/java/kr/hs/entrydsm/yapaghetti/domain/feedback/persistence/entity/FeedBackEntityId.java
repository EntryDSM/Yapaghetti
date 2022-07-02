package kr.hs.entrydsm.yapaghetti.domain.feedback.persistence.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Getter
@Embeddable
@EqualsAndHashCode
public class FeedBackEntityId implements Serializable {

    @Column(nullable = false)
    private Integer sequence;

    @Column(nullable = false)
    private Long documentId;

}