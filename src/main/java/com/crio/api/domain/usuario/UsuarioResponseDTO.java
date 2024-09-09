package com.crio.api.domain.usuario;

import java.util.UUID;

public record UsuarioResponseDTO(
        UUID id,
        String nomeCompleto,
        String email,
        String senha,
        int tipo
) {
}
