package kr.hs.entrydsm.yapaghetti.domain.teacher.persistence;

import kr.hs.entrydsm.yapaghetti.domain.teacher.spi.TeacherPort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class TeacherPersistenceAdapter implements TeacherPort {

    private final TeacherRepository teacherRepository;

}
