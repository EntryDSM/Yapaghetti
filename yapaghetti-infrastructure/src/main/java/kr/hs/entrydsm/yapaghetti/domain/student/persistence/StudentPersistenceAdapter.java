package kr.hs.entrydsm.yapaghetti.domain.student.persistence;

import kr.hs.entrydsm.yapaghetti.domain.student.domain.Student;
import kr.hs.entrydsm.yapaghetti.domain.student.exception.StudentNotFoundException;
import kr.hs.entrydsm.yapaghetti.domain.student.mapper.StudentMapper;
import kr.hs.entrydsm.yapaghetti.domain.student.spi.StudentPort;
import kr.hs.entrydsm.yapaghetti.domain.tag.exception.TagNotFoundException;
import kr.hs.entrydsm.yapaghetti.domain.tag.persistence.TagRepository;
import kr.hs.entrydsm.yapaghetti.global.annotation.Adapter;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
@Adapter
public class StudentPersistenceAdapter implements StudentPort {

	private final StudentRepository studentRepository;
	private final TagRepository tagRepository;
	private final StudentMapper studentMapper;

	public boolean existsByTagId(UUID tagId) {
		return studentRepository.existsByTagEntityId(tagId);
	}

	@Override
	public void saveStudent(Student student) {
		if (!tagRepository.existsById(student.getTagId())) {
			throw TagNotFoundException.EXCEPTION;
		}

		studentRepository.save(studentMapper.domainToEntity(student));
	}

	@Override
	public Student queryUserById(UUID id) {
		return studentMapper.entityToDomain(
			studentRepository.findById(id)
				.orElseThrow(() -> StudentNotFoundException.EXCEPTION)
		);
	}

	@Override
	public void deleteStudent(Student student) {
		studentRepository.delete(
				studentMapper.domainToEntity(student)
		);
	}
}
