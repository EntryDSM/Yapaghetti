package kr.hs.entrydsm.yapaghetti.domain.teacher.api.dto.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Getter
@RequiredArgsConstructor
public class StudentDetailResponse {
    private final String name;
    private final Integer gcn;
    private final String email;
    private final String phoneNumber;
    private final String majorTagName;
    private final List<String> mySkillNameList;
}
