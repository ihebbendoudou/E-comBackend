package com.project.IshopPfe.service;

import com.project.IshopPfe.dao.CouponRepository;
import com.project.IshopPfe.dao.MagasinRepository;
import com.project.IshopPfe.dao.ProduitRepository;
import com.project.IshopPfe.dto.CouponDto;
import com.project.IshopPfe.entities.Client;
import com.project.IshopPfe.entities.Coupon;
import com.project.IshopPfe.entities.Magasin;
import com.project.IshopPfe.entities.Produit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CouponService {
    @Autowired
    CouponRepository couponRepository;
    @Autowired
    ProduitRepository produitRepository;
    @Autowired
    ProduitService produitService;
    @Autowired
    MagasinRepository magasinRepository;

    public List<Coupon> getAllbyClientId(Long id) {
    return couponRepository.findAllByMagasin_id(id);
    }

    public Coupon create(CouponDto couponDto) {
        Coupon c= new Coupon();
        c.setPourcentage(couponDto.pourcentage);
        c.setValue(couponDto.value);
        Magasin m= magasinRepository.findById(couponDto.idC).get();
        c.setMagasin(m);
        couponRepository.save(c);
        List<Produit> p = produitRepository.findByClientId(couponDto.idC);
        for (Produit test : p)
        {
            test.setCoupon(c);
            produitRepository.save(test);
        }
        return c;
    }

    public Coupon update(CouponDto couponDto) {
        List<Produit> p = produitRepository.findByClientId(couponDto.idC);
        Coupon c= couponRepository.findById(couponDto.id).get();
        c.setPourcentage(couponDto.pourcentage);
        c.setValue(couponDto.value);
        Magasin m= magasinRepository.findById(couponDto.idC).get();
        c.setMagasin(m);
        for (Produit test : p)
        {
            test.setCoupon(c);
            produitRepository.save(test);
        }
        return c;

    }
}
