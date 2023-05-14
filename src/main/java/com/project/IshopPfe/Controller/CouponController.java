package com.project.IshopPfe.Controller;

import com.project.IshopPfe.dto.CouponDto;
import com.project.IshopPfe.entities.Coupon;
import com.project.IshopPfe.service.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(value = "api/coupon")
public class CouponController {

    @Autowired
    CouponService service;

    @PostMapping(value = "/create")
    public Coupon create(@RequestBody CouponDto couponDto){
        return service.create(couponDto);
    }


    @PutMapping(value = "/update")
    public Coupon update(@RequestBody CouponDto couponDto){
        return service.update(couponDto);
    }
    @GetMapping(value = "/getByIdClient/{id}")
    public List<Coupon> getByIdClient(@PathVariable Long id){
        return service.getAllbyClientId(id);
    }
}

