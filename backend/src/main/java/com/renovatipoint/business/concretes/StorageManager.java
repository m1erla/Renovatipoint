package com.renovatipoint.business.concretes;

import com.renovatipoint.core.utilities.images.ImageUtils;
import com.renovatipoint.dataAccess.abstracts.StorageRepository;
import com.renovatipoint.entities.concretes.Image;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Service
public class StorageManager {

    private StorageRepository repository;

    public StorageManager(){}
    @Autowired
    public StorageManager(StorageRepository repository) {
        this.repository = repository;
    }

    public String uploadImage(MultipartFile file) throws IOException {
        Image imageData = repository.save(Image.builder()
                .name(file.getOriginalFilename())
                .type(file.getContentType())
                .imageData(ImageUtils.compressImage(file.getBytes()))
                .build());

        if (imageData!= null){
            return "Image uploaded successfully : " + file.getOriginalFilename();
        }
        return null;
    }
    @Transactional
    public byte[] downloadImage(String fileName){
        Optional<Image> dbImageData = repository.findByName(fileName);
        byte[] images =ImageUtils.decompressImage(dbImageData.get().getImageData());
        return images;
    }
}