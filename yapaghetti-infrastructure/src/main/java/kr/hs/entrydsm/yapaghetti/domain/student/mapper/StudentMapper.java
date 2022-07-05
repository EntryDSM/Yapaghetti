package kr.hs.entrydsm.yapaghetti.domain.student.mapper;

import kr.hs.entrydsm.yapaghetti.domain.student.domain.Student;
import kr.hs.entrydsm.yapaghetti.domain.student.persistence.entity.StudentEntity;
import kr.hs.entrydsm.yapaghetti.domain.tag.exception.TagNotFoundException;
import kr.hs.entrydsm.yapaghetti.domain.tag.persistence.TagPersistenceAdapter;
import kr.hs.entrydsm.yapaghetti.domain.tag.persistence.entity.TagEntity;
import kr.hs.entrydsm.yapaghetti.domain.user.exception.UserNotFoundException;
import kr.hs.entrydsm.yapaghetti.domain.user.persistence.UserPersistenceAdapter;
import kr.hs.entrydsm.yapaghetti.domain.user.persistence.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class StudentMapper {

	private final UserPersistenceAdapter userPersistenceAdapter;
	private final TagPersistenceAdapter tagPersistenceAdapter;

	public Student entityToDomain(StudentEntity studentEntity) {
		return Student.builder()
			.userId(studentEntity.getUserId())
			.grade(studentEntity.getGrade())
			.classNum(studentEntity.getClassNum())
			.number(studentEntity.getNumber())
			.tagId(studentEntity.getTagId())
			.build();
	}

	public StudentEntity domainToEntity(Student student) {
		UserEntity userEntity = userPersistenceAdapter.findUserById(student.getUserId())
			.orElseThrow(() -> UserNotFoundException.EXCEPTION);

		TagEntity tagEntity = tagPersistenceAdapter.findTagById(student.getTagId())
			.orElseThrow(() -> TagNotFoundException.EXCEPTION);

		return StudentEntity.builder()
			.userEntity(userEntity)
			.grade(student.getGrade())
			.classNum(student.getClassNum())
			.number(student.getNumber())
			.tagEntity(tagEntity)
			.build();
	}
}
