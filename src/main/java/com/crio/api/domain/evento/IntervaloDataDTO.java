package com.crio.api.domain.evento;

import java.time.LocalDateTime;

public record IntervaloDataDTO(
        LocalDateTime inicio,
        LocalDateTime fim
) {
}
