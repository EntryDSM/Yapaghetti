package kr.hs.entrydsm.yapaghetti.domain.teacher.persistence;

import kr.hs.entrydsm.yapaghetti.domain.teacher.spi.TeacherPort;
import kr.hs.entrydsm.yapaghetti.global.annotation.Adapter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Adapter
public class TeacherPersistenceAdapter implements TeacherPort {

    private final TeacherRepository teacherRepository;

}
