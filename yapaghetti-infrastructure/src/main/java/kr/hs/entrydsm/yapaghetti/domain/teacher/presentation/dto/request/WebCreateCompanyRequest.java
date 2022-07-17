package kr.hs.entrydsm.yapaghetti.domain.teacher.presentation.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class WebCreateCompanyRequest {

    @NotBlank
    @Max(10)
    private String name;

    @NotBlank
    @Max(255)
    private String email;

    @NotBlank
    @Max(11)
    private String phoneNumber;

    @NotBlank
    @Max(255)
    private String location;

    @NotBlank
    @Max(255)
    private String profileImagePath;

    @NotBlank
    @Max(40)
    private String companyName;

    @NotNull
    private LocalDateTime startAt;

    @NotNull
    private LocalDateTime endAt;
}
