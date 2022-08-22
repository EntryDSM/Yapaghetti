package kr.hs.entrydsm.yapaghetti.domain.teacher.presentation.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@NoArgsConstructor
public class WebCreateFeedbackRequest {

    @NotNull
    private Integer sequence;

    @NotBlank
    @Size(min = 3, max = 255)
    private String comment;
}
