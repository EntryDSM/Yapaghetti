package kr.hs.entrydsm.yapaghetti.domain.teacher.usecase;

import kr.hs.entrydsm.yapaghetti.domain.document.domain.DocumentType;
import kr.hs.entrydsm.yapaghetti.domain.teacher.api.dto.response.StudentElementByGradeClassNum;
import kr.hs.entrydsm.yapaghetti.domain.teacher.spi.TeacherQueryStudentPort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class TeacherQueryStudentListTest {

    @Mock
    TeacherQueryStudentPort teacherQueryStudentPort;

    @InjectMocks
    TeacherQueryStudentListUseCase teacherQueryStudentListUseCase;


    @Test
    public void test() {

        List<StudentElementByGradeClassNum> studentElementList = new ArrayList<>();

        given(teacherQueryStudentPort.queryStudentListByGradeAndClassNumAndDocStatus(2,1, DocumentType.PUBLIC))
                .willReturn(studentElementList);

        teacherQueryStudentListUseCase.execute(2,1,DocumentType.PUBLIC);

    }

}
