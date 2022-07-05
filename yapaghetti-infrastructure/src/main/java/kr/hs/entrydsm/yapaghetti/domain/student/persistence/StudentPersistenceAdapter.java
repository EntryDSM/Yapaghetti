package kr.hs.entrydsm.yapaghetti.domain.student.persistence;

import kr.hs.entrydsm.yapaghetti.domain.company.api.dto.response.StudentElement;
import kr.hs.entrydsm.yapaghetti.domain.student.spi.StudentPort;
import kr.hs.entrydsm.yapaghetti.global.annotation.Adapter;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Adapter
public class StudentPersistenceAdapter implements StudentPort {

	private final StudentRepository studentRepository;

	public boolean existsByTagId(UUID tagId) {
		return studentRepository.existsByTagEntityId(tagId);
	}

	@Override
	public List<StudentElement> findStudentByNameAndMajorAndClassNum(String name, String major, String classNum) {
		return null;
	}
}
