package com.meli.simiosapi.repository;

import com.meli.simiosapi.domain.Historic;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HistoricRepository extends JpaRepository<Historic, Long> {
    List<Historic> findByDna(String dna);
    Long countByType(String type);
}
