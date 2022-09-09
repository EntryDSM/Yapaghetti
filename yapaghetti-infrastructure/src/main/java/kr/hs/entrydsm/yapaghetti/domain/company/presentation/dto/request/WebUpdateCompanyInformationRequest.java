package kr.hs.entrydsm.yapaghetti.domain.company.presentation.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Getter
@NoArgsConstructor
public class WebUpdateCompanyInformationRequest {

    @NotBlank
    private String companyName;

    @NotBlank
    private String location;

    @NotBlank
    private String profileImagePath;

    @NotBlank
    private String name;

    @NotBlank
    private String phoneNumber;

}
