package kr.hs.entrydsm.yapaghetti.domain.student.api;

import kr.hs.entrydsm.yapaghetti.domain.student.api.dto.response.MyInfoResponse;

public interface QueryMyInfoPort {
    MyInfoResponse execute();
}
