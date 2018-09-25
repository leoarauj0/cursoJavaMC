package com.star.cursomc.repositories;

import com.star.cursomc.domain.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PagamentoRepo extends JpaRepository<Pagamento, Integer> {
}
