package kr.hs.entrydsm.yapaghetti.domain.tag.usecase;

import kr.hs.entrydsm.yapaghetti.annotation.UseCase;
import kr.hs.entrydsm.yapaghetti.domain.tag.api.DeleteTagPort;
import kr.hs.entrydsm.yapaghetti.domain.tag.exception.UnableDeleteTagException;
import kr.hs.entrydsm.yapaghetti.domain.tag.spi.CommandTagPort;
import kr.hs.entrydsm.yapaghetti.domain.tag.spi.QueryTagPort;
import kr.hs.entrydsm.yapaghetti.domain.tag.spi.TagCommandMySkillPort;
import kr.hs.entrydsm.yapaghetti.domain.tag.spi.TagCommandStudentPort;
import kr.hs.entrydsm.yapaghetti.domain.tag.spi.TagQueryStudentPort;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
@UseCase
public class DeleteTagUseCase implements DeleteTagPort {

    private final CommandTagPort commandTagPort;
    private final QueryTagPort queryTagPort;
    private final TagCommandStudentPort tagCommandStudentPort;
    private final TagCommandMySkillPort tagCommandMySkillPort;

    @Override
    public void execute(UUID tagId) {
        queryTagPort.queryTagById(tagId);

        if (tagCommandMySkillPort.existsMySkillByTagId(tagId) || tagCommandStudentPort.existsStudentByTagId(tagId)) {
            throw UnableDeleteTagException.EXCEPTION;
        }
        commandTagPort.deleteTagById(tagId);
    }

}
