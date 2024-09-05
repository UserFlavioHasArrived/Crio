package com.crio.api.repositorie;

import com.crio.api.domain.evento.Evento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface EventoRepository extends
        JpaRepository<Evento, UUID> {
    // findEventosbyTitle() implementar
    //findEventosbyDate()
}
