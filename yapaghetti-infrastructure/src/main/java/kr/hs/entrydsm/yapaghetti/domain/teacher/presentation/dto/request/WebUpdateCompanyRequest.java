package kr.hs.entrydsm.yapaghetti.domain.teacher.presentation.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class WebUpdateCompanyRequest {

    @NotBlank
    @Size(max = 40, message = "40자 이하로 수정 부탁드립니다.")
    private String companyName;

    @NotBlank
    @Size(max = 255, message = "255자 이하로 수정 부탁드립니다.")
    private String location;

    @NotBlank
    @Size(max = 11, message = "-를 제외한 숫자로만 11자로 수정 부탁드립니다.")
    private String phoneNumber;

    @NotBlank
    @Size(max = 10, message = "10자 이하로 수정 부탁드립니다")
    private String name;

    @NotBlank
    @Size(max = 255, message = "255자 이하로 수정 부탁드립니다")
    private String email;

    @NotBlank
    private LocalDateTime startAt;

    @NotBlank
    private LocalDateTime endAt;

}
