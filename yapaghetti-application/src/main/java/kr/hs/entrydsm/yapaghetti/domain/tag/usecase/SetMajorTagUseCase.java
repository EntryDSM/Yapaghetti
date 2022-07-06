package kr.hs.entrydsm.yapaghetti.domain.tag.usecase;

import kr.hs.entrydsm.yapaghetti.annotation.UseCase;
import kr.hs.entrydsm.yapaghetti.domain.student.domain.Student;
import kr.hs.entrydsm.yapaghetti.domain.student.spi.CommandStudentPort;
import kr.hs.entrydsm.yapaghetti.domain.student.spi.QueryStudentPort;
import kr.hs.entrydsm.yapaghetti.domain.tag.api.SetMajorTagPort;
import kr.hs.entrydsm.yapaghetti.domain.tag.api.dto.request.DomainSetMajorTagRequest;
import kr.hs.entrydsm.yapaghetti.domain.tag.exception.TagNotFoundException;
import kr.hs.entrydsm.yapaghetti.domain.tag.spi.QueryTagPort;
import kr.hs.entrydsm.yapaghetti.domain.tag.spi.TagSecurityPort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@UseCase
public class SetMajorTagUseCase implements SetMajorTagPort {

    private final TagSecurityPort tagSecurityPort;

    private final QueryStudentPort queryStudentPort;

    private final QueryTagPort queryTagPort;

    private final CommandStudentPort commandStudentPort;

    @Override
    public void execute(DomainSetMajorTagRequest request) {
        Student student = queryStudentPort.queryUserById(tagSecurityPort.getCurrentUserId());

        if (!queryTagPort.existsById(request.getTagId())) {
            throw TagNotFoundException.EXCEPTION;
        }

        commandStudentPort.saveStudent(student.updateTagId(request.getTagId()));
    }

}
