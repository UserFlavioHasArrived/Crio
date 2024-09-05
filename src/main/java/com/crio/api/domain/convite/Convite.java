package com.crio.api.domain.convite;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Table(name = "convite")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Convite {
    @Id
    @GeneratedValue
    private UUID id;

    private boolean confirmacaoPresenca;
}
