package com.crio.api.repositorie;

import com.crio.api.domain.convite.Convite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface ConviteRepository extends
        JpaRepository<Convite, UUID> {
}
