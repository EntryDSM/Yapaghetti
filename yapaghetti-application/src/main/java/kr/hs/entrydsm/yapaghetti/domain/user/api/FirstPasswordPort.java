package kr.hs.entrydsm.yapaghetti.domain.user.api;

import kr.hs.entrydsm.yapaghetti.domain.user.api.dto.request.DomainFirstPasswordRequest;

public interface FirstPasswordPort {
    void firstPassword(DomainFirstPasswordRequest request);
}
