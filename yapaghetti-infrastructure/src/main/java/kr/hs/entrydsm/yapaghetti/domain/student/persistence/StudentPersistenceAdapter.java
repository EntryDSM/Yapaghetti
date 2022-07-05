package kr.hs.entrydsm.yapaghetti.domain.student.persistence;

import kr.hs.entrydsm.yapaghetti.domain.student.domain.Student;
import kr.hs.entrydsm.yapaghetti.domain.student.exception.StudentNotFoundException;
import kr.hs.entrydsm.yapaghetti.domain.student.mapper.StudentMapper;
import kr.hs.entrydsm.yapaghetti.domain.student.spi.CommandStudentPort;
import kr.hs.entrydsm.yapaghetti.domain.student.spi.QueryStudentPort;
import kr.hs.entrydsm.yapaghetti.global.annotation.Adapter;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
@Adapter
public class StudentPersistenceAdapter implements CommandStudentPort, QueryStudentPort {

	private final StudentRepository studentRepository;
	private final StudentMapper studentMapper;

	public boolean existsByTagId(UUID tagId) {
		return studentRepository.existsByTagEntityId(tagId);
	}

	@Override
	public void saveStudent(Student student) {
		studentRepository.save(studentMapper.domainToEntity(student));
	}

	@Override
	public Student queryUserById(UUID id) {
		return studentMapper.entityToDomain(
			studentRepository.findById(id)
				.orElseThrow(() -> StudentNotFoundException.EXCEPTION)
		);
	}
}
