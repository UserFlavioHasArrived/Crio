package com.crio.api.domain.evento;

import java.time.LocalDateTime;

public class EventoRequestDTO {
    String titulo;
    String descricao;
    LocalDateTime inicio;
    LocalDateTime fim;
    String local;
    Boolean privado;
}
