package kr.hs.entrydsm.yapaghetti.domain.tag.usecase;

import kr.hs.entrydsm.yapaghetti.annotation.UseCase;
import kr.hs.entrydsm.yapaghetti.domain.tag.api.DeleteTagPort;
import kr.hs.entrydsm.yapaghetti.domain.tag.exception.TagNotFoundException;
import kr.hs.entrydsm.yapaghetti.domain.tag.spi.CommandTagPort;
import kr.hs.entrydsm.yapaghetti.domain.tag.spi.QueryTagPort;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
@UseCase
public class DeleteTagUseCase implements DeleteTagPort {

    private final CommandTagPort commandTagPort;
    private final QueryTagPort queryTagPort;

    @Override
    public void execute(UUID tagId) {
        //TODO 연관된 값이 있어도 바로 삭제할 지 or 삭제 할 수 없게끔 exception 띄울 지

        if (!queryTagPort.existsById(tagId)) {
            throw TagNotFoundException.EXCEPTION;
        }

        commandTagPort.deleteTagById(tagId);
    }

}
