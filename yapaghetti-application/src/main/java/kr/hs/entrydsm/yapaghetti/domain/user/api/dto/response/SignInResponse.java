package kr.hs.entrydsm.yapaghetti.domain.user.api.dto.response;

import kr.hs.entrydsm.yapaghetti.domain.user.domain.UserRole;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SignInResponse {

    private final boolean firstLogin;
    private final UserRole userType;
    private final String accessToken;
    private final String refreshToken;


}
