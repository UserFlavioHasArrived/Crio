package com.crio.api.domain.evento;

import java.time.LocalDateTime;

public record LocalIntervaloDTO(
        String local,
        LocalDateTime inicio,
        LocalDateTime fim ) {

}
