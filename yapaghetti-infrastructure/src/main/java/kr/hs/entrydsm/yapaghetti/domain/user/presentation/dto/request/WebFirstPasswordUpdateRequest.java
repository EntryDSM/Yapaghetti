package kr.hs.entrydsm.yapaghetti.domain.user.presentation.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@NoArgsConstructor
public class WebFirstPasswordUpdateRequest {


    @NotBlank
    @Size(max = 20)
    private String password;

    @NotBlank
    @Size(max = 20)
    private String newPassword;

}
