package fr.cnalps.projetPiscine.service;


import fr.cnalps.projetPiscine.repository.ImagesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


@Service
public class ImagesService {
    private  ImagesRepository imagesRepository;

    @Autowired
    public ImagesService(ImagesRepository imagesRepository) {
        this.imagesRepository = imagesRepository;
    }

    public String uploadImages(String path, MultipartFile file) throws IOException {
//        filename
        String name = file.getOriginalFilename();
//        filePath
        Path folder = Paths.get(path);
//        Create folder if not exist
        if (!Files.exists(folder)){
            try {
                Files.createDirectories(folder);
            }
            catch (IOException e){
                e.printStackTrace();
                throw new IOException("Impossible de créer le dossier");
            }
        }
//        File image = new File(path);
//        if (!image.exists()){
//            image.mkdir();
//        }
       // file copy

        Files.copy(file.getInputStream(), folder);
        return name;
    }

}