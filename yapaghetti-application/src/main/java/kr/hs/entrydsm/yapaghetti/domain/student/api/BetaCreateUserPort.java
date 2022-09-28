package kr.hs.entrydsm.yapaghetti.domain.student.api;

import java.util.UUID;
import kr.hs.entrydsm.yapaghetti.domain.student.api.dto.response.BetaCreateUserResponse;

public interface BetaCreateUserPort {
    BetaCreateUserResponse execute(
            String email, int grade, int classNum, int number,
            String name, String phoneNumber, String location, UUID tagId
    );
}
