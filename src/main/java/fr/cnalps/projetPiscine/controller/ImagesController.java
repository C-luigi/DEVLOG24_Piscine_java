package fr.cnalps.projetPiscine.controller;

import fr.cnalps.projetPiscine.service.ImagesService;
import org.apache.poi.util.IOUtils;
import org.apache.xmlbeans.ResourceLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.List;

@RestController
@RequestMapping("/images")
public class ImagesController {

    @Autowired
    private ImagesService imagesService;
    private ResourceLoader resourceLoader;
    private String resourcesPath;

    @Autowired
    public ImagesController(ResourceLoader resourceLoader, @Value("${path.images}") String resourcesPath) {
        this.resourceLoader = resourceLoader;
        this.resourcesPath = resourcesPath;
    }

    @PostMapping("/upload")
    public ResponseEntity<String> uploadImages(@RequestParam("file") MultipartFile file){
        if (file.isEmpty()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Veuillez séléctionner un fichier");
        }
        try {
            String destinationPath = resourcesPath + file.getOriginalFilename();

            Path destinationPathfolder = Path.of(destinationPath);
            Files.copy(file.getInputStream(), destinationPathfolder, StandardCopyOption.REPLACE_EXISTING);
            return ResponseEntity.ok("Image uploadée avec succès");
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



}
