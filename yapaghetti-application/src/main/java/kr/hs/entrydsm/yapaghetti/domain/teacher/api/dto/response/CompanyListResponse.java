package kr.hs.entrydsm.yapaghetti.domain.teacher.api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class CompanyListResponse {
    private final List<CompanyElement> companyElementList;
}
