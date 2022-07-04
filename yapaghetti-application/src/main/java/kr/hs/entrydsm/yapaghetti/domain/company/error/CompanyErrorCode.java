package kr.hs.entrydsm.yapaghetti.domain.company.error;

import kr.hs.entrydsm.yapaghetti.error.ErrorProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum CompanyErrorCode implements ErrorProperty {

    COMPANY_NOT_FOUND(404, "존재하지 않는 회사입니다.");

    private final int status;
    private final String message;

}
