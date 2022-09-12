package kr.hs.entrydsm.yapaghetti.domain.auth.presentation.dto.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class SendPhoneNumberAuthCodeRequest {

	@NotBlank
	@Size(min = 11, max = 11)
	private String phoneNumber;
}
