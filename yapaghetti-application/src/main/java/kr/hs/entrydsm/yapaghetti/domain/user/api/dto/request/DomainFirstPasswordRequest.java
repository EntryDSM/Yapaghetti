package kr.hs.entrydsm.yapaghetti.domain.user.api.dto.request;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class DomainFirstPasswordRequest {

    private final String password;
    private final String newPassword;

}
