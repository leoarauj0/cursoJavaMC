package com.star.cursomc.repositories;

import com.star.cursomc.domain.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepo extends JpaRepository<Endereco, Integer> {
}
