package kr.hs.entrydsm.yapaghetti.domain.user.api;

import kr.hs.entrydsm.yapaghetti.domain.user.api.dto.request.DomainFirstPasswordUpdateRequest;

public interface FirstPasswordUpdatePort {
    void firstPasswordUpdate(DomainFirstPasswordUpdateRequest request);
}
