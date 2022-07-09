package kr.hs.entrydsm.yapaghetti.domain.document.api.dto.response;

import kr.hs.entrydsm.yapaghetti.domain.tag.domain.TagType;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@Builder
public class DocumentElement {

    private final UUID documentId;

    private final String previewImagePath;

    private final String name;

    private final String major;
}
