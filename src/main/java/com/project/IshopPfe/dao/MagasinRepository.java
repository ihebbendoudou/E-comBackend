package com.project.IshopPfe.dao;

import com.project.IshopPfe.entities.Internaute;
import com.project.IshopPfe.entities.Magasin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository("magasinRepo")
public interface MagasinRepository extends JpaRepository<Magasin, Long>   {
    @Query(
            value = "SELECT * FROM client e , magasin m " +
                    "WHERE e.email = :email " +
                    "AND e.password= :password and e.id = m.id " ,
            nativeQuery = true
    )
    public Magasin findByEmail(@Param("email") String email,
                                  @Param("password") String password);
}
