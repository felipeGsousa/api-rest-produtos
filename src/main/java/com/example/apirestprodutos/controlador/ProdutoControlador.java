package com.example.apirestprodutos.controlador;

import com.example.apirestprodutos.modelo.Produto;
import com.example.apirestprodutos.repositorio.ProdutoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@RestController
@RequestMapping(path = "/produtos/")
public class ProdutoControlador {
    @Autowired
    private ProdutoRepositorio produtoRepositorio;

    @PostMapping
    public ResponseEntity<?> criarProduto(@RequestBody Produto produto){
        produtoRepositorio.save(produto);
        return new ResponseEntity<>(produto, HttpStatus.CREATED);
    };

}
