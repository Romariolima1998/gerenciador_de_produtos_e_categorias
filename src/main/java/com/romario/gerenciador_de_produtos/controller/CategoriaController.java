package com.romario.gerenciador_de_produtos.controller;

import com.romario.gerenciador_de_produtos.business.CategoriaService;
import com.romario.gerenciador_de_produtos.business.dto.CategoriaInDTO;
import com.romario.gerenciador_de_produtos.business.dto.CategoriaOutDTO;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/categorias")
@Tag(name = "gereenciador de categorias")
public class CategoriaController {

    private final CategoriaService service;

    @PostMapping
    public ResponseEntity<CategoriaOutDTO> criaCategoria(@RequestBody CategoriaInDTO dto) {
        return ResponseEntity.status(201).body(service.criaCategoria(dto));
    }

    @GetMapping
    public ResponseEntity<List<CategoriaOutDTO>> bucaCategoria(@RequestParam int page, @RequestParam int limit) {
        return ResponseEntity.ok(service.buscaCategorias(page, limit));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoriaOutDTO> atualizaCategoria(@PathVariable Long id, @RequestBody CategoriaInDTO dto) {
        return ResponseEntity.status(200).body(service.atualizaCategoria(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletaCategoria(@PathVariable Long id){
        service.deletaCategoria(id);
        return ResponseEntity.ok().build();
    }
}