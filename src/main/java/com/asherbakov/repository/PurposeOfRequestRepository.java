package com.asherbakov.repository;

import com.asherbakov.entity.PurposeOfRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurposeOfRequestRepository extends JpaRepository<PurposeOfRequest, Integer> {
}
