package kr.hs.entrydsm.yapaghetti.domain.student.presentation;

import javax.validation.Valid;
import kr.hs.entrydsm.yapaghetti.domain.student.api.BetaCreateUserPort;
import kr.hs.entrydsm.yapaghetti.domain.student.api.QueryMyInfoPort;
import kr.hs.entrydsm.yapaghetti.domain.student.api.ReflectFeedbackPort;
import kr.hs.entrydsm.yapaghetti.domain.student.api.UpdateMyInfoPort;
import kr.hs.entrydsm.yapaghetti.domain.student.api.dto.response.BetaCreateUserResponse;
import kr.hs.entrydsm.yapaghetti.domain.student.api.dto.response.MyInfoResponse;
import kr.hs.entrydsm.yapaghetti.domain.student.domain.UpdateType;
import kr.hs.entrydsm.yapaghetti.domain.student.presentation.dto.request.BetaCreateStudentRequest;
import kr.hs.entrydsm.yapaghetti.domain.student.presentation.dto.request.WebUpdateMyInfoRequest;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/students")
@RestController
public class StudentWebAdapter {

	private final QueryMyInfoPort queryMyInfoPort;
	private final ReflectFeedbackPort reflectFeedbackPort;
	private final UpdateMyInfoPort updateMyInfoPort;
	private final BetaCreateUserPort betaCreateUserPort;

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
	@PatchMapping()
	public void updateMyInfo(@RequestBody @Valid WebUpdateMyInfoRequest request, @RequestParam @NonNull UpdateType type) {
		updateMyInfoPort.execute(request.getValue(), type);
	}

	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/beta")
	public BetaCreateUserResponse betaCreateStudent(@RequestBody @Valid BetaCreateStudentRequest request) {
		return betaCreateUserPort.execute(request.getEmail(), request.getClassNum(), request.getNumber(),
			request.getName(), request.getPhoneNumber());
	}
}
