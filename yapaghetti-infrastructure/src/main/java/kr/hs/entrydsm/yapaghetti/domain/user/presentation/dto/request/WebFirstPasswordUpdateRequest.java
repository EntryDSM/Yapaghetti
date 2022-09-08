package kr.hs.entrydsm.yapaghetti.domain.user.presentation.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@NoArgsConstructor
public class WebFirstPasswordUpdateRequest {


    @NotBlank
    @Size(max = 20)
    private String password;

    @NotBlank
    @Size(max = 20)
    @Pattern(regexp = "(?=.*[a-z])(?=.*[0-9])(?=.*[!#$%&'()*+,./:;<=>?@＼^_`{|}~])[a-zA-Z0-9!#$%&'()*+,./:;<=>?@＼^_`{|}~]{8,32}$",
            message = "password는 소문자, 숫자, 특수문자가 포함되어야 합니다.")
    private String newPassword;

}
