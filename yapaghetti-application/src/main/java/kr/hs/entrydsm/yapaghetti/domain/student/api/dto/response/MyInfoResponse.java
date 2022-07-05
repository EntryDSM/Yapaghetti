package kr.hs.entrydsm.yapaghetti.domain.student.api.dto.response;

import java.util.List;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MyInfoResponse {

	private final Integer grade;

	private final Integer classNum;

	private final Integer number;

	private final String name;

	private final String phoneNumber;

	private final String email;

	private final String location;

	private final String profileImagePath;

	private final List<String> tagList;

	private final String major;
}
