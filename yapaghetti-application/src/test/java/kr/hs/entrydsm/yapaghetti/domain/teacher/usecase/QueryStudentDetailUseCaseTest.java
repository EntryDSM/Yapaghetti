package kr.hs.entrydsm.yapaghetti.domain.teacher.usecase;

import kr.hs.entrydsm.yapaghetti.domain.teacher.api.dto.response.StudentPersonalAndMajorResponse;
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

        List<String> mySkillList = new ArrayList<>();

        mySkillList.add("Spring boot");

        given(teacherQueryStudentPort.queryPersonalAndMajorById(studentId))
                .willReturn(
                    createStudentPersonalAndMajorResponse(studentId)
                );

        given(teacherQueryMySkillPort.queryMySkillNameByStudentId(studentId))
                .willReturn(
                        mySkillList
                );

        queryStudentDetailUseCase.execute(studentId);

    }

    private StudentPersonalAndMajorResponse createStudentPersonalAndMajorResponse(UUID studentId) {
        List<String> tagList = new ArrayList<>();
        tagList.add("SpringBoot");
        tagList.add("FastAPI");
        return new StudentPersonalAndMajorResponse(
                "엔트리",
                "2",
                "2",
                20,
                "https://entrydsm.hs.kr/~~~",
                "entrydsm@dsm.hs.kr",
                "010111111"
                ,"BackEnd"
        );
    }
}
