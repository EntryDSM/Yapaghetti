package kr.hs.entrydsm.yapaghetti.domain.user.api.dto.request;

import kr.hs.entrydsm.yapaghetti.domain.user.domain.UserRole;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DomainSignInRequest {

    private final String email;
    private final String password;
    private final UserRole userType;

}
