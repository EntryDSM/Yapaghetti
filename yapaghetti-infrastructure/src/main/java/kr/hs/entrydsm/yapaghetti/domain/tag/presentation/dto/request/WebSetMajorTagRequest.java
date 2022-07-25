package kr.hs.entrydsm.yapaghetti.domain.tag.presentation.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@NoArgsConstructor
public class WebSetMajorTagRequest {

    @NotNull
    private UUID tagId;

}
