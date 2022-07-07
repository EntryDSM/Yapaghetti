package kr.hs.entrydsm.yapaghetti.domain.teacher.usecase;

import kr.hs.entrydsm.yapaghetti.domain.student.domain.Student;
import kr.hs.entrydsm.yapaghetti.domain.student.exception.StudentNotFoundException;
import kr.hs.entrydsm.yapaghetti.domain.student.spi.StudentPort;
import kr.hs.entrydsm.yapaghetti.domain.teacher.spi.TeacherCommandStudentPort;
import kr.hs.entrydsm.yapaghetti.domain.teacher.spi.TeacherQueryStudentPort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;

import static org.mockito.BDDMockito.given;

import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.when;

import java.util.UUID;


@ExtendWith(MockitoExtension.class)
public class DeleteStudentTest {

    @Mock
    TeacherQueryStudentPort teacherQueryStudentPort;

    @Mock
    TeacherCommandStudentPort teacherCommandStudentPort;

    @InjectMocks
    DeleteStudentUseCase deleteStudentUseCase;

    @Test
    public void testDeleteStudent() {
        UUID studentId = UUID.randomUUID();

        given(teacherQueryStudentPort.queryUserById(studentId))
                .willReturn(
                        Student.builder()
                                .userId(studentId)
                                .build()
                );

        deleteStudentUseCase.execute(studentId);
    }

}
