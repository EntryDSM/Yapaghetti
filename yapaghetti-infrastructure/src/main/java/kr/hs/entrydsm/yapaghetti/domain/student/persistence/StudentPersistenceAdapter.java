package kr.hs.entrydsm.yapaghetti.domain.student.persistence;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import kr.hs.entrydsm.yapaghetti.domain.company.api.dto.response.StudentElement;
import kr.hs.entrydsm.yapaghetti.domain.document.domain.DocumentType;
import kr.hs.entrydsm.yapaghetti.domain.student.domain.Student;
import kr.hs.entrydsm.yapaghetti.domain.student.exception.StudentNotFoundException;
import kr.hs.entrydsm.yapaghetti.domain.student.mapper.StudentMapper;
import kr.hs.entrydsm.yapaghetti.domain.student.spi.StudentPort;
import kr.hs.entrydsm.yapaghetti.domain.tag.persistence.entity.QTagEntity;
import kr.hs.entrydsm.yapaghetti.global.annotation.Adapter;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.UUID;

import static com.querydsl.core.group.GroupBy.groupBy;
import static com.querydsl.core.group.GroupBy.list;
import static kr.hs.entrydsm.yapaghetti.domain.document.persistence.entity.QDocumentEntity.documentEntity;
import static kr.hs.entrydsm.yapaghetti.domain.my_skill.persistence.entity.QMySkillEntity.mySkillEntity;
import static kr.hs.entrydsm.yapaghetti.domain.student.persistence.entity.QStudentEntity.studentEntity;
import static kr.hs.entrydsm.yapaghetti.domain.user.persistence.entity.QUserEntity.userEntity;

@RequiredArgsConstructor
@Adapter
public class StudentPersistenceAdapter implements StudentPort {

    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;
    private final JPAQueryFactory jpaQueryFactory;

    public boolean existsByTagId(UUID tagId) {
        return studentRepository.existsByTagEntityId(tagId);
    }

    @Override
    public List<StudentElement> findStudentByNameAndMajorAndClassNum(String name, String major, String classNum) {
        QTagEntity majorTag = new QTagEntity("majorTag");
        QTagEntity skillTag = new QTagEntity("skillTag");

        return jpaQueryFactory
                .from(studentEntity)
                .leftJoin(studentEntity.userEntity, userEntity)
                .leftJoin(studentEntity.tagEntity, majorTag)
                .leftJoin(studentEntity.documentList, documentEntity)
                .leftJoin(studentEntity.mySkillList, mySkillEntity)
                .leftJoin(mySkillEntity.tagEntity, skillTag)
                .where(documentEntity.type.eq(DocumentType.PUBLIC))
                .where(
                        studentEntity.classNum.like(likePreProcessing(classNum))
                                .and(userEntity.name.like(likePreProcessing(name)))
                                .and(majorTag.name.like(likePreProcessing(major)))
                )
                .transform(
                        groupBy(studentEntity.userId)
                                .list(
                                        Projections.constructor(
                                                StudentElement.class,
                                                studentEntity.userId,
                                                majorTag.name,
                                                list(skillTag.name),
                                                userEntity.name,
                                                studentEntity.grade.stringValue(),
                                                studentEntity.classNum.stringValue(),
                                                studentEntity.number,
                                                documentEntity.previewImagePath,
                                                userEntity.profileImagePath
                                        )
                                )
                );

    }

    

    @Override
    public void saveStudent(Student student) {
        studentRepository.save(studentMapper.domainToEntity(student));
    }

    @Override
    public Student queryUserById(UUID id) {
        return studentMapper.entityToDomain(
                studentRepository.findById(id)
                        .orElseThrow(() -> StudentNotFoundException.EXCEPTION)
        );
    }

	public boolean existsByTagId(UUID tagId) {
		return studentRepository.existsByTagEntityId(tagId);
	}

	@Override
	public void saveStudent(Student student) {
		studentRepository.save(studentMapper.domainToEntity(student));
	}

	@Override
	public Student queryUserById(UUID id) {
		return studentMapper.entityToDomain(
			studentRepository.findById(id)
				.orElseThrow(() -> StudentNotFoundException.EXCEPTION)
		);
	}

	@Override
	public void deleteStudent(Student student) {
		studentRepository.delete(
				studentMapper.domainToEntity(student)
		);
	}
  
  private String likePreProcessing(String value) {
        return "%" + value + "%";
    }
}
