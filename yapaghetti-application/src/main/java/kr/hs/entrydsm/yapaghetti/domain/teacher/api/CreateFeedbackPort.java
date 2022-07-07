package kr.hs.entrydsm.yapaghetti.domain.teacher.api;

import kr.hs.entrydsm.yapaghetti.domain.teacher.api.dto.request.DomainCreateFeedbackRequest;

public interface CreateFeedbackPort {

    void execute(DomainCreateFeedbackRequest request);

}
