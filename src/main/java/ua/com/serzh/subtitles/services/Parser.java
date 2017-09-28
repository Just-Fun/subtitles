package ua.com.serzh.subtitles.services;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface Parser {

    List<String> createListFromFile(MultipartFile file);
}
