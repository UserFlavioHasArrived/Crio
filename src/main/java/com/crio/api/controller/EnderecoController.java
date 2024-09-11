package com.crio.api.controller;

import com.crio.api.domain.endereco.Endereco;
import com.crio.api.domain.endereco.EnderecoRequestDTO;
import com.crio.api.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/endereco")
public class EnderecoController {
    //criar um objeto service
    @Autowired
    private EnderecoService enderecoService;
    //CRUD
    @PostMapping(consumes = "multipart/form-data")
    public ResponseEntity<Endereco> create(
            //mapeamento dos campos
            @RequestParam("city") String city,
            @RequestParam("uf") String uf
            ){
        EnderecoRequestDTO enderecoRequestDTO =
                new EnderecoRequestDTO(city,uf);
        Endereco newEndereco =
                this.enderecoService.createEndereco(enderecoRequestDTO);
        return ResponseEntity.ok(newEndereco);
    }
    //Retornar todos os usuários
    @GetMapping
    public ResponseEntity<List<Endereco>> getAllUsers(){
        List<Endereco> enderecos = this.enderecoService.getAllEnderecos();
        //retorna a lista com todos os usuários
        return ResponseEntity.ok(enderecos);
    }
    //Retorna o endereco pelo Id
    @GetMapping("/{id}") //  /api/endereco/12o13y23y-3123-rewre321
    public ResponseEntity<Endereco> getUserById(@PathVariable("id")UUID id){
        Endereco endereco = this.enderecoService.getEnderecoById(id);
        return ResponseEntity.ok(endereco);
    }

    //Atualizar os dados do endereco
    @PutMapping("/{id}")
    public ResponseEntity<Endereco> updateUser(
            @PathVariable("id")UUID id, EnderecoRequestDTO enderecoRequestDTO){
        Endereco updatedEndereco = this.enderecoService.updateEndereco(id,enderecoRequestDTO);
        System.out.println(enderecoRequestDTO);
        return ResponseEntity.ok(updatedEndereco);
    }
    //deletar Endereco
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable("id")UUID id){
        this.enderecoService.deleteEndereco(id);
        return ResponseEntity.noContent().build();
    }

}

