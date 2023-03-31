package com.example.hope.DAO.Repository;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.hope.DAO.Entity.MuebleEntity;

public interface MuebleRepository extends JpaRepository<MuebleEntity,Long>{
    
}
