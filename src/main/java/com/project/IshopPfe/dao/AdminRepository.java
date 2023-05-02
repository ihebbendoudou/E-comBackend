package com.project.IshopPfe.dao;

import com.project.IshopPfe.entities.Admin;
import com.project.IshopPfe.entities.Internaute;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository(value = "admibRepo")
public interface AdminRepository extends JpaRepository<Admin,Long> {
    @Query(
            value = "SELECT * FROM admin e " +
                    "WHERE e.email = :email " +
                    "AND e.password= :password  " ,
            nativeQuery = true
    )
    public Admin findByEmailAndPasswored(@Param("email") String email,
                                  @Param("password") String password);
}
