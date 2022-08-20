package kr.hs.entrydsm.yapaghetti.domain.teacher.api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@Getter
@AllArgsConstructor
public class CompanyElement {
    private final UUID companyId;
    private final String profileImagePath;
    private final String companyName;
    private final String email;
}
