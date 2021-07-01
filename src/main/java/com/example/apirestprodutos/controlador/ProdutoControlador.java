package com.example.apirestprodutos.controlador;

import com.example.apirestprodutos.modelo.Produto;
import com.example.apirestprodutos.repositorio.ProdutoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Optional;

@RestController
@RequestMapping(path = "/produtos/")
public class ProdutoControlador {
    @Autowired
    private ProdutoRepositorio produtoRepositorio;

    @PostMapping
    public ResponseEntity<?> criarProduto(@RequestBody Produto produto){
        produtoRepositorio.save(produto);
        return new ResponseEntity<>(produto, HttpStatus.CREATED);
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<?> pegarProduto(@PathVariable("id") Long id){
        Optional<Produto> produto = produtoRepositorio.findById(id);
        if (produto.isPresent()) return new ResponseEntity<>(produto.get(), HttpStatus.OK);
        return new ResponseEntity<>("Produto não encontrado", HttpStatus.NOT_FOUND);
    }

}
