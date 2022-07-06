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
    @Size(max = 255, message = "255자 이하로 작성 부탁드립니다.")
    private String comment;
}
