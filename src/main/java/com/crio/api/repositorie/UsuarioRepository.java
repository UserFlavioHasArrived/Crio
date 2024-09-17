package com.crio.api.repositorie;

import com.crio.api.domain.evento.Evento;
import com.crio.api.domain.usuario.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Repository
public interface UsuarioRepository extends
        JpaRepository<Usuario, UUID> {
    //selecionar todos os usuarios
    @Query("SELECT u FROM Usuario u")
    List<Usuario> findAllUsuario();
    //selecionar um usuario pelo seu id
    @Query("SELECT u FROM Usuario u WHERE u.id = :id")
    Optional<Usuario> findByIdUsuario(UUID id);
    //salvar um usuario MÈTODO INSERT NÂO ESTÀ HABILITADO NO @Query
//    @Query("INSERT INTO Usuario(nomeCompleto, email, senha, tipo,createdAt,updatedAt) VALUES(:nomeCompleto,:email,:senha,:tipo,:createdAt,:updatedAt)")
//    Usuario saveUsuario(String nomeCompleto, String email, String senha,
//                 int tipo, LocalDateTime createdAt, LocalDateTime updatedAt);
    //atualizar usuario
    @Query("UPDATE Usuario u SET u.nomeCompleto=:nomeCompleto, "+
    "u.email = :email, u.senha = :senha, u.tipo = :tipo, "+
    "u.updatedAt = :updatedAt WHERE u.id = :id")
    void updateUsuario(UUID id,String nomeCompleto, String email, String senha,
                int tipo, LocalDateTime updatedAt);
    //deletar usuario
    @Query("DELETE FROM Usuario u WHERE u.id = :id")
    void deleteByIdUsuario(UUID id);

    //procurar por email
    @Query("SELECT u FROM Usuario u WHERE u.email = :email")
    Optional<Usuario> findByEmail(String email);

    //procurar por tipo
    @Query("SELECT u FROM Usuario u WHERE u.tipo = :tipo")
    List<Usuario> findByTipo(int tipo);

    // procurar por tempo
    @Query("SELECT u FROM Usuario u WHERE u.createdAt BETWEEN :start AND :end")
    List<Usuario> findByCreatedAtBetween(LocalDateTime start,LocalDateTime end);
}
