package kr.hs.entrydsm.yapaghetti.domain.image.presentation;

import kr.hs.entrydsm.yapaghetti.domain.image.api.UploadImagePort;
import kr.hs.entrydsm.yapaghetti.domain.image.api.dto.response.ImageUrlResponse;
import kr.hs.entrydsm.yapaghetti.domain.image.spi.type.ImageType;
import kr.hs.entrydsm.yapaghetti.global.exception.ImageNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RequiredArgsConstructor
@RequestMapping("/images")
@RestController
public class ImageWebAdapter {

    private final UploadImagePort uploadImagePort;

    @PostMapping
    public ImageUrlResponse uploadImage(@RequestParam MultipartFile file,
                                        @RequestParam("type") ImageType imageType) {
        return uploadImagePort.uploadImage(MultipartFileToFIle(file), imageType);
    }

    private File MultipartFileToFIle(MultipartFile file) {
        if (file == null || file.isEmpty() || file.getOriginalFilename() == null) {
            throw ImageNotFoundException.EXCEPTION;
        }

        File newFile = new File(file.getOriginalFilename());
        try {
            file.transferTo(newFile);
        } catch(IOException e) {
            throw ImageNotFoundException.EXCEPTION;
        }

        return newFile;
    }

}
