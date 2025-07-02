package com.upc.cultivoapi.repository;

import com.upc.cultivoapi.model.Cultivo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CultivoRepository extends JpaRepository<Cultivo, Long> {
    @Query(value = "select AVG(cantidad) from cultivo;", nativeQuery = true)
    Long getAvg();
}
