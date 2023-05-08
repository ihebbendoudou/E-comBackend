package com.project.IshopPfe.service;

import com.project.IshopPfe.dao.ClientRepository;
import com.project.IshopPfe.dao.MagasinRepository;
import com.project.IshopPfe.dto.CreateMagasinRequest;
import com.project.IshopPfe.entities.Client;
import com.project.IshopPfe.entities.Internaute;
import com.project.IshopPfe.entities.Magasin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.AccessType;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MagasinService {

@Autowired
ClientRepository clientRepository;
    private final MagasinRepository magasinRepository;

    public MagasinService(MagasinRepository magasinRepository) {
        this.magasinRepository = magasinRepository;
    }


    public List<Magasin> getAll(){
        return magasinRepository.findAll();
    }
    public Magasin save(CreateMagasinRequest request) {
        Magasin magasin = new Magasin(
                request.getTel(),
                request.getPassword(),
                request.getEmail(),
                request.getLogin(),
                request.getAdresse(),
                request.getMatriculeF(),
                request.getIntitule()

        );
        return  magasinRepository.save(magasin);
    }

    public Magasin getMagasibnById(Long id) {
       return magasinRepository.findById(id).get();
    }
    public void deleteMagasin(Magasin request) {
        magasinRepository.delete(request);
    }
    public void deleteMagasinbyId(Long id) {
        magasinRepository.deleteById(id);
    }
    public Magasin updateMagasin(Long id,CreateMagasinRequest p) {
        Magasin magasin= magasinRepository.findById(id).get();

        magasin.setAdresse(p.getAdresse());
        magasin.setIntitule(p.getIntitule());
        magasin.setMatriculeF(p.getMatriculeF());
        magasin.setEmail(p.getEmail());
        magasin.setLogin(p.getLogin());
        magasin.setPassword(p.getPassword());
        magasin.setTel(p.getTel());
         return    magasinRepository.save(magasin);
    }
    public Magasin createMagasin(CreateMagasinRequest p) {
        Magasin magasin= new Magasin();
        magasin.setAdresse(p.getAdresse());
        magasin.setIntitule(p.getIntitule());
        magasin.setMatriculeF(p.getMatriculeF());
        magasin.setEmail(p.getEmail());
        magasin.setLogin(p.getLogin());
        magasin.setPassword(p.getPassword());
        magasin.setTel(p.getTel());
        return    magasinRepository.save(magasin);
    }
        public long LoginMagasin(String email,String password){
            Magasin user = magasinRepository.findByEmailAndPassword(email,password);
            if (user == null){
                return 0;
            } else return user.getId();
        }

    public long LoginClient(String email,String password){
        Client user = clientRepository.findByEmailAndPassword(email,password);
        if (user == null){
            return 0;
        } else return user.getId();
    }



}
