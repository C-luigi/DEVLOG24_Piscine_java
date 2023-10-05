package fr.cnalps.projetPiscine.controller;


import fr.cnalps.projetPiscine.service.ImagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;

@RestController
@RequestMapping("/images")
public class ImagesController {

    @Autowired
    private ImagesService imagesService;
    @Value("${project.image}")
    private String path;
    @PostMapping("/uploadImages")
    public ResponseEntity<FileResponse> uploadImages(@RequestParam("image") MultipartFile image) throws IOException{
        String fileName = null;
        try {
            fileName = this.imagesService.uploadImages(path, image);
        }
        catch (IOException e){
            e.printStackTrace();
            return new ResponseEntity<>(new FileResponse(null, "Image is not uploaded error"), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(new FileResponse(fileName, "Image successfuly upload"), HttpStatus.OK);
    }

}
