package kr.hs.entrydsm.yapaghetti.domain.teacher.presentation.dto.request;

import kr.hs.entrydsm.yapaghetti.domain.user.domain.UserRole;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class WebCreateCompanyRequest {

    @NotBlank
    @Size(min = 2, max = 10)
    private String name;

    @NotBlank
    @Size(min = 6, max = 255)
    private String email;

    @NotBlank
    @Size(min = 11, max = 11)
    private String phoneNumber;

    @NotBlank
    @Size(min = 2, max = 255)
    private String location;

    @NotBlank
    @Size(min = 2, max = 255)
    private String profileImagePath;

    @NotBlank
    @Size(min = 2 , max = 40)
    private String companyName;

    @NotNull
    private Boolean isMou;

    @NotNull
    private LocalDateTime startAt;

    @NotNull
    private LocalDateTime endAt;
}
