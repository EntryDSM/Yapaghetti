package kr.hs.entrydsm.yapaghetti.domain.teacher.presentation;

import kr.hs.entrydsm.yapaghetti.domain.teacher.api.CreateFeedbackPort;
import kr.hs.entrydsm.yapaghetti.domain.teacher.api.dto.request.DomainCreateFeedbackRequest;
import kr.hs.entrydsm.yapaghetti.domain.teacher.presentation.dto.WebCreateFeedbackRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.UUID;


@RequiredArgsConstructor
@RequestMapping("/teachers")
@RestController
public class CreateFeedbackWepAdapter {

    private final CreateFeedbackPort createFeedbackAPI;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/feedback/{student-id}")
    public void createFeedback(@PathVariable("student-id") UUID studentId,
                               @RequestBody @Valid WebCreateFeedbackRequest webCreateFeedBackRequest) {
        createFeedbackAPI.createFeedback(
                DomainCreateFeedbackRequest
                        .builder()
                            .studentId(studentId)
                            .sequence(webCreateFeedBackRequest.getSequence())
                            .content(webCreateFeedBackRequest.getContent())
                        .build()
        );
    }
}
