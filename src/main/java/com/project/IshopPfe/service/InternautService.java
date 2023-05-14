package com.project.IshopPfe.service;

import com.project.IshopPfe.dao.ClientRepository;
import com.project.IshopPfe.dao.InternautRepository;
import com.project.IshopPfe.dto.CreateInternauteRequest;
import com.project.IshopPfe.entities.Client;
import com.project.IshopPfe.entities.Internaute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InternautService {

@Autowired
    ClientRepository clientRepository;
    private final InternautRepository internautRepository;

    public InternautService(InternautRepository internautRepository) {
        this.internautRepository = internautRepository;
    }

    public List<Internaute> getAll(){
        return internautRepository.findAll();
    }
    public Internaute save(CreateInternauteRequest request) {
        Internaute internaute = new Internaute(
                request.getTel(),
                request.getPassword(),
                request.getAdresse(),
                request.getLogin(),
                request.getEmail(),
                request.getNom(),
                request.getPrenom()

        );
        return  internautRepository.save(internaute);
    }

    public Internaute getInternauteById(long id) {
       return internautRepository.findById(id).get();
    }
    public void deleteInternaute(Internaute request) {
           internautRepository.delete(request);
    }
    public void deleteInternautebyId(long id) {
        internautRepository.deleteById(id);
    }
    public Internaute updateInternaute(long id,CreateInternauteRequest p) {
        Internaute internaute= internautRepository.findById(id).get();
            internaute.setNom(p.getNom());
            internaute.setPrenom(p.getPrenom());
            internaute.setAdresse(p.getAdresse());
            internaute.setEmail(p.getEmail());
            internaute.setLogin(p.getLogin());
            internaute.setPassword(p.getPassword());
            internaute.setTel(p.getTel());
         return    internautRepository.save(internaute);
    }

        public long LoginInternaute(String email,String password){
            Client user = internautRepository.findByEmailAndPassword(email,password);
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
