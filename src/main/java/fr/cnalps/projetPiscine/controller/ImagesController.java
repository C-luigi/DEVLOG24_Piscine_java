package fr.cnalps.projetPiscine.controller;

import fr.cnalps.projetPiscine.model.Images;
import fr.cnalps.projetPiscine.service.ImagesService;
import org.apache.poi.util.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@RestController
@RequestMapping("/images")
public class ImagesController {

    @Autowired
    private ImagesService imagesService;

    public ImagesController(ImagesService imagesService) {this.imagesService = imagesService;}

    @GetMapping
    public List<Images> getAllImages(){return this.imagesService.getAllImages();}

    @GetMapping("/{id}")
    public Images getImagesById (@PathVariable(name = "id") int id) {
        return this.imagesService.getImagesById(id);
    }

    @PostMapping
    public Images createImages(@RequestBody (Images images) MultipartFile fichier){

        try {
            Images images = new Images();
            images.setId(1);
            images.setName("profilPic");
            images.setImage(IOUtils.toByteArray(InputStream.nullInputStream()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return imagesService.createImages(images);
    }

    @PutMapping("/{id}")
    public Images updateImages(@PathVariable int id, @RequestBody Images images) {
        return imagesService.updateImages(id, images);
    }
    @DeleteMapping("/{id}")
    public void deleteImages(@PathVariable int id) {
        imagesService.deleteImages(id);
    }
}
