package kr.hs.entrydsm.yapaghetti.domain.user.api.dto.response;

import kr.hs.entrydsm.yapaghetti.domain.user.domain.UserRole;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class SignInResponse {

    private final boolean firstLogin;
    private final UserRole userType;
    private final String accessToken;
    private final String refreshToken;


}
