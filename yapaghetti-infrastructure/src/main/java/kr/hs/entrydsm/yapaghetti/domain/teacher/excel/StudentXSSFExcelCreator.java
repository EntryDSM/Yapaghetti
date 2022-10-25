package kr.hs.entrydsm.yapaghetti.domain.teacher.excel;

import kr.hs.entrydsm.yapaghetti.domain.student.persistence.StudentPersistenceAdapter;
import kr.hs.entrydsm.yapaghetti.domain.teacher.api.dto.response.StudentElementByGradeClassNum;
import kr.hs.entrydsm.yapaghetti.domain.teacher.excel.exception.ExcelOutPutException;
import lombok.AccessLevel;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import lombok.RequiredArgsConstructor;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RequiredArgsConstructor
@Component
public class StudentXSSFExcelCreator implements CreateExcelInterface {

    private final StudentPersistenceAdapter studentPersistenceAdapter;

    public static final String DATE_TIME_FORMAT_PATTERN = "yyyy년MM월dd일_HH시mm분_";
    public static final String CONTENT_TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
    public static final String HEADER_NAME = "\"Content-Disposition\"";
    public static final String FILE_EXTENSION = ".xlsx";
    public static final String CHARSET_NAME = "8859_1";
    public static final String BITE_CHARSET_NAME = "KSC5601";
    public static final String HEADER_VALUE_BEFORE_NAME = "attachment; fileName=\"";
    public static final String HEADER_VALUE_AFTER_NAME = "\"";

    @Override
    public void execute(HttpServletResponse response) {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("학생 정보");

        int rowNum = 0;
        String fileName = "전교생 현황";

        Row headerRow = sheet.createRow(rowNum++);
        headerRow.createCell(0).setCellValue("학번");
        headerRow.createCell(1).setCellValue("이름");
        headerRow.createCell(2).setCellValue("피드백 상태");
        headerRow.createCell(3).setCellValue("대기 문서 여부");
        headerRow.createCell(4).setCellValue("공개 문서 여부");

        List<StudentElementByGradeClassNum> excelElement = studentPersistenceAdapter
                .queryStudentListByGradeAndClassNumAndDocStatus(null, null, null);

        for (StudentElementByGradeClassNum element : excelElement) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(element.getGcn());
            row.createCell(1).setCellValue(element.getName());
            row.createCell(2).setCellValue(element.isFeedbackStatus() ? "O" : null);
            row.createCell(3).setCellValue(element.isSubmitted() ? "O" : null);
            row.createCell(4).setCellValue(element.isPublicStatus() ? "O" : null);
        }

        try {
            String time = LocalDateTime.now()
                    .format(DateTimeFormatter.ofPattern(DATE_TIME_FORMAT_PATTERN));
            String formatFileName = new String((time + fileName + FILE_EXTENSION)
                        .getBytes(BITE_CHARSET_NAME), CHARSET_NAME);

            response.setContentType(CONTENT_TYPE);
            response.setHeader(HEADER_NAME, HEADER_VALUE_BEFORE_NAME + formatFileName + HEADER_VALUE_AFTER_NAME);

            workbook.write(response.getOutputStream());
            workbook.close();
        } catch (IOException e) {
            throw ExcelOutPutException.EXCEPTION;
        }
    }

}
