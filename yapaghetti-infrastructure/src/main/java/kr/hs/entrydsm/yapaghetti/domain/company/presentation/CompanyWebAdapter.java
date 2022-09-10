package kr.hs.entrydsm.yapaghetti.domain.company.presentation;

import kr.hs.entrydsm.yapaghetti.domain.company.api.QueryStudentListPort;
import kr.hs.entrydsm.yapaghetti.domain.company.api.UpdateCompanyNamePort;
import kr.hs.entrydsm.yapaghetti.domain.company.api.dto.request.DomainUpdateCompanyNameRequest;
import kr.hs.entrydsm.yapaghetti.domain.company.api.dto.request.DomainQueryStudentListRequest;
import kr.hs.entrydsm.yapaghetti.domain.company.api.dto.response.QueryStudentListResponse;
import kr.hs.entrydsm.yapaghetti.domain.company.presentation.dto.request.WebUpdateCompanyInformationRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequiredArgsConstructor
@RequestMapping("/companies")
@RestController
public class CompanyWebAdapter {

    private final UpdateCompanyNamePort updateCompanyNamePort;
    private final QueryStudentListPort queryStudentListPort;

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PatchMapping("/information")
    public void updateCompanyInformation(@RequestBody @Valid WebUpdateCompanyInformationRequest request) {
        updateCompanyNamePort.execute(
                DomainUpdateCompanyNameRequest.builder()
                        .companyName(request.getCompanyName())
                        .location(request.getLocation())
                        .profileImagePath(request.getProfileImagePath())
                        .name(request.getName())
                        .phoneNumber(request.getPhoneNumber())
                        .build()
        );
    }

    @GetMapping("/students")
    public QueryStudentListResponse queryStudentList(@ModelAttribute DomainQueryStudentListRequest request) {
        return queryStudentListPort.execute(request);
    }

}
