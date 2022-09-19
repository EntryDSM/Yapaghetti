package kr.hs.entrydsm.yapaghetti.domain.student.api;

import kr.hs.entrydsm.yapaghetti.domain.student.api.dto.response.BetaCreateUserResponse;

public interface BetaCreateUserPort {
	BetaCreateUserResponse execute(String email, int classNum, int number, String name, String phoneNumber);
}
