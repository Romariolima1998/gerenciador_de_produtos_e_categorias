package com.romario.gerenciador_de_produtos.business;

import com.romario.gerenciador_de_produtos.business.converter.ConverterMapper;
import com.romario.gerenciador_de_produtos.business.converter.UpdateMapper;
import com.romario.gerenciador_de_produtos.business.dto.CategoriaInDTO;
import com.romario.gerenciador_de_produtos.business.dto.CategoriaOutDTO;
import com.romario.gerenciador_de_produtos.business.exceptions.NotFoundtException;
import com.romario.gerenciador_de_produtos.infrastructure.entity.CategoriaEntity;
import com.romario.gerenciador_de_produtos.infrastructure.repository.CategoriaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CategoriaService {

    private final CategoriaRepository repository;
    private final ConverterMapper converter;
    private final UpdateMapper updateMapper;

    public CategoriaOutDTO criaCategoria(CategoriaInDTO dto){
        CategoriaEntity categoria = converter.paraCategoriaEntity(dto);
        return converter.paraCategoriaOutDTO(repository.save(categoria));
    }

    public List<CategoriaOutDTO> buscaCategorias(int page, int limit){
        Pageable pageable = PageRequest.of(page, limit);
        Page<CategoriaEntity> produtos = repository.findAll(pageable);
        return converter.palaListCategoriaDTO(produtos.getContent());
    }

    public CategoriaOutDTO atualizaCategoria(Long id, CategoriaInDTO dto){

        CategoriaEntity categoria = repository.findById(id).orElseThrow(
                ()-> new NotFoundtException("Nenhuma categoria para este id: " + id)
        );
        categoria.setNome(dto.getNome());
        return converter.paraCategoriaOutDTO(repository.save(categoria));
    }

    public void deletaCategoria(Long id){
        CategoriaEntity categoria = repository.findById(id).orElseThrow(
                ()-> new NotFoundtException("Nenhuma categoria para este id: " + id)
        );

        repository.delete(categoria);
    }

}
