package kr.hs.entrydsm.yapaghetti.domain.teacher.usecase;

import kr.hs.entrydsm.yapaghetti.domain.student.domain.Student;
import kr.hs.entrydsm.yapaghetti.domain.teacher.api.DeleteStudentPort;

import kr.hs.entrydsm.yapaghetti.annotation.UseCase;
import kr.hs.entrydsm.yapaghetti.domain.teacher.spi.TeacherCommandStudentPort;
import kr.hs.entrydsm.yapaghetti.domain.teacher.spi.TeacherQueryStudentPort;
import lombok.RequiredArgsConstructor;

import java.util.UUID;


@RequiredArgsConstructor
@UseCase
public class DeleteStudentUseCase implements DeleteStudentPort {

    private final TeacherQueryStudentPort teacherQueryStudentPort;
    private final TeacherCommandStudentPort teacherCommandStudentPort;

    @Override
    public void execute(UUID studentId) {
        Student student = teacherQueryStudentPort.queryUserById(studentId);

        teacherCommandStudentPort.deleteStudent(student);
    }
}
