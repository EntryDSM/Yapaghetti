package kr.hs.entrydsm.yapaghetti.domain.teacher.presentation;

import kr.hs.entrydsm.yapaghetti.domain.teacher.api.CreateFeedBackPort;
import kr.hs.entrydsm.yapaghetti.domain.teacher.api.dto.request.DomainCreateFeedBackRequest;
import kr.hs.entrydsm.yapaghetti.domain.teacher.presentation.dto.request.WebCreateFeedBackRequest;
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
public class TeacherWebAdapter {

    private final CreateFeedBackPort createFeedBackPort;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/feedback/{student-id}")
    public void createFeedBack(@PathVariable("student-id") UUID studentId,
                               @RequestBody @Valid WebCreateFeedBackRequest webCreateFeedBackRequest) {
        createFeedBackPort.createFeedBack(
                DomainCreateFeedBackRequest.builder()
                        .studentId(studentId)
                        .sequence(webCreateFeedBackRequest.getSequence())
                        .comment(webCreateFeedBackRequest.getContent())
                        .build()
        );
    }

}
