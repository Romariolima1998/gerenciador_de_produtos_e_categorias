package com.romario.gerenciador_de_produtos.infrastructure.repository;

import com.romario.gerenciador_de_produtos.infrastructure.entity.CategoriaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<CategoriaEntity, Long> {


}
