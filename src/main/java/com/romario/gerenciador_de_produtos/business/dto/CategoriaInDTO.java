package com.romario.gerenciador_de_produtos.business.dto;

import com.romario.gerenciador_de_produtos.infrastructure.entity.ProdutoEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CategoriaInDTO {

        private String nome;

}
