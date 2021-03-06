package kr.hs.entrydsm.yapaghetti.domain.feedback.persistence.entity;

import kr.hs.entrydsm.yapaghetti.domain.document.persistence.entity.DocumentEntity;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "tbl_feedback")
@Entity
public class FeedbackEntity {

    @EmbeddedId
    private FeedbackEntityId id;

    @MapsId("documentId")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "document_id", nullable = false, columnDefinition = "BINARY(16)")
    private DocumentEntity documentEntity;

    @Column(columnDefinition = "VARCHAR(255)", nullable = false)
    private String comment;

    @Column(columnDefinition = "BIT(1)", nullable = false)
    private Boolean isApply;

    public UUID getDocumentId() {
        return documentEntity.getId();
    }
}
