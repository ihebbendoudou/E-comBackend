package com.project.IshopPfe.Controller;

import com.project.IshopPfe.dao.ImageProduitRepository;
import com.project.IshopPfe.dao.ProduitRepository;
import com.project.IshopPfe.dto.ProduitRequest;
import com.project.IshopPfe.entities.Annonce;
import com.project.IshopPfe.entities.ImageProduit;
import com.project.IshopPfe.entities.Produit;
import com.project.IshopPfe.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(value = "api/produit")
public class ProduitController {
    @Autowired ProduitService produitService;
    @Autowired
    ImageProduitRepository imageProduitRepository;
    @Autowired
    ProduitRepository produitRepository;

    @GetMapping(value = "/getAllProduit")
    public List<Produit> getAllProduit() {
        return produitService.getAllProduits();
    }

    @GetMapping(value = "/getProduit/{id}")
    public Produit getProduitById(@PathVariable Long id) {
        return produitService.getProduit(id);
    }

    @PutMapping(value = "/udpate")
    public Produit udpate(@RequestBody ProduitRequest request) {
        return produitService.updateProduit(request);
    }

    @PostMapping(value = "/create")
    public Produit create(@RequestBody ProduitRequest request) {
        // return request.toString();
        return produitService.saveProduit(request);
    }

    @PostMapping(value = "/createImage")
    public List<ImageProduit> createImage(@RequestBody MultipartFile[] request) throws IOException {
        return produitService.saveImage(request);
    }

    @PostMapping(value = "/upload-images")
   public ResponseEntity<String> uploadImages(@RequestParam("myFiles") List<MultipartFile> images) throws IOException {
        Produit produit= produitRepository.findById(getLastProductId()).get();
        Long myId=getLastProductId();
        Files.createDirectories(Paths.get("src/main/resources/produits/"+myId));



        try {
            for (MultipartFile image : images) {
                byte[] imageData = image.getBytes();
                String fileName = image.getOriginalFilename();
                ImageProduit im1 = new ImageProduit();
                im1.setPath(fileName);
                im1.setProduit(produit);
                imageProduitRepository.save(im1);
                File file = new File("src/main/resources/produits/"+myId+"/" + fileName);
                FileOutputStream fos = new FileOutputStream(file);
                fos.write(imageData);
                fos.close();
            }
            return ResponseEntity.ok("Images uploaded successfully");
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to upload images");
        }
    }

    public Long getLastProductId() {
        Produit lastProduct = produitRepository.findFirstByOrderByIdDesc();
        if (lastProduct != null) {
            return lastProduct.getId();
        } else {
            return null;
        }
    }


    @DeleteMapping (value = "/delete/{id}")
    public  void delete(@PathVariable Long id){
         produitService.deleteProduitById(id);
    }
    @GetMapping(value = "/getProduitByNom/{nom}")
    public Produit getProduitByNom(@PathVariable String  nom){
        return produitService.getProduitByNom(nom);
    }


    @GetMapping(value = "/getNonAnnonce/{id}")
    public List<Produit> getNonAnnonce(@PathVariable Long id){
        return produitService.getNonAnnoncer(id);
    }

    @GetMapping(value = "/getProduitAnnonce/{id}")
    public List<Produit> getProduitAnnoncer(@PathVariable Long id){
        return produitService.getProduitAnnoncer(id);

    }
    @GetMapping(value = "/CountByIdCLient/{id}")
    public Long countByClientID(@PathVariable("id") Long id){
        return produitService.countProdByCLient(id);
    }
    @GetMapping(value = "/countByClientIdAndStatut/{id}")
    public Long countByClientIdAndStaut(@PathVariable("id") Long id){
        return produitService.countNonPublichByClient(id);
    }

//    @GetMapping(value = "/productImages/{productId}")
//    public ResponseEntity<byte[]> getProductImages(@PathVariable Long productId) {
//        return produitService.getProductImages(productId)
//    }


}
