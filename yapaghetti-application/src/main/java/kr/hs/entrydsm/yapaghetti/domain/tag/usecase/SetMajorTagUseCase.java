package kr.hs.entrydsm.yapaghetti.domain.tag.usecase;

import kr.hs.entrydsm.yapaghetti.annotation.UseCase;
import kr.hs.entrydsm.yapaghetti.domain.student.domain.Student;
import kr.hs.entrydsm.yapaghetti.domain.student.spi.CommandStudentPort;
import kr.hs.entrydsm.yapaghetti.domain.tag.api.SetMajorTagPort;
import kr.hs.entrydsm.yapaghetti.domain.tag.api.dto.request.DomainSetMajorTagRequest;
import kr.hs.entrydsm.yapaghetti.domain.tag.domain.Tag;
import kr.hs.entrydsm.yapaghetti.domain.tag.domain.TagType;
import kr.hs.entrydsm.yapaghetti.domain.tag.exception.InvalidTagTypeException;
import kr.hs.entrydsm.yapaghetti.domain.tag.spi.QueryTagPort;
import kr.hs.entrydsm.yapaghetti.domain.tag.spi.TagQueryStudentPort;
import kr.hs.entrydsm.yapaghetti.domain.tag.spi.TagSecurityPort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@UseCase
public class SetMajorTagUseCase implements SetMajorTagPort {

    private final TagSecurityPort tagSecurityPort;

    private final TagQueryStudentPort tagQueryStudentPort;

    private final QueryTagPort queryTagPort;

    private final CommandStudentPort commandStudentPort;

    @Override
    public void execute(DomainSetMajorTagRequest request) {
        Student student = tagQueryStudentPort.queryUserById(tagSecurityPort.getCurrentUserId());

        Tag tag = queryTagPort.queryTagById(request.getTagId());

        if (tag.getType().equals(TagType.SKILL)) {
            throw InvalidTagTypeException.EXCEPTION;
        }

        commandStudentPort.saveStudent(student.updateTagId(request.getTagId()));
    }

}
