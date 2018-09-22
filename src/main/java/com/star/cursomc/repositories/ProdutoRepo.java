package com.star.cursomc.repositories;

import com.star.cursomc.domain.Categoria;
import com.star.cursomc.domain.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepo extends JpaRepository<Produto, Integer> {
}
