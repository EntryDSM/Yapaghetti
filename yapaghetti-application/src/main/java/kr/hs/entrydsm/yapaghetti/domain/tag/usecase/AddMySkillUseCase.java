package kr.hs.entrydsm.yapaghetti.domain.tag.usecase;

import kr.hs.entrydsm.yapaghetti.annotation.UseCase;
import kr.hs.entrydsm.yapaghetti.domain.my_skill.domain.MySkill;
import kr.hs.entrydsm.yapaghetti.domain.my_skill.spi.CommandMySkillPort;
import kr.hs.entrydsm.yapaghetti.domain.tag.api.AddMySkillPort;
import kr.hs.entrydsm.yapaghetti.domain.tag.api.dto.request.DomainAddMySkillRequest;
import kr.hs.entrydsm.yapaghetti.domain.user.spi.UserSecurityPort;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@UseCase
public class AddMySkillUseCase implements AddMySkillPort {

    private final UserSecurityPort userSecurityPort;

    private final CommandMySkillPort commandMySkillPort;

    @Override
    public void execute(DomainAddMySkillRequest request) {
        UUID userId = userSecurityPort.getCurrentUserId();

        commandMySkillPort.deleteAllMySKillByUserId(userId);

        List<MySkill> mySkills = request.getTagList().stream()
                .map(tagId -> MySkill.builder()
                                .tagId(tagId)
                                .userId(userId)
                                .build()
                ).collect(Collectors.toList());

        commandMySkillPort.saveAllMySkill(mySkills);
    }

}
