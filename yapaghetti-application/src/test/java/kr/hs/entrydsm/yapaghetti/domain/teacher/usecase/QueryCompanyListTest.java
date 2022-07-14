package kr.hs.entrydsm.yapaghetti.domain.teacher.usecase;

import kr.hs.entrydsm.yapaghetti.domain.teacher.api.dto.response.CompanyElement;
import kr.hs.entrydsm.yapaghetti.domain.teacher.spi.TeacherQueryCompanyPort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.mockito.BDDMockito.given;


@ExtendWith(MockitoExtension.class)
public class QueryCompanyListTest {

    @Mock
    TeacherQueryCompanyPort teacherQueryCompanyPort;

    @InjectMocks
    QueryCompanyListUseCase queryCompanyListUseCase;

    @Test
    public void execute() {

        String companyName = "엔트리";

        List<CompanyElement> companyElementList = new ArrayList<>();

        companyElementList.add(
                new CompanyElement(
                        UUID.randomUUID().toString(),
                        "https://~~",
                        "엔트리",
                        "entrydsm@dsm.hs.kr"
                )
        );

        given(teacherQueryCompanyPort.queryCompanyDetailList(companyName))
                .willReturn(companyElementList);

        queryCompanyListUseCase.execute(companyName);

    }

}
