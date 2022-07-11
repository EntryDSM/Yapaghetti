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

    @NotBlank
    @Max(255)
    private String location;

    @NotBlank
    @Max(11)
    private String phoneNumber;

    @NotBlank
    @Max(10)
    private String name;

    @NotBlank
    @Max(255)
    private String email;

    @NotNull
    private LocalDateTime startAt;

    @NotNull
    private LocalDateTime endAt;

}
