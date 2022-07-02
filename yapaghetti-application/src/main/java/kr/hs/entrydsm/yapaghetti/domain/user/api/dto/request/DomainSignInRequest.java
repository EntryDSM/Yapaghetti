package kr.hs.entrydsm.yapaghetti.domain.user.api.dto.request;

import kr.hs.entrydsm.yapaghetti.domain.user.domain.UserRole;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class DomainSignInRequest {

    private final String email;
    private final String password;
    private final UserRole userType;

}
