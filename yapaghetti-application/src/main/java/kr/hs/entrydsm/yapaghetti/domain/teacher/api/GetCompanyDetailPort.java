package kr.hs.entrydsm.yapaghetti.domain.teacher.api;

import kr.hs.entrydsm.yapaghetti.domain.teacher.api.dto.response.CompanyDetailResponse;

import java.util.UUID;

public interface GetCompanyDetailPort {
    CompanyDetailResponse execute(UUID companyID);
}
