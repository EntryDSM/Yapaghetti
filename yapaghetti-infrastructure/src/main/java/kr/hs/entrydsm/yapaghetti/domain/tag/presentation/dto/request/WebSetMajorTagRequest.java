package kr.hs.entrydsm.yapaghetti.domain.tag.presentation.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.util.UUID;

@Getter
@NoArgsConstructor
public class WebSetMajorTagRequest {

    @NotBlank
    private UUID tagId;

}
