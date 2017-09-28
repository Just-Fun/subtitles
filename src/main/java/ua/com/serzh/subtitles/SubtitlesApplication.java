package ua.com.serzh.subtitles;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class SubtitlesApplication {

	public static void main(String[] args) {
		SpringApplication.run(SubtitlesApplication.class, args);
	}
}
