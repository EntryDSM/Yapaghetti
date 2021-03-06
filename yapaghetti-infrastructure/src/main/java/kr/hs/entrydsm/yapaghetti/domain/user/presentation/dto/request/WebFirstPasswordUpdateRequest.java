package kr.hs.entrydsm.yapaghetti.domain.user.presentation.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Getter
@NoArgsConstructor
public class WebFirstPasswordUpdateRequest {

    //TODO Password Length
    @NotBlank
    private String password;

    @NotBlank
    private String newPassword;

}
