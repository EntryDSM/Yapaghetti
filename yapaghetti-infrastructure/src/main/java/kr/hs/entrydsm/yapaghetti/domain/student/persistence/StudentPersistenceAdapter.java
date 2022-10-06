package kr.hs.entrydsm.yapaghetti.domain.student.persistence;

import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.List;
import java.util.UUID;
import kr.hs.entrydsm.yapaghetti.domain.company.api.dto.response.StudentElement;
import kr.hs.entrydsm.yapaghetti.domain.document.domain.DocumentType;
import kr.hs.entrydsm.yapaghetti.domain.document.persistence.entity.QDocumentEntity;
import kr.hs.entrydsm.yapaghetti.domain.student.domain.Student;
import kr.hs.entrydsm.yapaghetti.domain.student.exception.StudentNotFoundException;
import kr.hs.entrydsm.yapaghetti.domain.student.mapper.StudentMapper;
import kr.hs.entrydsm.yapaghetti.domain.student.persistence.entity.StudentEntity;
import kr.hs.entrydsm.yapaghetti.domain.student.spi.StudentPort;
import kr.hs.entrydsm.yapaghetti.domain.tag.exception.TagNotFoundException;
import kr.hs.entrydsm.yapaghetti.domain.tag.persistence.TagRepository;
import kr.hs.entrydsm.yapaghetti.domain.tag.persistence.entity.QTagEntity;
import kr.hs.entrydsm.yapaghetti.domain.teacher.api.dto.response.StudentElementByGradeClassNum;
import kr.hs.entrydsm.yapaghetti.domain.teacher.api.dto.response.StudentInformation;
import kr.hs.entrydsm.yapaghetti.global.annotation.Adapter;
import lombok.RequiredArgsConstructor;
import static com.querydsl.core.group.GroupBy.groupBy;
import static com.querydsl.core.group.GroupBy.list;
import static com.querydsl.core.types.Projections.constructor;
import static kr.hs.entrydsm.yapaghetti.domain.document.domain.DocumentType.LOCAL;
import static kr.hs.entrydsm.yapaghetti.domain.document.domain.DocumentType.PUBLIC;
import static kr.hs.entrydsm.yapaghetti.domain.document.domain.DocumentType.STAY;
import static kr.hs.entrydsm.yapaghetti.domain.document.persistence.entity.QDocumentEntity.documentEntity;
import static kr.hs.entrydsm.yapaghetti.domain.feedback.persistence.entity.QFeedbackEntity.feedbackEntity;
import static kr.hs.entrydsm.yapaghetti.domain.my_skill.persistence.entity.QMySkillEntity.mySkillEntity;
import static kr.hs.entrydsm.yapaghetti.domain.student.persistence.entity.QStudentEntity.studentEntity;
import static kr.hs.entrydsm.yapaghetti.domain.user.persistence.entity.QUserEntity.userEntity;

@RequiredArgsConstructor
@Adapter
public class StudentPersistenceAdapter implements StudentPort {

    private final StudentRepository studentRepository;
    private final TagRepository tagRepository;
    private final StudentMapper studentMapper;
    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<StudentElement> findStudentByNameAndMajorAndClassNum(String name, String majorTag, String classNum) {
        QTagEntity QMajorTag = new QTagEntity("majorTag");
        QTagEntity QSkillTag = new QTagEntity("skillTag");

        return jpaQueryFactory
                .from(studentEntity)
                .leftJoin(studentEntity.userEntity, userEntity)
                .leftJoin(studentEntity.tagEntity, QMajorTag)
                .leftJoin(studentEntity.documentList, documentEntity)
                .leftJoin(studentEntity.mySkillList, mySkillEntity)
                .leftJoin(mySkillEntity.tagEntity, QSkillTag)
                .where(documentEntity.type.eq(PUBLIC))
                .leftJoin(mySkillEntity.tagEntity, QSkillTag)
                .where(documentEntity.type.eq(DocumentType.PUBLIC))
                .where(
                        studentEntity.classNum.like(likePreProcessing(classNum))
                                .and(userEntity.name.like(likePreProcessing(name)))
                                .and(QMajorTag.name.like(likePreProcessing(majorTag)))
                )
                .transform(
                        groupBy(studentEntity.userId)
                                .list(
                                        Projections.constructor(
                                                StudentElement.class,
                                                studentEntity.userId,
                                                QMajorTag.name,
                                                list(QSkillTag.name),
                                                userEntity.name,
                                                studentEntity.grade.stringValue(),
                                                studentEntity.classNum.stringValue(),
                                                studentEntity.number,
                                                documentEntity.id,
                                                documentEntity.previewImagePath,
                                                userEntity.profileImagePath
                                        )
                                )
                );

    }

    @Override
    public void saveStudent(Student student) {
        if (!tagRepository.existsById(student.getTagId())) {
            throw TagNotFoundException.EXCEPTION;
        }
        StudentEntity studentEntity = studentMapper.domainToEntity(student);
        studentRepository.save(studentEntity);
    }

    @Override
    public Student queryUserById(UUID id) {
        return studentMapper.entityToDomain(
                getStudentById(id)
        );
    }

    @Override
    public List<StudentElementByGradeClassNum> queryStudentListByGradeAndClassNumAndDocStatus(
            Integer grade, Integer classNum, DocumentType docStatus
    ) {
        QDocumentEntity documentEntity = new QDocumentEntity("documentEntity");
        QDocumentEntity publicDocumentEntity = new QDocumentEntity("publicDocumentEntity");
        QDocumentEntity stayDocumentEntity = new QDocumentEntity("stayDocumentEntity");
        QDocumentEntity localDocumentEntity = new QDocumentEntity("localDocumentEntity");

        return jpaQueryFactory
                .from(studentEntity)
                .where(
                        docTypeEq(docStatus),
                        gradeEq(grade),
                        classNumEq(classNum)
                )
                .orderBy(studentEntity.grade.desc(), studentEntity.classNum.asc(), studentEntity.number.asc())
                .leftJoin(studentEntity.userEntity, userEntity)
                .leftJoin(studentEntity.documentList, documentEntity)
                .leftJoin(studentEntity.documentList, localDocumentEntity).on(localDocumentEntity.type.eq(LOCAL))
                .leftJoin(studentEntity.documentList, publicDocumentEntity).on(publicDocumentEntity.type.eq(PUBLIC))
                .leftJoin(studentEntity.documentList, stayDocumentEntity).on(stayDocumentEntity.type.eq(STAY))
                .leftJoin(stayDocumentEntity.feedbackEntitySet, feedbackEntity)
                .transform(
                        groupBy(studentEntity.userId)
                                .list(
                                        Projections.constructor(
                                                StudentElementByGradeClassNum.class,
                                                studentEntity.userId,
                                                userEntity.name,
                                                userEntity.profileImagePath,
                                                studentEntity.grade.stringValue(),
                                                studentEntity.classNum.stringValue(),
                                                studentEntity.number,
                                                feedbackEntity.isNotNull(),
                                                stayDocumentEntity.isNotNull(),
                                                publicDocumentEntity.isNotNull()
                                        )
                                )
                );
    }

    private BooleanExpression docTypeEq(DocumentType docStatus) {
        return docStatus != null ? documentEntity.type.eq(docStatus) : null;
    }

    private BooleanExpression gradeEq(Integer grade) {
        return grade != null ? studentEntity.grade.eq(grade) : null;
    }

    private BooleanExpression classNumEq(Integer classNum) {
        return classNum != null ? studentEntity.classNum.eq(classNum) : null;
    }


    public StudentInformation queryPersonalAndMajorById(UUID studentId) {
        QTagEntity majorTag = new QTagEntity("majorTag");

        return jpaQueryFactory
                .select(
                        constructor(
                                StudentInformation.class,
                                userEntity.name,
                                studentEntity.grade.stringValue(),
                                studentEntity.classNum.stringValue(),
                                studentEntity.number,
                                userEntity.profileImagePath,
                                userEntity.email,
                                userEntity.phoneNumber,
                                majorTag.name
                        )
                )
                .from(studentEntity)
                .leftJoin(studentEntity.userEntity, userEntity)
                .leftJoin(studentEntity.tagEntity, majorTag)
                .where(
                        studentEntity.userId.eq(studentId)
                )
                .fetchOne();
    }


    @Override
    public void deleteStudent(Student student) {
        studentRepository.delete(
                studentMapper.domainToEntity(student)
        );
    }

    @Override
    public Student queryStudentById(UUID studentId) {
        return studentMapper.entityToDomain(
                getStudentById(studentId)
        );
    }

    @Override
    public boolean existsStudentByTagId(UUID tagId) {
        return studentRepository.existsByTagEntityId(tagId);
    }

    private String likePreProcessing(String value) {
        return "%" + value + "%";
    }

    private StudentEntity getStudentById(UUID studentId) {
        return studentRepository.findById(studentId)
                .orElseThrow(() -> StudentNotFoundException.EXCEPTION);
    }

}
