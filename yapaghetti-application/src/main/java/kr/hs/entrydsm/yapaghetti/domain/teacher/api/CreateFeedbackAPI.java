package kr.hs.entrydsm.yapaghetti.domain.teacher.api;

import kr.hs.entrydsm.yapaghetti.domain.teacher.api.dto.request.DomainCreateFeedbackRequest;

public interface CreateFeedbackAPI {
    void createFeedback(DomainCreateFeedbackRequest domainCreateFeedbackRequest);
}
