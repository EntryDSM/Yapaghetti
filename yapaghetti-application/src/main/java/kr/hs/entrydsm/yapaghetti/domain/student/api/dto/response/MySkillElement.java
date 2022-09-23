package kr.hs.entrydsm.yapaghetti.domain.student.api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@Getter
@AllArgsConstructor
public class MySkillElement {
    private final UUID id;
    private final String name;
}
