package kr.hs.entrydsm.yapaghetti.domain.company.presentation.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@NoArgsConstructor
public class WebUpdateCompanyInformationRequest {

    @NotBlank
    @Size(max = 40)
    private String companyName;

    @NotBlank
    @Size(max = 255)
    private String location;

    @NotBlank
    @Size(max = 255)
    private String profileImagePath;

    @NotBlank
    @Size(max = 10)
    private String name;

    @NotBlank
    @Size(max = 11)
    private String phoneNumber;

}
