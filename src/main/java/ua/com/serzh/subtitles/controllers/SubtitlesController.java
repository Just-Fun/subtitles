package ua.com.serzh.subtitles.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.RequiredArgsConstructor;
import ua.com.serzh.subtitles.services.Parser;

/**
 * @author sergii.zagryvyi on 28.09.2017
 */
@Controller
//@RequestMapping("/subtitles")
@RequiredArgsConstructor
public class SubtitlesController {

    private final Parser parser;

    @GetMapping("/")
    public String listUploadedFiles() {
        return "uploadForm";
    }

    @PostMapping("/")
    public String handleFileUpload(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {

        List<String> listFromFile = parser.createListFromFile(file);
        redirectAttributes.addFlashAttribute("messages", listFromFile);
        return "redirect:/";
    }

    @RequestMapping(value = "/greetings", method = RequestMethod.GET)
    public ResponseEntity<String> greetings() {
        return ResponseEntity.ok("Hi!");
    }
}
