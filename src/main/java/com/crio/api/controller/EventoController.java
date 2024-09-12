package com.crio.api.controller;

import com.crio.api.domain.endereco.Endereco;
import com.crio.api.domain.evento.Evento;
import com.crio.api.domain.evento.EventoRequestDTO;
import com.crio.api.domain.usuario.Usuario;
import com.crio.api.service.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/evento")
public class EventoController {
    //criar um objeto service
    @Autowired
    private EventoService eventoService;
    //CRUD
    @PostMapping(consumes = "multipart/form-data")
    public ResponseEntity<Evento> create(
            //mapeamento dos campos
            @RequestParam("titulo") String titulo,
            @RequestParam("descricao") String descricao,
            @RequestParam("inicio") LocalDateTime inicio,
            @RequestParam("fim") LocalDateTime fim,
            @RequestParam("local")String local,
            @RequestParam("privado") Boolean privado,
            @RequestParam("linkEvento") String linkEvento,
            @RequestParam("comoChegar") String comoChegar,
            @RequestParam("linkForms") String linkForms,
            @RequestParam("usuario") Usuario usuario,
            @RequestParam("endereco") Endereco endereco
            ){
        EventoRequestDTO eventoRequestDTO =
                new EventoRequestDTO(titulo,descricao,inicio,fim,local,privado,linkEvento,comoChegar,linkForms,usuario,endereco);
        Evento newEvento =
                this.eventoService.createEvento(eventoRequestDTO);
        return ResponseEntity.ok(newEvento);
    }
    //Retornar todos os usuários
    @GetMapping
    public ResponseEntity<List<Evento>> getAllEventos(){
        List<Evento> eventos = this.eventoService.getAllEventos();
        //retorna a lista com todos os usuários
        return ResponseEntity.ok(eventos);
    }
    //Retorna o evento pelo Id
    @GetMapping("/{id}") //  /api/evento/12o13y23y-3123-rewre321
    public ResponseEntity<Evento> getEventoById(@PathVariable("id")UUID id){
        Evento evento = this.eventoService.getEventoById(id);
        return ResponseEntity.ok(evento);
    }

    //Atualizar os dados do evento
    @PutMapping("/{id}")
    public ResponseEntity<Evento> updateEvento(
            @PathVariable("id")UUID id, EventoRequestDTO eventoRequestDTO){
        Evento updatedEvento = this.eventoService.updateEvento(id,eventoRequestDTO);
        System.out.println(eventoRequestDTO);
        return ResponseEntity.ok(updatedEvento);
    }
    //deletar Evento
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEvento(@PathVariable("id")UUID id){
        this.eventoService.deleteEvento(id);
        return ResponseEntity.noContent().build();
    }

}
