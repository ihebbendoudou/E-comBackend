package com.project.IshopPfe.dao;

import com.project.IshopPfe.entities.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CouponRepository extends JpaRepository<Coupon,Long> {
    @Query("select c from coupon c where c.magasin.id = ?1")
    List<Coupon> findAllByMagasin_id(Long id);
    @Query("select c from coupon c where c.value = ?1")
    List<Coupon>findByValue(String value);
}
