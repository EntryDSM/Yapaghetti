package kr.hs.entrydsm.yapaghetti.domain.teacher.api;

import kr.hs.entrydsm.yapaghetti.domain.teacher.api.dto.response.CompanyListResponse;

public interface QueryCompanyListPort {
    CompanyListResponse execute(String name);
}
