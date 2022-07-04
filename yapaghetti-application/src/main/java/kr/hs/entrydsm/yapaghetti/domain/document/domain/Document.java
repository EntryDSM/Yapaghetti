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

    private final UUID userId;
}
