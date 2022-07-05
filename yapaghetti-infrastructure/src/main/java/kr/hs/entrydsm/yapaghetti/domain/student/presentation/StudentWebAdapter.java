package kr.hs.entrydsm.yapaghetti.domain.student.presentation;

import kr.hs.entrydsm.yapaghetti.domain.student.api.GetMyInfoPort;
import kr.hs.entrydsm.yapaghetti.domain.student.api.dto.response.MyInfoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/students")
@RestController
public class StudentWebAdapter {

	private final GetMyInfoPort getMyInfoPort;

	@GetMapping
	public MyInfoResponse queryMyInfo() {
		return getMyInfoPort.execute();
	}
}
