package kr.hs.entrydsm.yapaghetti.domain.student.domain;

import kr.hs.entrydsm.yapaghetti.annotation.Aggregate;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

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