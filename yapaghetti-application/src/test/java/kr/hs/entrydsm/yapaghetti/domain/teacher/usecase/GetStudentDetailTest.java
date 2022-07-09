package kr.hs.entrydsm.yapaghetti.domain.teacher.usecase;

import kr.hs.entrydsm.yapaghetti.domain.teacher.spi.TeacherCommandStudentPort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

@ExtendWith(MockitoExtension.class)
public class GetStudentDetailTest {

    @Mock
    TeacherCommandStudentPort teacherCommandStudentPort;

    @InjectMocks
    GetStudentDetailUseCase getStudentDetailUseCase;

    @Test
    void execute() {
        UUID studentId = UUID.randomUUID();

        getStudentDetailUseCase.execute(studentId);
    }
}
