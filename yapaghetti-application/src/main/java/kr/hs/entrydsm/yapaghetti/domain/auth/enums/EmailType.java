package kr.hs.entrydsm.yapaghetti.domain.auth.enums;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum EmailType {

	RESET_PASSWORD("YapaghettiResetPassword"),
	ARRIVED_FEEDBACK("YapaghettiArrivedFeedback"),
	COMPLETED_DOCUMENT_SUBMISSION("YapaghettiCompletedDocumentSubmission"),
	CREATE_COMPANY("YapaghettiCreateCompany"),
	CERTIFICATION_EMAIL("YapaghettiCertificationEmail");

	private final String templateName;
}
