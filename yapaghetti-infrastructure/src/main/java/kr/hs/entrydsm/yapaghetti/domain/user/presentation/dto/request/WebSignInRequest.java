package kr.hs.entrydsm.yapaghetti.domain.user.presentation.dto.request;

import kr.hs.entrydsm.yapaghetti.domain.user.domain.UserRole;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
public class WebSignInRequest {

    @NotNull
    private String email;

    @NotNull
    private String password;

    @NotNull
    private UserRole userType;

}
