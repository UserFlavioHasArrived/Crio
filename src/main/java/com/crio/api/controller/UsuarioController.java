package com.crio.api.controller;

import com.crio.api.domain.usuario.Usuario;
import com.crio.api.domain.usuario.UsuarioRequestDTO;
import com.crio.api.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {
    //criar um objeto service
    @Autowired
    private UsuarioService usuarioService;

    //CRUD
    @PostMapping(consumes = "multipart/form-data")
    public ResponseEntity<Usuario> create(
            //mapeamento dos campos
            @RequestParam("nomecompleto") String nomeCompleto,
            @RequestParam("email") String email,
            @RequestParam("senha") String senha,
            @RequestParam("tipo") int tipo){
        UsuarioRequestDTO usuarioRequestDTO =
                new UsuarioRequestDTO(nomeCompleto,email,senha,tipo);
        Usuario newUsuario =
                this.usuarioService.createUsuario(usuarioRequestDTO);
        return ResponseEntity.ok(newUsuario);
    }
    //Retornar todos os usuários
    @GetMapping
    public ResponseEntity<List<Usuario>> getAllUsers(){
        List<Usuario> usuarios = this.usuarioService.getAllUsers();
        //retorna a lista com todos os usuários
        return ResponseEntity.ok(usuarios);
    }
    //Retorna o usuario pelo Id

    @GetMapping("/{id}") //  /api/usuario/12o13y23y-3123-rewre321
    public ResponseEntity<Usuario> getUserById(@PathVariable("id")UUID id){
        Usuario usuario = this.usuarioService.getUserById(id);
        return ResponseEntity.ok(usuario);
    }

    //Atualizar os dados do usuario
    @PutMapping("/{id}")
    public ResponseEntity<Usuario> updateUser(
            @PathVariable("id")UUID id, UsuarioRequestDTO usuarioRequestDTO){
        Usuario updatedUsuario = this.usuarioService.updateUser(id,usuarioRequestDTO);
        System.out.println(usuarioRequestDTO);
        return ResponseEntity.ok(updatedUsuario);
    }
    //deletar Usuario
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable("id")UUID id){
        this.usuarioService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

    //    @Query("SELECT u FROM Usuario u WHERE u.email = :email")
//    Optional<Usuario> findByEmail(String email);
    @GetMapping("/email/{email}")
    public ResponseEntity<Optional<Usuario>> findByEmail(@PathVariable String email){
        Optional<Usuario> usuario = usuarioService.findByEmail(email);
        return ResponseEntity.ok(usuario);
    }


}