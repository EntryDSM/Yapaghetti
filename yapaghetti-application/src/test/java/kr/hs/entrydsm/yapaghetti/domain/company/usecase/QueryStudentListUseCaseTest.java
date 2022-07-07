package kr.hs.entrydsm.yapaghetti.domain.company.usecase;


import kr.hs.entrydsm.yapaghetti.domain.company.api.dto.request.DomainQueryStudentListRequest;
import kr.hs.entrydsm.yapaghetti.domain.company.spi.CompanyQueryStudentPort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class QueryStudentListUseCaseTest {

    @Mock
    CompanyQueryStudentPort companyQueryStudentPort;

    @InjectMocks
    QueryStudentListUseCase queryStudentListUseCase;

    @Test
    void execute() {
        DomainQueryStudentListRequest request = new DomainQueryStudentListRequest();
        request.setName("test");

        queryStudentListUseCase.execute(request);
    }

}