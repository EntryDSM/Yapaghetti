package kr.hs.entrydsm.yapaghetti.domain.teacher.presentation.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class WebUpdateCompanyRequest {

    @NotBlank
    @Max(40)
    private String companyName;

    @NotNull
    private LocalDateTime startAt;

    @NotNull
    private LocalDateTime endAt;

}
