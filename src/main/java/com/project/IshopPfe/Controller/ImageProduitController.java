package com.project.IshopPfe.Controller;

import com.project.IshopPfe.dao.ImageProduitRepository;
import com.project.IshopPfe.dto.Im;
import com.project.IshopPfe.entities.ImageProduit;
import com.project.IshopPfe.service.ImageProduitService;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    @GetMapping(value="/getImages/{productId}")
    public ResponseEntity<List<String>> getImages(@PathVariable Long productId){
        List<String> images = new ArrayList<>();
        String imagePath = "src/main/resources/produits/" + productId;
        File fileFolder= new File(imagePath);
        if(fileFolder != null){
            for(final File file : fileFolder.listFiles()){
                if(!file.isDirectory()){
                    String encodeBase64 = null;
                    try{
                        String extension = FilenameUtils.getExtension(file.getName());
                        FileInputStream fileInputStream = new FileInputStream(file);
                        byte[] bytes= new byte[(int) file.length()];
                        fileInputStream.read(bytes);
                        encodeBase64 = Base64.getEncoder().encodeToString(bytes);
                        images.add("data:image/"+extension+";base64,"+encodeBase64);
                        fileInputStream.close();
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }
        }
        return new ResponseEntity<List<String>>(images, HttpStatus.OK);
    }

    @GetMapping(value="/getOneImage/{productId}")
    public Im getOneImage(@PathVariable Long productId){
        List<String> images = new ArrayList<>();
        String imagePath = "src/main/resources/produits/" + productId;
        File fileFolder= new File(imagePath);
        if(fileFolder != null){
            for(final File file : fileFolder.listFiles()){
                if(!file.isDirectory()){
                    String encodeBase64 = null;
                    try{
                        String extension = FilenameUtils.getExtension(file.getName());
                        FileInputStream fileInputStream = new FileInputStream(file);
                        byte[] bytes= new byte[(int) file.length()];
                        fileInputStream.read(bytes);
                        encodeBase64 = Base64.getEncoder().encodeToString(bytes);
                        images.add("data:image/"+extension+";base64,"+encodeBase64);
                        fileInputStream.close();
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }
        }
        String Res=images.get(0);
        Im i=new Im();
        i.path=Res;
       // return new ResponseEntity<List<String>>(Collections.singletonList(images.get(0)), HttpStatus.OK);
        return i;
    }



//        String imagePath = "product/" + productId + "/" + imageName;
//        ClassPathResource imgFile = new ClassPathResource(imagePath);
//        if (!imgFile.exists()) {
//            return ResponseEntity.notFound().build();
//        }
//        byte[] bytes = StreamUtils.copyToByteArray(imgFile.getInputStream());




}
