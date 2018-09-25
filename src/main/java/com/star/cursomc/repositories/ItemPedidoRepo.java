package com.star.cursomc.repositories;

import com.star.cursomc.domain.ItemPedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemPedidoRepo extends JpaRepository<ItemPedido, Integer> {
}
