package kr.hs.entrydsm.yapaghetti.domain.user.presentation.dto.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Getter
@NoArgsConstructor
public class WebUpdateUserInformationRequest {

    @NotBlank
    @Size(max = 255)
    private String location;

    @NotBlank
    @Size(max = 10)
    private String name;

    @NotBlank
    @Size(max = 11)
    private String phoneNumber;

    @NotBlank
    @Size(max = 255)
    private String profileImagePath;

}
