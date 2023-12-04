package com.asherbakov.repository;

import com.asherbakov.entity.Insurer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InsurerRepository extends JpaRepository<Insurer, Long> {
}
