package com.project.IshopPfe.service;

import com.project.IshopPfe.dao.AdminRepository;
import com.project.IshopPfe.dto.CreateMagasinRequest;
import com.project.IshopPfe.entities.Admin;
import com.project.IshopPfe.entities.Internaute;
import com.project.IshopPfe.entities.Magasin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    @Autowired
    AdminRepository adminRepository;
    @Autowired MagasinService magasinService;

    public Admin updateAdmin(Admin admin){
        return adminRepository.save(admin);
    }
    public boolean LoginAdmin(String email,String password){
        Admin user = adminRepository.findByEmailAndPasswored(email,password);
        if (user == null){
            return false;
        } else return true;
    }


}
