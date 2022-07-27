package kr.hs.entrydsm.yapaghetti.domain.tag.usecase;

import kr.hs.entrydsm.yapaghetti.annotation.UseCase;
import kr.hs.entrydsm.yapaghetti.domain.my_skill.domain.MySkill;
import kr.hs.entrydsm.yapaghetti.domain.tag.api.AddMySkillPort;
import kr.hs.entrydsm.yapaghetti.domain.tag.api.dto.request.DomainAddMySkillRequest;
import kr.hs.entrydsm.yapaghetti.domain.tag.spi.TagCommandMySkillPort;
import kr.hs.entrydsm.yapaghetti.domain.tag.spi.TagSecurityPort;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@UseCase
public class AddMySkillUseCase implements AddMySkillPort {

    private final TagSecurityPort tagSecurityPort;

    private final TagCommandMySkillPort tagCommandMySkillPort;

    @Override
    public void execute(DomainAddMySkillRequest request) {
        UUID userId = tagSecurityPort.getCurrentUserId();

        tagCommandMySkillPort.deleteAllMySKillByUserId(userId);

        List<MySkill> mySkills = request.getTagList().stream()
                .map(tagId -> MySkill.builder()
                        .tagId(tagId)
                        .userId(userId)
                        .build()
                ).collect(Collectors.toList());

        tagCommandMySkillPort.saveAllMySkill(mySkills);
    }

}
