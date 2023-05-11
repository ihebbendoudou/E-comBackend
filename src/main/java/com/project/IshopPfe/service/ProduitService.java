package com.project.IshopPfe.service;

import com.project.IshopPfe.dao.ClientRepository;
import com.project.IshopPfe.dao.ImageProduitRepository;
import com.project.IshopPfe.dao.ProduitRepository;
import com.project.IshopPfe.dao.SousCategoryRepository;
import com.project.IshopPfe.dto.ProduitRequest;
import com.project.IshopPfe.entities.Client;
import com.project.IshopPfe.entities.ImageProduit;
import com.project.IshopPfe.entities.Produit;
import com.project.IshopPfe.entities.sous_category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.apache.commons.io.FilenameUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

@Service
public class ProduitService {
    @Autowired ProduitRepository produitRepository;
    @Autowired
    SousCategoryRepository sousCategoryRepository;
    @Autowired
    ClientRepository clientRepository;
    @Autowired
    ImageProduitRepository imageProduitRepository;

    public Long getLastProductId() {
        Produit lastProduct = produitRepository.findFirstByOrderByIdDesc();
        if (lastProduct != null) {
            return lastProduct.getId();
        } else {
            return null;
        }
    }
    public Produit saveProduit(ProduitRequest p) {
        sous_category sc = sousCategoryRepository.findById(p.idSousCategory).get();
        Client client= clientRepository.findById(p.idClient).get();
        Produit produit= new Produit();
        produit.setSousCategory(sc);
        produit.setDescription(p.description);
        produit.setLabelle(p.labelle);
        produit.setPrix(p.prix);
        produit.setClient(client);
        return produitRepository.save(produit);
    }


    public Produit updateProduit(ProduitRequest p) {
        sous_category sc = sousCategoryRepository.findById(p.idSousCategory).get();
        Produit produit= new Produit();
        produit.setSousCategory(sc);
        produit.setDescription(p.description);
        produit.setLabelle(p.labelle);
        produit.setPrix(p.prix);
        produit.setStatut(p.Status);
       return produitRepository.save(produit);

    }
    public void updateSatut(Produit p){
       p.setStatut(1);
       produitRepository.save(p);
    }
    public void deleteProduit(Produit p) {
        produitRepository.delete(p);

    }
    public void deleteProduitById(Long id) {
        produitRepository.deleteById(id);
    }
    public Produit getProduit(Long id) {
        return produitRepository.findById(id).get();
    }
    public List<Produit> getAllProduits() {
        return (List<Produit>) produitRepository.findAll();
    }
    public Produit getProduitByNom(String nom) {
        return produitRepository.findByLabelle(nom);
    }
public  List<ImageProduit> saveImage(MultipartFile[] imageFiles ) throws IOException {
    List<ImageProduit> images = new ArrayList<>();
    for (MultipartFile imageFile : imageFiles) {
        String filename = UUID.randomUUID().toString() + "." + FilenameUtils.getExtension(imageFile.getOriginalFilename());
        String filepath = "src/main/resources/produits/" + filename;

        // Save image to the file system
        Path path = Paths.get(filepath);
        Files.createDirectories(path.getParent());
        Files.copy(imageFile.getInputStream(), path);

        // Save image to the database
        ImageProduit image = new ImageProduit();
        image.setPath(filename);
        image.setProduit(produitRepository.findById(getLastProductId()).get());
        images.add(image);
        imageProduitRepository.save(image);

    }
    return images;
}

//    public Produit saveProduct(ProduitRequest productDto) throws IOException {
//        Produit product = new Produit();
//        product.setLabelle(productDto.lebelle);
//        product.setDescription(productDto.description);
//        product.setPrix(productDto.prix);
//        sous_category sc = sousCategoryRepository.findById(productDto.idSousCategory).get();
//        Client client = clientRepository.findById(productDto.idClient).get();
//        product.setClient(client);
//        product.setSousCategory(sc);
//
//        Produit savedProduct = produitRepository.save(product);
//
//        return savedProduct;
//    }

    public void moveImageToDirectory(ImageProduit image, String targetDirectory) throws IOException {
        String sourcePath = "src/main/resources/produits" + image.getPath();
        String targetPath = targetDirectory + "/" + image.getPath();
        Path source = Paths.get(sourcePath);
        Path target = Paths.get(targetPath);
        Files.move(source, target);
    }

    public List<Produit> getNonAnnoncer() {
        return produitRepository.findByClientIdAndStatut(3,0);
    }
    public List<Produit> getProduitAnnoncer() {
        return produitRepository.findByClientIdAndStatut(3,1);
    }

}




