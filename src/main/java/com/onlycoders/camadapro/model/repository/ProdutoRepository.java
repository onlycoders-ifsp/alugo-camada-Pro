package com.onlycoders.camadapro.model.repository;

import com.onlycoders.camadapro.model.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
    Optional<Produto> getByNome(String nome);
    List<Produto> getByLocatarioCodigo(String codigo);
}
