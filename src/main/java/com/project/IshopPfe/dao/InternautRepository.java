package com.project.IshopPfe.dao;

import com.project.IshopPfe.entities.Internaute;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository("internautRepo")
public interface InternautRepository extends JpaRepository<Internaute, Long>   {
    @Query(
            value = "SELECT * FROM client e , internaute i " +
                    "WHERE e.email = :email " +
                    "AND e.password= :password and e.id = i.id " ,
            nativeQuery = true
    )
    public Internaute findByEmail(@Param("email") String email,
                                  @Param("password") String password);
}
