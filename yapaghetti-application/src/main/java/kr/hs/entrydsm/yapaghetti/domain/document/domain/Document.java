package kr.hs.entrydsm.yapaghetti.domain.document.domain;

import kr.hs.entrydsm.yapaghetti.annotation.Aggregate;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@Builder
@Aggregate
public class Document {

    private UUID id;

    private String previewImagePath;

    private String content;

    private DocumentType type;

    private UUID userId;
}
