package kr.hs.entrydsm.yapaghetti.domain.user.presentation.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;

@Getter
@NoArgsConstructor
public class WebUpdateUserInformationRequest {

    @NotBlank
    @Max(value = 255)
    private String location;

    @NotBlank
    @Max(value = 10)
    private String name;

    @NotBlank
    @Max(value = 11)
    private String phoneNumber;

    @NotBlank
    @Max(value = 255)
    private String profileImagePath;

}
