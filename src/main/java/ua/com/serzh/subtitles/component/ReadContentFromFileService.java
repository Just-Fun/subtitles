package ua.com.serzh.subtitles.component;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;

import ua.com.serzh.subtitles.utils.SubtitleUtils;

public class ReadContentFromFileService {

    public static void main(String[] args) throws IOException {
        File f = new File("/Users/Serzh/Downloads/fromFile.txt");

        List<String> lines = FileUtils.readLines(f, "UTF-8");

        List<String> result = SubtitleUtils.getSubtitles(lines);

        File newFile = new File("/Users/Serzh/Downloads/resultFile.txt");
        FileUtils.writeLines(newFile, result);
    }
}
