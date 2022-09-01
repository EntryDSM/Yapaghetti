package kr.hs.entrydsm.yapaghetti.domain.teacher.usecase;

import kr.hs.entrydsm.yapaghetti.domain.teacher.api.dto.response.StudentDetailResponse;
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
public class QueryStudentDetailTest {

    @Mock
    TeacherQueryStudentPort teacherQueryStudentPort;

    @InjectMocks
    QueryStudentDetailUseCase queryStudentDetailUseCase;

    @Test
    public void execute() {

        UUID studentId = UUID.randomUUID();

        given(teacherQueryStudentPort.queryStudentDetail(studentId))
                .willReturn(
                    creatStudentDetailInformation(studentId)
                );

        queryStudentDetailUseCase.execute(studentId);

    }

    private StudentDetailResponse creatStudentDetailInformation(UUID studentId) {
        List<String> tagList = new ArrayList<>();
        tagList.add("SpringBoot");
        tagList.add("FastAPI");
        return new StudentDetailResponse(
                "엔트리",
                "2",
                "2",
                20,
                "https://entrydsm.hs.kr/~~~",
                "entrydsm@dsm.hs.kr",
                "010111111"
                ,"BackEnd",
                tagList);
    }
}
