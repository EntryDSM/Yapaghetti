package kr.hs.entrydsm.yapaghetti.domain.tag.usecase;

import kr.hs.entrydsm.yapaghetti.domain.my_skill.domain.MySkill;
import kr.hs.entrydsm.yapaghetti.domain.my_skill.spi.CommandMySkillPort;
import kr.hs.entrydsm.yapaghetti.domain.tag.api.dto.request.DomainAddMySkillRequest;
import kr.hs.entrydsm.yapaghetti.domain.user.spi.UserSecurityPort;
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
    UserSecurityPort userSecurityPort;

    @Mock
    CommandMySkillPort commandMySkillPort;

    @InjectMocks
    AddMySkillUseCase addMySkillUseCase;

    @Mock
    DomainAddMySkillRequest request;

    @Test
    void 기술태그_설정() {
        UUID userId = UUID.randomUUID();

        given(userSecurityPort.getCurrentUserId()).willReturn(userId);

        List<MySkill> mySkills = new ArrayList<>();
        mySkills.add(
                MySkill.builder()
                        .userId(userId)
                        .tagId(UUID.randomUUID())
                        .build()
        );

        commandMySkillPort.saveAllMySkill(mySkills);

        addMySkillUseCase.execute(request);
    }

}
