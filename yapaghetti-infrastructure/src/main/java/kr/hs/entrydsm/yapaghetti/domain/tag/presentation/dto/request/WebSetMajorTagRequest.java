package kr.hs.entrydsm.yapaghetti.domain.tag.presentation.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
@NoArgsConstructor
public class WebSetMajorTagRequest {
    private UUID tagId;
}
