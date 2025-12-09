package com.romario.gerenciador_de_produtos.business.dto;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CategoriaOutDTO {

    private Long id;

    private String nome;

}
