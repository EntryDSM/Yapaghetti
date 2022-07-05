package kr.hs.entrydsm.yapaghetti.domain.user.api;

import kr.hs.entrydsm.yapaghetti.domain.user.api.dto.request.DomainUpdateUserInformationRequest;

public interface UpdateUserInformationPort {
    void execute(DomainUpdateUserInformationRequest request);
}
