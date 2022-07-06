package kr.hs.entrydsm.yapaghetti.domain.tag.usecase;

import kr.hs.entrydsm.yapaghetti.domain.my_skill.domain.MySkill;
import kr.hs.entrydsm.yapaghetti.domain.tag.api.dto.request.DomainAddMySkillRequest;
import kr.hs.entrydsm.yapaghetti.domain.tag.spi.TagCommandMySkillPort;
import kr.hs.entrydsm.yapaghetti.domain.tag.spi.TagSecurityPort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class AddMySkillUseCaseTest {

    @Mock
    TagSecurityPort tagSecurityPort;

    @Mock
    TagCommandMySkillPort tagCommandMySkillPort;

    @InjectMocks
    AddMySkillUseCase addMySkillUseCase;

    @Mock
    DomainAddMySkillRequest request;

    @Test
    void 기술태그_설정() {
        UUID userId = UUID.randomUUID();

        given(tagSecurityPort.getCurrentUserId()).willReturn(userId);

        List<MySkill> mySkills = new ArrayList<>();
        mySkills.add(
                MySkill.builder()
                        .userId(userId)
                        .tagId(UUID.randomUUID())
                        .build()
        );

        tagCommandMySkillPort.deleteAllMySKillByUserId(userId);
        tagCommandMySkillPort.saveAllMySkill(mySkills);

        addMySkillUseCase.execute(request);
    }

}
