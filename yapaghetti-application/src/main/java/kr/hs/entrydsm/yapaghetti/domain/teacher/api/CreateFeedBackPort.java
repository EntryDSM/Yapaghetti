package kr.hs.entrydsm.yapaghetti.domain.teacher.api;

import kr.hs.entrydsm.yapaghetti.domain.teacher.api.dto.request.DomainCreateFeedBackRequest;

public interface CreateFeedBackPort {
    void createFeedBack(DomainCreateFeedBackRequest domainCreateFeedBackRequest);
}
