package kr.hs.entrydsm.yapaghetti.domain.teacher.api.dto.response;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class StudentDetailResponse {
    private final String name;
    private final Integer gcn;
    private final String email;
    private final String phoneNumber;
    private final String majorTagName;
    private final List<String> mySkillNameList;
}
