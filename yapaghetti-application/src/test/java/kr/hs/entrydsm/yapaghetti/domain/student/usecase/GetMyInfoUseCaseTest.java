package kr.hs.entrydsm.yapaghetti.domain.student.usecase;

import static org.mockito.BDDMockito.given;

import java.util.List;
import java.util.UUID;
import kr.hs.entrydsm.yapaghetti.domain.my_skill.domain.MySkill;
import kr.hs.entrydsm.yapaghetti.domain.student.domain.Student;
import kr.hs.entrydsm.yapaghetti.domain.student.spi.QueryStudentPort;
import kr.hs.entrydsm.yapaghetti.domain.student.spi.StudentQueryMySkillPort;
import kr.hs.entrydsm.yapaghetti.domain.student.spi.StudentSecurityPort;
import kr.hs.entrydsm.yapaghetti.domain.tag.domain.Tag;
import kr.hs.entrydsm.yapaghetti.domain.tag.spi.QueryTagPort;
import kr.hs.entrydsm.yapaghetti.domain.user.domain.User;
import kr.hs.entrydsm.yapaghetti.domain.user.spi.QueryUserPort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class GetMyInfoUseCaseTest {

	@Mock
	QueryStudentPort queryStudentPort;

	@Mock
	QueryUserPort queryUserPort;

	@Mock
	StudentSecurityPort studentSecurityPort;

	@Mock
	StudentQueryMySkillPort studentQueryMySkillPort;

	@Mock
	QueryTagPort queryTagPort;

	@InjectMocks
	QueryMyInfoUseCase getMyInfoUseCase;

	@Test
	void execute() {
		UUID userId = UUID.randomUUID();
		UUID tagId = UUID.randomUUID();
		String tagName = "tagName";

		given(studentSecurityPort.getCurrentUserId())
			.willReturn(userId);
		given(queryStudentPort.queryUserById(userId))
			.willReturn(
				Student.builder()
					.tagId(tagId)
					.build()
			);
		given(queryUserPort.queryUserById(userId))
			.willReturn(
				User.builder().build()
			);
		given(studentQueryMySkillPort.queryMySkillByUserId(userId))
			.willReturn(
				List.of(MySkill.builder()
				.userId(userId)
				.tagId(tagId)
				.build())
			);
		given(queryTagPort.queryTagById(tagId))
			.willReturn(
				Tag.builder()
				.name(tagName)
				.build()
			);

		getMyInfoUseCase.execute();
	}
}
