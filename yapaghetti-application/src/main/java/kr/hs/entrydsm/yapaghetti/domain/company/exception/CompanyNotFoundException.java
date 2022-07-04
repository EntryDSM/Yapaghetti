package kr.hs.entrydsm.yapaghetti.domain.company.exception;

import kr.hs.entrydsm.yapaghetti.domain.company.error.CompanyErrorCode;
import kr.hs.entrydsm.yapaghetti.error.YapaghettiException;

public class CompanyNotFoundException extends YapaghettiException {

    private CompanyNotFoundException() {
        super(CompanyErrorCode.COMPANY_NOT_FOUND);
    }

    public static final YapaghettiException EXCEPTION = new CompanyNotFoundException();

}
