package com.example.hope.DAO.Repository;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.hope.DAO.Entity.Long;

public interface MuebleRepository extends JpaRepository<Long,Long>{
    
}
