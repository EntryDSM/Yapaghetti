package kr.hs.entrydsm.yapaghetti.domain.teacher.presentation;

import kr.hs.entrydsm.yapaghetti.domain.teacher.api.CreateFeedbackPort;
import kr.hs.entrydsm.yapaghetti.domain.teacher.api.DeleteCompanyPort;
import kr.hs.entrydsm.yapaghetti.domain.teacher.api.DeleteStudentPort;
import kr.hs.entrydsm.yapaghetti.domain.teacher.api.GetStudentDetailPort;
import kr.hs.entrydsm.yapaghetti.domain.teacher.api.dto.request.DomainCreateFeedbackRequest;
import kr.hs.entrydsm.yapaghetti.domain.teacher.api.dto.response.StudentDetailResponse;
import kr.hs.entrydsm.yapaghetti.domain.teacher.presentation.dto.request.WebCreateFeedbackRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.UUID;

@RequiredArgsConstructor
@RequestMapping("/teachers")
@RestController
public class TeacherWebAdapter {

    private final CreateFeedbackPort createFeedbackPort;
    private final GetStudentDetailPort getStudentDetailPort;
    private final DeleteStudentPort deleteStudentPort;
    private final DeleteCompanyPort deleteCompanyPort;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/feedback/{student-id}")
    public void createFeedback(@PathVariable("student-id") @NotBlank UUID studentId,
                               @RequestBody @Valid WebCreateFeedbackRequest request) {
        createFeedbackPort.execute(
                DomainCreateFeedbackRequest.builder()
                        .studentId(studentId)
                        .sequence(request.getSequence())
                        .comment(request.getComment())
                        .build()
        );
    }

    @GetMapping("/student/{student-id}")
    public StudentDetailResponse getStudentDetail(@PathVariable("student-id") @NotBlank UUID studentId) {
        return getStudentDetailPort.execute(studentId);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/student/{student-id}")
    public void deleteStudent(@PathVariable("student-id") @NotBlank UUID studentId) {
        deleteStudentPort.execute(studentId);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/company/{company-id}")
    public void deleteCompany(@PathVariable("company-id") @NotBlank UUID companyId) {
        deleteCompanyPort.execute(companyId);
    }
}
