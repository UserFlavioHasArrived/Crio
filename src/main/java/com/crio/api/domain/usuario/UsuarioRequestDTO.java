package com.crio.api.domain.usuario;

public record UsuarioRequestDTO(
        String nomeCompleto,
        String email,
        String senha,
        int tipo
) {
}
