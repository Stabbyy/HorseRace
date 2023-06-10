package com.example.repositories;

import com.example.entity.Horses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HorsesRepository extends JpaRepository<Horses, Long> {

}
