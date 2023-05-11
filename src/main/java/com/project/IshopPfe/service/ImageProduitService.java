package com.project.IshopPfe.service;

import com.project.IshopPfe.dao.ImageProduitRepository;
import com.project.IshopPfe.dao.ProduitRepository;
import com.project.IshopPfe.dao.SousCategoryRepository;
import com.project.IshopPfe.dto.ImageProduitRequest;
import com.project.IshopPfe.dto.ProduitRequest;
import com.project.IshopPfe.entities.ImageProduit;
import com.project.IshopPfe.entities.Produit;
import com.project.IshopPfe.entities.sous_category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Service
public class ImageProduitService {

    @Autowired
    ImageProduitRepository imageProduitRepository;



    public List<byte[]> getImagesByProductId(Long productId) throws IOException {
        List<ImageProduit> images = imageProduitRepository.findByProduit_id(productId);
        List<byte[]> imageDataList = new ArrayList<>();

        for (ImageProduit image : images) {
            byte[] imageData = Files.readAllBytes(Paths.get(image.getPath()));
            imageDataList.add(imageData);
        }

        return imageDataList;
    }

    public List<ImageProduit> getImagesByProductId1(long productId) {
        return imageProduitRepository.findByProduit_id(productId);
    }


//    public ResponseEntity<byte[]> getProductImages(Long productId) {
//        String imagePath = "product/" + productId + "/" + imageName;
//        ClassPathResource imgFile = new ClassPathResource(imagePath);
//        if (!imgFile.exists()) {
//            return ResponseEntity.notFound().build();
//        }
//        byte[] bytes = StreamUtils.copyToByteArray(imgFile.getInputStream());
//        return ResponseEntity
//                .ok()
//                .contentType(MediaType.IMAGE_JPEG)
//                .body(bytes);
//    }
//
//    public List<String> getImagesNames(Long idProd){
//        List<String> names=new ArrayList<>();
//        return .findByProduit();
//    }
//


}
