package kr.hs.entrydsm.yapaghetti.domain.document.persistence.entity;

import kr.hs.entrydsm.yapaghetti.domain.document.domain.DocumentType;
import kr.hs.entrydsm.yapaghetti.domain.user.persistence.entity.UserEntity;
import kr.hs.entrydsm.yapaghetti.global.entity.BaseUUIDEntity;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.UUID;

@Getter
@SuperBuilder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "tbl_document")
@Entity
public class DocumentEntity extends BaseUUIDEntity {

    @Column(columnDefinition = "VARCHAR(255)", nullable = false)
    private String previewImagePath;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(9)", nullable = false)
    private DocumentType type;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity userEntity;

    public UUID getUserId() {
        return userEntity.getId();
    }

    public void changeDocument(String previewImagePath, String content) {
        this.previewImagePath = previewImagePath;
        this.content = content;
    }

    public void changeDocumentType(DocumentType type) {
        this.type = type;
    }
}
