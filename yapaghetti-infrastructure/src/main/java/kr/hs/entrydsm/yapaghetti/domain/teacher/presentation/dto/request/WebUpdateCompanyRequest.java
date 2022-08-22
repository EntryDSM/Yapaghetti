package kr.hs.entrydsm.yapaghetti.domain.teacher.presentation.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class WebUpdateCompanyRequest {

    @NotBlank
    @Size(min = 2, max = 10)
    private String name;

    @NotBlank
    @Size(min = 5, max = 255)
    private String email;

    @NotBlank
    @Size(min = 11, max = 11)
    private String phoneNumber;

    @NotBlank
    @Size(min = 5, max = 255)
    private String location;

    @NotBlank
    @Size(min = 1, max = 40)
    private String companyName;

    @NotNull
    private LocalDateTime startAt;

    @NotNull
    private LocalDateTime endAt;

}
