package kr.hs.entrydsm.yapaghetti.domain.document.domain;

import kr.hs.entrydsm.yapaghetti.annotation.Aggregate;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@Builder
@Aggregate
public class Document {

    private final UUID id;

    private final String previewImagePath;

    private final String content;

    private final DocumentType type;

    private final Boolean isRejected;

    private final UUID userId;

    public Document changeDocumentType(DocumentType type) {
        return Document.builder()
                .id(this.id)
                .previewImagePath(this.previewImagePath)
                .content(this.content)
                .type(type)
                .userId(this.userId)
                .isRejected(false)
                .build();
    }

    public Document updateDocumentPreviewAndContent(String previewImagePath, String content) {
        return Document.builder()
                .id(this.id)
                .previewImagePath(previewImagePath)
                .content(content)
                .type(this.type)
                .userId(this.userId)
                .isRejected(this.getIsRejected())
                .build();
    }

    public Document reject() {
        return Document.builder()
                .id(this.id)
                .previewImagePath(this.previewImagePath)
                .content(this.content)
                .type(type)
                .userId(this.userId)
                .isRejected(true)
                .build();
    }
}
