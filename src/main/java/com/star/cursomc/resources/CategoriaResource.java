package com.star.cursomc.resources;

import com.star.cursomc.domain.Categoria;
import com.star.cursomc.dto.CategoriaDTO;
import com.star.cursomc.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value="/categorias")
public class CategoriaResource {

    @Autowired
    private CategoriaService service;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> find(@PathVariable Integer id){

        Categoria obj = service.find(id);
        return ResponseEntity.ok().body(obj);
    }

//    @RequestMapping(method = RequestMethod.GET)
//    public ResponseEntity<List<Categoria>> findAll(){
//
//        List<Categoria> list = service.findAll(); //retorna todas as categorias
//        return ResponseEntity.ok().body(list);
//    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<CategoriaDTO>> findAll(){

        //retorna todas as categorias
        List<Categoria> list = service.findAll();
        //para retornar apenas as categorias sem os seus produtos convertemos a lista de categorias numa lista de categoriasDTO
        List<CategoriaDTO> listDto = list.stream().map(obj -> new CategoriaDTO(obj)).collect(Collectors.toList());

        return ResponseEntity.ok().body(listDto);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Categoria> insert(@RequestBody Categoria obj){
        obj = service.insert(obj);

        //para retornar o uri do novo objeto salvo
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(obj.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> update(@RequestBody Categoria obj, @PathVariable Integer id){
        obj.setId(id);
        obj = service.update(obj);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
