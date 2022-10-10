package kr.hs.entrydsm.yapaghetti.domain.teacher.api;

import kr.hs.entrydsm.yapaghetti.domain.teacher.api.dto.request.DomainDeleteFeedbackRequest;

public interface DeleteFeedbackPort {

    void execute(DomainDeleteFeedbackRequest request);

}
