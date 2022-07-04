package kr.hs.entrydsm.yapaghetti.domain.student.persistence;

import kr.hs.entrydsm.yapaghetti.global.annotation.Adapter;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
@Adapter
public class StudentPersistenceAdapter {

	private final StudentRepository studentRepository;

	public boolean existsByTagId(UUID tagId) {
		return studentRepository.existsByTagId(tagId);
	}

}
