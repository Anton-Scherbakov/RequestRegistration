package com.asherbakov.repository;

import com.asherbakov.entity.TypeOfRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeOfRequestRepository extends JpaRepository<TypeOfRequest, Integer> {
}
