package kr.hs.entrydsm.yapaghetti.domain.student.usecase;

import kr.hs.entrydsm.yapaghetti.domain.my_skill.domain.MySkill;
import kr.hs.entrydsm.yapaghetti.domain.student.api.dto.response.MySkillElement;
import kr.hs.entrydsm.yapaghetti.domain.student.domain.Student;
import kr.hs.entrydsm.yapaghetti.domain.student.spi.QueryStudentPort;
import kr.hs.entrydsm.yapaghetti.domain.student.spi.StudentQueryMySkillPort;
import kr.hs.entrydsm.yapaghetti.domain.student.spi.StudentQueryTagPort;
import kr.hs.entrydsm.yapaghetti.domain.student.spi.StudentQueryUserPort;
import kr.hs.entrydsm.yapaghetti.domain.student.spi.StudentSecurityPort;
import kr.hs.entrydsm.yapaghetti.domain.tag.api.dto.response.TagElement;
import kr.hs.entrydsm.yapaghetti.domain.tag.domain.Tag;
import kr.hs.entrydsm.yapaghetti.domain.user.domain.User;
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
public class GetMyInfoUseCaseTest {

	@Mock
	QueryStudentPort queryStudentPort;

	@Mock
	StudentQueryUserPort studentQueryUserPort;

	@Mock
	StudentSecurityPort studentSecurityPort;

	@Mock
	StudentQueryMySkillPort studentQueryMySkillPort;

	@Mock
	StudentQueryTagPort studentQueryTagPort;

	@InjectMocks
	QueryMyInfoUseCase getMyInfoUseCase;

	@Test
	void execute() {
		UUID userId = UUID.randomUUID();
		UUID tagId = UUID.randomUUID();
		List<MySkillElement> tagElements = new ArrayList<>();
		String tagName = "tagName";

		given(studentSecurityPort.getCurrentUserId())
			.willReturn(userId);
		given(queryStudentPort.queryUserById(userId))
			.willReturn(
				Student.builder()
					.tagId(tagId)
					.build()
			);
		given(studentQueryUserPort.queryUserById(userId))
			.willReturn(
				User.builder().build()
			);
		given(studentQueryMySkillPort.queryTagIdAndNameByUserId(userId))
			.willReturn(
					tagElements
			);
		given(studentQueryTagPort.queryTagById(tagId))
			.willReturn(
				Tag.builder()
				.name(tagName)
				.build()
			);

		getMyInfoUseCase.execute();
	}
}
