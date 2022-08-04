package kr.hs.entrydsm.yapaghetti.domain.image.presentation;

import kr.hs.entrydsm.yapaghetti.domain.image.api.UploadImagePort;
import kr.hs.entrydsm.yapaghetti.domain.image.api.dto.response.ImageUrlResponse;
import kr.hs.entrydsm.yapaghetti.domain.image.exception.ImageNotFoundException;
import kr.hs.entrydsm.yapaghetti.domain.image.spi.type.ImageType;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Objects;
import java.util.UUID;

@RequiredArgsConstructor
@RequestMapping("/images")
@RestController
public class ImageWebAdapter {

    private final UploadImagePort uploadImagePort;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ImageUrlResponse uploadImage(@RequestParam MultipartFile file,
                                        @RequestParam("type") ImageType imageType) {
        return uploadImagePort.uploadImage(MultipartFileToFIle(file), imageType);
    }

    private File MultipartFileToFIle(MultipartFile multipartFile) {
        if (multipartFile == null || multipartFile.isEmpty() || multipartFile.getOriginalFilename() == null) {
            throw ImageNotFoundException.EXCEPTION;
        }

        File file = new File(Objects.requireNonNull(multipartFile.getOriginalFilename()));

        try (OutputStream outputStream = new FileOutputStream(file)) {
            outputStream.write(multipartFile.getBytes());
        } catch (IOException e) {
            throw ImageNotFoundException.EXCEPTION;
        }

        return file;
    }

}
