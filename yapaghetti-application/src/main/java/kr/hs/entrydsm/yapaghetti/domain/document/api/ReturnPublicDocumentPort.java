package kr.hs.entrydsm.yapaghetti.domain.document.api;

import java.util.UUID;

public interface ReturnPublicDocumentPort {
	void execute(UUID studentId);
}
