package ua.com.serzh.subtitles.services.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ua.com.serzh.subtitles.services.Parser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * @author sergii.zagryvyi on 28.09.2017
 */
@Slf4j
@Service
public class ParserImpl implements Parser {

    public static final String ANY_LETTER = ".*[a-zA-Z]+.*+";

    @Override
    public List<String> createListFromFile(MultipartFile file) {
        String originalFilename = file.getOriginalFilename();
        if (file.isEmpty()) {
//            throw new SomeException("Failed to parse empty file " + originalFilename);
        }

        InputStream inputStream = null;
        try {
             inputStream = file.getInputStream();
        } catch (IOException e) {
            log.warn("djscdsvsdv", e);
            return new ArrayList<>();
        }

        List<String> result = new ArrayList<>();
        String line;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
            while ((line = br.readLine()) != null) {
//                TODO save to file
                if (line.isEmpty() || !Pattern.matches(ANY_LETTER, line)) {
                    continue;
                }
                String withoutI = line.replace("</i>", "").replace("<i>", "");
                result.add(withoutI);
            }
        } catch (IOException e) {
            log.warn("Can't read file. ", e);
        }
        return result;
    }
}
