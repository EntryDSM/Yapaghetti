package kr.hs.entrydsm.yapaghetti.domain.student.api;

import kr.hs.entrydsm.yapaghetti.domain.student.domain.UpdateType;

public interface UpdateMyInfoPort {
	void execute(String value, UpdateType type);
}
