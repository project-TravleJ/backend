package com.travlej.backend.attraction.repository;

import com.travlej.backend.attraction.entity.Attraction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttractionRepository extends JpaRepository<Attraction, Integer> {

}
