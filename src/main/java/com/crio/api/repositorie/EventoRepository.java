package com.crio.api.repositorie;

import com.crio.api.domain.evento.Evento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
@Repository
public interface EventoRepository extends
        JpaRepository<Evento, UUID> {

    //buscar todos os eventos por usuario
    @Query("SELECT e FROM Evento e WHERE e.usuario.id = :usuarioId")
    List<Evento> findByUsuarioId(UUID usuarioId);
    @Query("SELECT e FROM Evento e WHERE e.inicio BETWEEN :inicio AND :fim")
    List<Evento> findByIntervaloData(LocalDateTime inicio,LocalDateTime fim);
    @Query("SELECT e FROM Evento e WHERE e.local = :local")
    List<Evento> findByLocal(String local);
    //consulta por local e intervalo de data
    @Query("SELECT e FROM Evento e WHERE e.local = :local AND "+
    "e.inicio BETWEEN :inicio AND :fim")
    List<Evento> findByLocalAndIntervaloData(String local,
                                             LocalDateTime inicio,
                                             LocalDateTime fim);
}
