package com.project.IshopPfe.service;

import com.project.IshopPfe.dao.InternautRepository;
import com.project.IshopPfe.dto.CreateInternauteRequest;
import com.project.IshopPfe.entities.Internaute;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InternautService {


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
                request.getLogin(),
                request.getEmail(),
                request.getNom(),
                request.getPrenom()

        );
        return  internautRepository.save(internaute);
    }

    public Internaute getInternauteById(Long id) {
       return internautRepository.findById(id).get();
    }
    public void deleteInternaute(Internaute request) {
           internautRepository.delete(request);
    }
    public void deleteInternautebyId(Long id) {
        internautRepository.deleteById(id);
    }
    public Internaute updateInternaute(Long id,CreateInternauteRequest p) {
        Internaute internaute= internautRepository.findById(id).get();
            internaute.setNom(p.getNom());
            internaute.setPrenom(p.getPrenom());
            internaute.setEmail(p.getEmail());
            internaute.setLogin(p.getLogin());
            internaute.setPassword(p.getPassword());
            internaute.setTel(p.getTel());
         return    internautRepository.save(internaute);
    }
        public boolean LoginInternaute(String email,String password){
            Internaute user = internautRepository.findByEmail(email,password);
            if (user == null){
                return false;
            } else return true;
        }



}
