package com.crio.api.domain.evento;

import com.crio.api.domain.endereco.Endereco;
import com.crio.api.domain.usuario.Usuario;

import java.time.LocalDateTime;

public record EventoRequestDTO(
        String titulo,
        String descricao,
        LocalDateTime inicio,
        LocalDateTime fim,
        String local,
        boolean privado,
        String linkEvento,
        String comoChegar,
        String linkForms,
        Usuario usuario,
        Endereco endereco) { }
