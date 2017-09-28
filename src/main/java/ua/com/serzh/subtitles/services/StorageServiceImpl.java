package ua.com.serzh.subtitles.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ua.com.serzh.subtitles.StorageProperties;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author sergii.zagryvyi on 28.09.2017
 */
@Service
public class StorageServiceImpl implements StorageService {

    private final Path rootLocation;

    @Autowired
    public StorageServiceImpl(StorageProperties properties) {
        this.rootLocation = Paths.get(properties.getLocation());
    }

    @Override
    public void store(MultipartFile file) {
        String originalFilename = file.getOriginalFilename();
        try {
            if (file.isEmpty()) {
//                throw new StorageException("Failed to store empty file " + originalFilename);
            }
//            Store to Hazelcast
            Files.copy(file.getInputStream(), this.rootLocation.resolve(originalFilename));
        } catch (IOException e) {
//            throw new StorageException("Failed to store file " + originalFilename, e);
        }
    }
}
