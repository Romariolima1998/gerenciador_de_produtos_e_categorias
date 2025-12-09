package com.romario.gerenciador_de_produtos.controller;

import com.romario.gerenciador_de_produtos.business.ProdutoService;
import com.romario.gerenciador_de_produtos.business.dto.ProdutoInDTO;
import com.romario.gerenciador_de_produtos.business.dto.ProdutoOutDTO;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/produtos")
@Tag(name = "gerenciador de produtos")
public class ProdutoController {

    private final ProdutoService service;

    @PostMapping
    public ResponseEntity<ProdutoOutDTO> criaProduto(@RequestBody  ProdutoInDTO dto){
        return ResponseEntity.status(201).body(service.criaProduto(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoOutDTO> buscaProdutoPorId(@PathVariable Long id){
        return ResponseEntity.ok(service.buscaProdutoPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProdutoOutDTO> atualizaProdutoPorId(@PathVariable Long id, @RequestBody ProdutoInDTO dto){
        return ResponseEntity.ok(service.atualizaProduto(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletaProdutoPorId(@PathVariable Long id){
        service.deletaProduto(id);
        return ResponseEntity.ok().build();
    }
}
