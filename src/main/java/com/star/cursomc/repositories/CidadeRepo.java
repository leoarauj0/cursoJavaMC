package com.star.cursomc.repositories;

import com.star.cursomc.domain.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CidadeRepo extends JpaRepository<Cidade, Integer> {
}
