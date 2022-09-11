package kr.hs.entrydsm.yapaghetti.domain.student.presentation.dto.request;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NonNull;

@Getter
@NonNull
public class WebUpdateMyInfoRequest {

	@NotBlank
	private String value;
}
