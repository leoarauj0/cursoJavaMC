package com.star.cursomc.services;

import com.star.cursomc.domain.Categoria;
import com.star.cursomc.repositories.CategoriaRepo;
import com.star.cursomc.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepo repo;

    public Categoria find(Integer id) {
        Optional<Categoria> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
    }

    public Categoria insert(Categoria obj){
        obj.setId(null); //para o metodo save identificar que é um novo objeto e nao uma atualização de um ja existente
        return repo.save(obj);
    }
}
