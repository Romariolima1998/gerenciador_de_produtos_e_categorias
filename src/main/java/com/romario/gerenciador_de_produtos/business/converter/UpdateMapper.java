package com.romario.gerenciador_de_produtos.business.converter;

import com.romario.gerenciador_de_produtos.business.dto.ProdutoInDTO;
import com.romario.gerenciador_de_produtos.infrastructure.entity.ProdutoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface UpdateMapper {
    void updateProduto(ProdutoInDTO dto, @MappingTarget ProdutoEntity entity);
}
