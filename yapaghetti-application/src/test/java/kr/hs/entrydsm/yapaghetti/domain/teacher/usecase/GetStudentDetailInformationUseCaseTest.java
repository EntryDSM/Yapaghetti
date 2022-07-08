package kr.hs.entrydsm.yapaghetti.domain.teacher.usecase;

import kr.hs.entrydsm.yapaghetti.domain.student.domain.Student;
import kr.hs.entrydsm.yapaghetti.domain.tag.domain.Tag;
import kr.hs.entrydsm.yapaghetti.domain.tag.domain.TagType;
import kr.hs.entrydsm.yapaghetti.domain.teacher.spi.TeacherQueryMySkillPort;
import kr.hs.entrydsm.yapaghetti.domain.teacher.spi.TeacherQueryStudentPort;
import kr.hs.entrydsm.yapaghetti.domain.teacher.spi.TeacherQueryTagPort;
import kr.hs.entrydsm.yapaghetti.domain.teacher.spi.TeacherQueryUserPort;
import kr.hs.entrydsm.yapaghetti.domain.user.domain.User;
import kr.hs.entrydsm.yapaghetti.domain.user.domain.UserRole;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.BDDMockito.given;

import java.util.UUID;

@ExtendWith(MockitoExtension.class)
public class GetStudentDetailInformationUseCaseTest {

    @Mock
    TeacherQueryStudentPort teacherQueryStudentPort;

    @Mock
    TeacherQueryUserPort teacherQueryUserPort;

    @Mock
    TeacherQueryTagPort teacherQueryTagPort;

    @Mock
    TeacherQueryMySkillPort teacherQueryMySkillPort;

    @InjectMocks
    GetStudentDetailInformationUseCase getStudentDetailInformationUseCase;

    @Test
    public void execute() {
        UUID userId = UUID.randomUUID();
        UUID studentId = UUID.randomUUID();
        UUID tagId = UUID.randomUUID();

        given(teacherQueryStudentPort.queryUserById(studentId))
                .willReturn(
                        Student.builder()
                                .userId(userId)
                                .tagId(tagId)
                                .grade(2)
                                .classNum(1)
                                .number(1)
                                .build()
                    );

        given(teacherQueryUserPort.queryUserById(userId))
                .willReturn(
                        User.builder()
                                .id(userId)
                                .role(UserRole.STUDENT)
                                .build()
                );

        given(teacherQueryTagPort.queryMajorTagById(tagId))
                .willReturn(
                        Tag.builder()
                                .id(tagId)
                                .name("백엔드")
                                .type(TagType.MAJOR)
                            .build()
                );

        getStudentDetailInformationUseCase.execute(studentId);

    }

}
