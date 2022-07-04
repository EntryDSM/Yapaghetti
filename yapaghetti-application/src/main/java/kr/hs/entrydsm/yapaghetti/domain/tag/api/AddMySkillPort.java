package kr.hs.entrydsm.yapaghetti.domain.tag.api;

import kr.hs.entrydsm.yapaghetti.domain.tag.api.dto.request.DomainAddMySkillRequest;

public interface AddMySkillPort {
    void execute(DomainAddMySkillRequest request);
}
