package kr.hs.entrydsm.yapaghetti.domain.company.presentation.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Getter
@NoArgsConstructor
public class WebUpdateCompanyNameRequest {

    @NotBlank
    private String companyName;

}
