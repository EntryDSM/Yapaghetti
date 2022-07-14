package kr.hs.entrydsm.yapaghetti.domain.teacher.presentation;

import kr.hs.entrydsm.yapaghetti.domain.teacher.api.CreateCompanyPort;
import kr.hs.entrydsm.yapaghetti.domain.teacher.api.CreateFeedbackPort;
import kr.hs.entrydsm.yapaghetti.domain.teacher.api.DeleteCompanyPort;
import kr.hs.entrydsm.yapaghetti.domain.teacher.api.DeleteStudentPort;
import kr.hs.entrydsm.yapaghetti.domain.teacher.api.UpdateCompanyPort;
import kr.hs.entrydsm.yapaghetti.domain.teacher.api.dto.request.DomainUpdateCompanyRequest;
import kr.hs.entrydsm.yapaghetti.domain.teacher.api.QueryStudentDetailPort;
import kr.hs.entrydsm.yapaghetti.domain.teacher.api.QueryCompanyListPort;
import kr.hs.entrydsm.yapaghetti.domain.teacher.api.dto.response.CompanyListResponse;
import kr.hs.entrydsm.yapaghetti.domain.teacher.api.GetCompanyDetailPort;
import kr.hs.entrydsm.yapaghetti.domain.teacher.api.ChangeCompanyPasswordPort;
import kr.hs.entrydsm.yapaghetti.domain.teacher.api.dto.response.StudentDetailResponse;
import kr.hs.entrydsm.yapaghetti.domain.teacher.api.dto.request.DomainCreateFeedbackRequest;
import kr.hs.entrydsm.yapaghetti.domain.teacher.api.dto.request.DomainNewCompanyRequest;
import kr.hs.entrydsm.yapaghetti.domain.teacher.api.dto.response.CompanyDetailResponse;
import kr.hs.entrydsm.yapaghetti.domain.teacher.api.dto.response.NewCompanyResponse;
import kr.hs.entrydsm.yapaghetti.domain.teacher.presentation.dto.request.WebCreateCompanyRequest;
import kr.hs.entrydsm.yapaghetti.domain.teacher.api.dto.response.ChangeCompanyPasswordResponse;
import kr.hs.entrydsm.yapaghetti.domain.teacher.presentation.dto.request.WebCreateFeedbackRequest;
import kr.hs.entrydsm.yapaghetti.domain.teacher.presentation.dto.request.WebUpdateCompanyRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    private final DeleteStudentPort deleteStudentPort;
    private final CreateCompanyPort createCompanyPort;
    private final UpdateCompanyPort updateCompanyPort;
    private final GetCompanyDetailPort getCompanyDetailPort;
    private final DeleteCompanyPort deleteCompanyPort;
    private final ChangeCompanyPasswordPort changeCompanyPasswordPort;
    private final QueryStudentDetailPort queryStudentDetailPort;
    private final QueryCompanyListPort queryCompanyListPort;

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
    public StudentDetailResponse queryStudentDetail(@PathVariable("student-id") @NotBlank UUID studentId) {
        return queryStudentDetailPort.execute(studentId);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/student/{student-id}")
    public void deleteStudent(@PathVariable("student-id") @NotBlank UUID studentId) {
        deleteStudentPort.execute(studentId);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/company")
    public NewCompanyResponse createCompany(@RequestBody @Valid WebCreateCompanyRequest request) {
        return createCompanyPort.execute(
                DomainNewCompanyRequest.builder()
                        .name(request.getName())
                        .email(request.getEmail())
                        .phoneNumber(request.getPhoneNumber())
                        .location(request.getLocation())
                        .profileImagePath(request.getProfileImagePath())
                        .companyName(request.getCompanyName())
                        .startAt(request.getStartAt())
                        .endAt(request.getEndAt())
                        .build()
        );
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PostMapping("/company/{company-id}")
    public void deleteCompany(@PathVariable("company-id") @NotBlank UUID companyId) {
        deleteCompanyPort.execute(companyId);
    }

    @GetMapping("/company/search")
    public CompanyListResponse queryCompanyList(@RequestParam("name") String name) {
        return queryCompanyListPort.execute(name);
    }

    @GetMapping("/company/{company-id}")
    public CompanyDetailResponse getCompanyDetail(@PathVariable("company-id") @NotBlank UUID companyId) {
        return getCompanyDetailPort.execute(companyId);
    }

    @PatchMapping("/company/change/{company-id}")
    public ChangeCompanyPasswordResponse changeCompanyPassword(@PathVariable("company-id") @NotBlank UUID companyId) {
        return changeCompanyPasswordPort.execute(companyId);
    }

    @PatchMapping("/company/{company-id}")
    public void updateCompany(@PathVariable("company-id") @NotBlank UUID companyId,
                              @RequestBody @Valid WebUpdateCompanyRequest request) {
        updateCompanyPort.execute(
                DomainUpdateCompanyRequest.builder()
                        .companyId(companyId)
                        .companyName(request.getCompanyName())
                        .startAt(request.getStartAt())
                        .endAt(request.getEndAt())
                        .build()
        );
    }
}