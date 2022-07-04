package kr.hs.entrydsm.yapaghetti.domain.teacher.persistence;

import kr.hs.entrydsm.yapaghetti.global.annotation.Adapter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Adapter
public class TeacherPersistenceAdapter {

    private final TeacherRepository teacherRepository;

}
