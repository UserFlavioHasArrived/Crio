package com.crio.api.repositorie;

import com.crio.api.domain.endereco.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface EnderecoRepository extends JpaRepository<Endereco, UUID> {
    // buscar todos os endereços de uma determinada cidade
    @Query("SELECT e FROM Endereco e WHERE e.city = :city")
    List<Endereco> findByCity(@Param("city") String city);

    // buscar todos os endereços de uma determinada unidade federativa
    @Query("SELECT e FROM Endereco e WHERE e.uf = :uf")
    List<Endereco> findByUf(@Param("uf") String uf);


}
