package kr.hs.entrydsm.yapaghetti.domain.tag.usecase;

import kr.hs.entrydsm.yapaghetti.annotation.UseCase;
import kr.hs.entrydsm.yapaghetti.domain.tag.api.DeleteTagPort;
import kr.hs.entrydsm.yapaghetti.domain.tag.exception.TagNotFoundException;
import kr.hs.entrydsm.yapaghetti.domain.tag.exception.UnableDeleteTagException;
import kr.hs.entrydsm.yapaghetti.domain.tag.spi.CommandTagPort;
import kr.hs.entrydsm.yapaghetti.domain.tag.spi.QueryTagPort;
import kr.hs.entrydsm.yapaghetti.domain.tag.spi.TagQueryMySkillPort;
import kr.hs.entrydsm.yapaghetti.domain.tag.spi.TagQueryStudentPort;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
@UseCase
public class DeleteTagUseCase implements DeleteTagPort {

    private final CommandTagPort commandTagPort;
    private final QueryTagPort queryTagPort;
    private final TagQueryStudentPort tagQueryStudentPort;
    private final TagQueryMySkillPort tagQueryMySkillPort;

    @Override
    public void execute(UUID tagId) {
        if (!queryTagPort.existsTagById(tagId)) {
            throw TagNotFoundException.EXCEPTION;
        }

        if (tagQueryMySkillPort.existsMySkillByTagId(tagId) || tagQueryStudentPort.existsStudentByTagId(tagId)) {
            throw UnableDeleteTagException.EXCEPTION;
        }
        commandTagPort.deleteTagById(tagId);
    }

}
