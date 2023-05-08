package com.project.IshopPfe.Controller;

import com.project.IshopPfe.dto.ProduitRequest;
import com.project.IshopPfe.entities.ImageProduit;
import com.project.IshopPfe.entities.Produit;
import com.project.IshopPfe.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(value = "api/produit")
public class ProduitController {

    @Autowired ProduitService produitService;
    @GetMapping(value = "/getAllProduit")
    public List<Produit> getAllProduit(){
        return produitService.getAllProduits();
    }
    @GetMapping(value = "/getProduit/{id}")
    public Produit getProduitById(@PathVariable Long id){
        return produitService.getProduit(id);
    }
    @PutMapping (value = "/udpate")
    public Produit udpate(@RequestBody ProduitRequest request){
        return produitService.updateProduit(request);
    }
    @PostMapping (value = "/create")
    public String create(@RequestBody ProduitRequest request){
        return request.toString();
       // return produitService.saveProduit(request);
    }
    @PostMapping (value = "/createImage")
    public List<ImageProduit> createImage(@RequestBody MultipartFile[] request) throws IOException {
        return produitService.saveImage(request);
    }


    @DeleteMapping (value = "/delete/{id}")
    public  void delete(@PathVariable Long id){
         produitService.deleteProduitById(id);
    }
    @GetMapping(value = "/getProduitByNom/{nom}")
    public Produit getProduitByNom(@PathVariable String  nom){
        return produitService.getProduitByNom(nom);
    }




//    @PostMapping (value = "/addP")
//    public ResponseEntity<Produit> createProduct(@RequestParam ProduitRequest productJson)
//            throws IOException {
//      //  ObjectMapper objectMapper = new ObjectMapper();
//      //  ProduitRequest productDto = objectMapper.readValue(productJson, ProduitRequest.class);
//        Produit savedProduct = produitService.saveProduct(productJson);
//        String targetDirectory = "src/main/resources/produits";
//        for (ImageProduit image : savedProduct.getImages()) {
//            produitService.moveImageToDirectory(image, targetDirectory);
//        }
//        return ResponseEntity.ok(savedProduct);
//
//    }

}
