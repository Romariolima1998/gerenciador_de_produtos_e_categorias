package com.romario.gerenciador_de_produtos.business.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ProdutoInDTO {

    private String nome;

    private String descricao;

    private BigDecimal preco;

    private Long categoria_id;

}
