package kr.hs.entrydsm.yapaghetti.domain.student.usecase;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import kr.hs.entrydsm.yapaghetti.annotation.UseCase;
import kr.hs.entrydsm.yapaghetti.domain.my_skill.spi.QueryMySkillPort;
import kr.hs.entrydsm.yapaghetti.domain.student.api.QueryMyInfoPort;
import kr.hs.entrydsm.yapaghetti.domain.student.api.dto.response.MyInfoResponse;
import kr.hs.entrydsm.yapaghetti.domain.student.domain.Student;
import kr.hs.entrydsm.yapaghetti.domain.student.spi.QueryStudentPort;
import kr.hs.entrydsm.yapaghetti.domain.student.spi.StudentSecurityPort;
import kr.hs.entrydsm.yapaghetti.domain.tag.domain.Tag;
import kr.hs.entrydsm.yapaghetti.domain.tag.spi.QueryTagPort;
import kr.hs.entrydsm.yapaghetti.domain.user.domain.User;
import kr.hs.entrydsm.yapaghetti.domain.user.spi.QueryUserPort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@UseCase
public class QueryMyInfoUseCase implements QueryMyInfoPort {

	private final QueryStudentPort queryStudentPort;
	private final QueryUserPort queryUserPort;
	private final StudentSecurityPort studentSecurityPort;
	private final QueryMySkillPort queryMySkillPort;
	private final QueryTagPort queryTagPort;

	@Override
	public MyInfoResponse execute() {
		UUID userId = studentSecurityPort.getCurrentUserId();

		Student student = queryStudentPort.queryUserById(userId);

		User user = queryUserPort.queryUserById(userId);

		List<String> tagList = queryMySkillPort.queryMySkillByUserId(userId).stream()
			.map(mySkill -> queryTagPort.queryTagById(mySkill.getTagId()))
			.map(Tag::getName)
			.collect(Collectors.toList());

		String major = queryTagPort.queryTagById(student.getTagId()).getName();

		return MyInfoResponse.builder()
			.grade(student.getGrade())
			.classNum(student.getClassNum())
			.number(student.getNumber())
			.name(user.getName())
			.phoneNumber(user.getPhoneNumber())
			.email(user.getEmail())
			.location(user.getLocation())
			.profileImagePath(user.getProfileImagePath())
			.tagList(tagList)
			.major(major)
			.build();
	}
}
