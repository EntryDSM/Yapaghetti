package kr.hs.entrydsm.yapaghetti.domain.teacher.presentation.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class WebUpdateCompanyRequest {

    @NotBlank
    private String companyName;

    @NotBlank
    private String location;

    @NotBlank
    private String phoneNumber;

    @NotBlank
    private String name;

    @NotBlank
    private String email;

    @NotBlank
    private LocalDateTime startAt;

    @NotBlank
    private LocalDateTime endAt;

}
