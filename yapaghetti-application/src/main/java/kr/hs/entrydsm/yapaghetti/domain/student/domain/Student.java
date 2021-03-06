package kr.hs.entrydsm.yapaghetti.domain.student.domain;

import java.util.UUID;
import kr.hs.entrydsm.yapaghetti.annotation.Aggregate;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@Aggregate
public class Student {

	private final UUID userId;

	private final Integer grade;

	private final Integer classNum;

	private final Integer number;

	private final UUID tagId;

	public Student updateTagId(UUID tagId) {
		return Student.builder()
				.userId(this.userId)
				.grade(this.grade)
				.classNum(this.classNum)
				.number(this.number)
				.tagId(tagId)
				.build();
	}

}