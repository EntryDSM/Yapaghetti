package kr.hs.entrydsm.yapaghetti.domain.student.presentation.dto.request;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class WebUpdateMyInfoRequest {

	@NotBlank
	private String value;
}
