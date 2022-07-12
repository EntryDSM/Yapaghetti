package kr.hs.entrydsm.yapaghetti.domain.student.presentation;

import javax.validation.constraints.NotBlank;
import kr.hs.entrydsm.yapaghetti.domain.student.api.QueryMyInfoPort;
import kr.hs.entrydsm.yapaghetti.domain.student.api.ReflectFeedbackPort;
import kr.hs.entrydsm.yapaghetti.domain.student.api.dto.response.MyInfoResponse;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/students")
@RestController
public class StudentWebAdapter {

	private final QueryMyInfoPort queryMyInfoPort;
	private final ReflectFeedbackPort reflectFeedbackPort;

	@GetMapping
	public MyInfoResponse queryMyInfo() {
		return queryMyInfoPort.execute();
	}

	@ResponseStatus(HttpStatus.NO_CONTENT)
	@PatchMapping("/feedback/{sequence}")
	public void reflectFeedback(@PathVariable("sequence") @NonNull Integer sequence) {
		reflectFeedbackPort.execute(sequence);
	}

	@ResponseStatus(HttpStatus.NO_CONTENT)
	@PatchMapping("/phone-number")
	public void setPhoneNumber(@ResponseBody @NotBlank String phoneNumber) {

	}
}
