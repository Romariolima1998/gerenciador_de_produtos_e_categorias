package com.romario.gerenciador_de_produtos.business.converter;

import com.romario.gerenciador_de_produtos.business.dto.CategoriaInDTO;
import com.romario.gerenciador_de_produtos.business.dto.CategoriaOutDTO;
import com.romario.gerenciador_de_produtos.business.dto.ProdutoInDTO;
import com.romario.gerenciador_de_produtos.business.dto.ProdutoOutDTO;
import com.romario.gerenciador_de_produtos.infrastructure.entity.CategoriaEntity;
import com.romario.gerenciador_de_produtos.infrastructure.entity.ProdutoEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ConverterMapper {

    ProdutoEntity paraProdutoEntity(ProdutoInDTO dto);
    ProdutoOutDTO paraProdutoOutDTO(ProdutoEntity entity);

    CategoriaEntity paraCategoriaEntity(CategoriaInDTO dto);
    CategoriaOutDTO paraCategoriaOutDTO(CategoriaEntity entity);
    List<CategoriaOutDTO> palaListCategoriaDTO(List<CategoriaEntity> entities);
}
