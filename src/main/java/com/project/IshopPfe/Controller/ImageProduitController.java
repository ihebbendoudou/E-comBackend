package com.project.IshopPfe.Controller;

import com.project.IshopPfe.dao.ImageProduitRepository;
import com.project.IshopPfe.entities.ImageProduit;
import com.project.IshopPfe.service.ImageProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(value = "api/image")
public class ImageProduitController {
    @Autowired
    ImageProduitService imageService;
    @GetMapping(value = "/imageProd/{productId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<String> getImagesByProductId(@PathVariable Long productId) throws IOException {
        List<byte[]> imageDataList = imageService.getImagesByProductId(productId);
        List<String> encodedImageDataList = new ArrayList<>();

        for (byte[] imageData : imageDataList) {
            String encodedImageData = Base64.getEncoder().encodeToString(imageData);
            encodedImageDataList.add(encodedImageData);
        }

        return encodedImageDataList;
    }

    @GetMapping(value = "/imageProd1/{productId}")
    public List<ImageProduit> getImByIdProd(@PathVariable long productId) throws IOException {
        return imageService.getImagesByProductId1(productId);
    }

}
