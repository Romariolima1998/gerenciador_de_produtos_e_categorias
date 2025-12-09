package com.romario.gerenciador_de_produtos.business.dto;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ProdutoOutDTO {

    private Long id;

    private String nome;

    private String descricao;

    private BigDecimal preco;

    private Long categoria_id;

}
