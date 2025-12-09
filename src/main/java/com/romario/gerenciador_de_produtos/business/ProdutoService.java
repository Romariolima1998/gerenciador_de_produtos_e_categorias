package com.romario.gerenciador_de_produtos.business;

import com.romario.gerenciador_de_produtos.business.converter.ConverterMapper;
import com.romario.gerenciador_de_produtos.business.converter.UpdateMapper;
import com.romario.gerenciador_de_produtos.business.dto.ProdutoInDTO;
import com.romario.gerenciador_de_produtos.business.dto.ProdutoOutDTO;
import com.romario.gerenciador_de_produtos.business.exceptions.BadRequestException;
import com.romario.gerenciador_de_produtos.business.exceptions.NotFoundtException;
import com.romario.gerenciador_de_produtos.infrastructure.entity.ProdutoEntity;
import com.romario.gerenciador_de_produtos.infrastructure.repository.CategoriaRepository;
import com.romario.gerenciador_de_produtos.infrastructure.repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProdutoService {

    private final ProdutoRepository produtoRepository;
    private final CategoriaRepository categoriaRepository;
    private final ConverterMapper converter;
    private final UpdateMapper updateMapper;

    public ProdutoOutDTO criaProduto(ProdutoInDTO dto) {
        vericaIdCategoriaExiste(dto.getCategoria_id());
        ProdutoEntity produto = converter.paraProdutoEntity(dto);
        return converter.paraProdutoOutDTO(produtoRepository.save(produto));
    }


    public ProdutoOutDTO buscaProdutoPorId(Long id) {
        ProdutoEntity produto = produtoRepository.findById(id).orElseThrow(
                () -> new NotFoundtException("nenhum produto encontrado para este id:  " + id)
        );
        return converter.paraProdutoOutDTO(produto);
    }


    public ProdutoOutDTO atualizaProduto(Long id, ProdutoInDTO dto) {
        vericaIdCategoriaExiste(dto.getCategoria_id());
        ProdutoEntity produto = produtoRepository.findById(id).orElseThrow(
                () -> new NotFoundtException("nenhum produto encontrado para este id:  " + id)
        );
        updateMapper.updateProduto(dto, produto);
        return converter.paraProdutoOutDTO(produtoRepository.save(produto));
    }

    public void deletaProduto(Long id) {
        ProdutoEntity produto = produtoRepository.findById(id).orElseThrow(
                () -> new NotFoundtException("nenhum produto encontrado para este id:  " + id)
        );
        produtoRepository.delete(produto);
    }

    public void vericaIdCategoriaExiste(Long id) {
        if (id != null) {
            Boolean existe = categoriaRepository.existsById(id);
            if (!existe) {
                throw new BadRequestException("categoria_id nao existe: " + id);


            }
        }
    }
}