package com.example.cc1.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.cc1.model.Orderss;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Orderss, Integer>{
  
   List<Orderss> findByTotalPriceGreaterThan(double tp);
    
   @Query(value="SELECT o FROM Orderss o where o.userId> ?1")
   List<Orderss> findByUse(int u);

   @Modifying
   @Query(value="UPDATE Orderss o SET user_id= :val1 WHERE order_id= :val2",nativeQuery = true)
   void updateuse(@Param("val1") int p,@Param("val2") int p1);


}

