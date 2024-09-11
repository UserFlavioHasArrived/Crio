package com.crio.api.domain.evento;
import com.crio.api.domain.usuario.Usuario;

import java.time.LocalDateTime;

public record EventoResponseDTO(
            String titulo,
            String descricao,
            LocalDateTime inicio,
            LocalDateTime fim,
            String local,
            Boolean privado,
            Usuario usuario
    ) {
    }
