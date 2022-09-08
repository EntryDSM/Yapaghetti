package kr.hs.entrydsm.yapaghetti.domain.user.presentation.dto.request;

import kr.hs.entrydsm.yapaghetti.domain.user.domain.UserRole;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@NoArgsConstructor
public class WebSignInRequest {

    @NotBlank
    @Size(min = 5, max = 255)
    private String email;

    @NotBlank
    @Size(max = 20)
    private String password;

    @NotNull
    private UserRole userType;

}
