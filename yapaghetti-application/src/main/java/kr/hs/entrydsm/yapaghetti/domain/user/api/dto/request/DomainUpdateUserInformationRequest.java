package kr.hs.entrydsm.yapaghetti.domain.user.api.dto.request;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class DomainUpdateUserInformationRequest {

    private final String location;
    private final String name;
    private final String phoneNumber;
    private final String profileImagePath;

}
