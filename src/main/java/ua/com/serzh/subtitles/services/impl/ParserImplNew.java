package ua.com.serzh.subtitles.services.impl;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.slf4j.Slf4j;
import ua.com.serzh.subtitles.services.Parser;
import ua.com.serzh.subtitles.utils.SubtitleUtils;

/**
 * @author sergii.zagryvyi on 28.09.2017
 */
@Slf4j
@Service
public class ParserImplNew implements Parser {

    @Override
    public List<String> createListFromFile(MultipartFile multipartFile) {
        List<String> lines;
        try {
            File file = multipartToFile(multipartFile);
            lines = FileUtils.readLines(file, "UTF-8");
        } catch (IOException e) {
            log.error("TODO ", e);
//            throw new TODO create one exception
            throw new RuntimeException("TODO");
        }

        return SubtitleUtils.getSubtitles(lines);
    }

    private File multipartToFile(MultipartFile multipart) throws IllegalStateException, IOException {
        File convFile = new File(multipart.getOriginalFilename());
        multipart.transferTo(convFile);
        return convFile;
    }
}
