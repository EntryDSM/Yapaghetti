package kr.hs.entrydsm.yapaghetti.domain.user.presentation.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

@Getter
@NoArgsConstructor
public class WebUpdateUserInformationRequest {

    @NotBlank
    @Length(max = 255, message = "주소는 최대 255자 이내로 입력해주세요.")
    private String location;

    @NotBlank
    @Length(max = 10, message = "이름은 10자 이내로 입력해주세요.")
    private String name;

    @NotBlank
    @Length(max = 11, message = "전화번호는 11자 이내로 입력해주세요.")
    private String phoneNumber;

    @NotBlank
    @Length(max = 255, message = "프로필 이미지 경로는 255자 이내로 입력해주세요.")
    private String profileImagePath;

}
