package kr.hs.entrydsm.yapaghetti.domain.teacher.usecase;

import kr.hs.entrydsm.yapaghetti.domain.teacher.api.dto.response.StudentInformation;
import kr.hs.entrydsm.yapaghetti.domain.teacher.spi.TeacherQueryMySkillPort;
import kr.hs.entrydsm.yapaghetti.domain.teacher.spi.TeacherQueryStudentPort;
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
public class QueryStudentDetailUseCaseTest {

    @Mock
    TeacherQueryStudentPort teacherQueryStudentPort;

    @Mock
    TeacherQueryMySkillPort teacherQueryMySkillPort;

    @InjectMocks
    QueryStudentDetailUseCase queryStudentDetailUseCase;

    @Test
    public void execute() {

        UUID studentId = UUID.randomUUID();

        given(teacherQueryStudentPort.queryPersonalAndMajorById(studentId))
                .willReturn(
                        new StudentInformation(
                                "테스트",
                                "테스트",
                                "테스트",
                                13,
                                "테스트",
                                "테스트",
                                "테스트",
                                "테스트"
                        )
                );

        List<String> skillNameList = new ArrayList<>();

        skillNameList.add("Spring Boot");

        skillNameList.add("FastAPI");

        given(teacherQueryMySkillPort.queryMySkillNameByStudentId(studentId))
                .willReturn(skillNameList);

        queryStudentDetailUseCase.execute(studentId);
    }
}
