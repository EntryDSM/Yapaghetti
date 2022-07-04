package kr.hs.entrydsm.yapaghetti.domain.student.persistence;

import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
public class StudentPersistenceAdapter {

	private final StudentRepository studentRepository;

	public boolean existsByTagId(UUID tagId) {
		return studentRepository.existsByTagId(tagId);
	}

}
