package com.romario.gerenciador_de_produtos.infrastructure.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "categoria")
public class CategoriaEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "categoria_id", referencedColumnName = "id")
    private List<ProdutoEntity> produtos;
}
