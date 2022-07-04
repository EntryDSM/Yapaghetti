package kr.hs.entrydsm.yapaghetti.domain.company.presentation;

import kr.hs.entrydsm.yapaghetti.domain.company.api.UpdateCompanyNamePort;
import kr.hs.entrydsm.yapaghetti.domain.company.api.dto.request.DomainUpdateCompanyNameRequest;
import kr.hs.entrydsm.yapaghetti.domain.company.presentation.dto.request.WebUpdateCompanyNameRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequiredArgsConstructor
@RequestMapping("/companies")
@RestController
public class CompanyWebAdapter {

    private final UpdateCompanyNamePort updateCompanyNamePort;

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PatchMapping("/name")
    public void updateCompanyName(@Valid WebUpdateCompanyNameRequest request) {
        updateCompanyNamePort.execute(
                new DomainUpdateCompanyNameRequest(request.getCompanyName())
        );
    }

}
