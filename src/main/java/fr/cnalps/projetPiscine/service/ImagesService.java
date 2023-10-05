package fr.cnalps.projetPiscine.service;

import fr.cnalps.projetPiscine.model.Images;
import fr.cnalps.projetPiscine.repository.CandidateRepository;
import fr.cnalps.projetPiscine.repository.ImagesRepository;
import org.apache.poi.ss.util.ImageUtils;
import org.apache.xmlgraphics.image.loader.util.ImageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;

@Service
public class ImagesService {
    private ImagesRepository imagesRepository;

    @Autowired
    public ImagesService(CandidateRepository candidateRepository) {
        this.candidateRepository = candidateRepository;
    }

    public String uploadImages(MultipartFile file) throws IOException {
        Images images = imagesRepository.save(Images.builder())
                .name(file.getOriginalFilename())
                .type(file.getContentType())
                .imageData(ImageUtil.compressImage(file.getBytes()));
        if (images != null){
            return "image uploaded successfully :" + file.getOriginalFilename();
        }
        return null;
    }
    public byte[] downloadImages(String imageName){
        Optional<Images> dwImages = imagesRepository.findByName(imageName);
        return ImageUtils.decompressImage(dwImages.get().getImageData());
    }
}