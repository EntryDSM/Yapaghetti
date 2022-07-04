package kr.hs.entrydsm.yapaghetti.domain.student.domain;

import java.util.UUID;
import kr.hs.entrydsm.yapaghetti.annotation.Aggregate;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@Aggregate
public class Student {

	private UUID userId;

	private Integer grade;

	private Integer classNum;

	private Integer number;

	private UUID tagId;

}