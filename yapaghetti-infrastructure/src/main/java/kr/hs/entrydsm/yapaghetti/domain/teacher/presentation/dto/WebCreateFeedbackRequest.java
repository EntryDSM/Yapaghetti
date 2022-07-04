package kr.hs.entrydsm.yapaghetti.domain.teacher.presentation.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Getter
@NoArgsConstructor
public class WebCreateFeedbackRequest {

    @NotBlank
    private Integer sequence;

    @NotBlank
    private String content;
}
