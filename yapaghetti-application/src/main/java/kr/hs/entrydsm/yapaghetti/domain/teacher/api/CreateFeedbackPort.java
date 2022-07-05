package kr.hs.entrydsm.yapaghetti.domain.teacher.api;


import kr.hs.entrydsm.yapaghetti.domain.teacher.api.dto.request.DomainCreateFeedbackRequest;

public interface CreateFeedbackPort {

    void createFeedback(DomainCreateFeedbackRequest request);

}
