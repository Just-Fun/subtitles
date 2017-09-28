package ua.com.serzh.subtitles.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sergii.zagryvyi on 28.09.2017
 */
@RestController
@RequestMapping("/subtitles")
public class SubtitlesController {

    @RequestMapping(method = RequestMethod.POST)
//    @PostMapping("/")
    public ResponseEntity<List<String>> parseSubtitles(@RequestParam("file") MultipartFile file) {
        List<String> result = new ArrayList<>();
        return ResponseEntity.ok(result);
    }

    @RequestMapping(method = RequestMethod.GET)
//    @GetMapping("/")
    public ResponseEntity<String> greetings() {
        return ResponseEntity.ok("Hi!");
    }
}
