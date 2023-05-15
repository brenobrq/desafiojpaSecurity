package br.com.edusync.desafio6.Controllers;

import br.com.edusync.desafio6.Models.AgendaModel;
import br.com.edusync.desafio6.Models.PacienteModel;
import br.com.edusync.desafio6.Models.VeterinarioModel;
import br.com.edusync.desafio6.Services.AgendaService;
import br.com.edusync.desafio6.Services.PacienteService;
import br.com.edusync.desafio6.Services.VeterinarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;
@RequestMapping(value = "/agenda")
@RestController
public class AgendaController {

        @Autowired
        private AgendaService agendaservice;

        @Autowired
        private VeterinarioService veterinarioService;

        @Autowired
        private PacienteService pacienteService;

        @PostMapping(value = "/adicionar")
        public ResponseEntity adicione(@RequestBody AgendaModel consulta, @RequestParam Integer veterinarioId, @RequestParam Integer pacienteId){

            VeterinarioModel medico = veterinarioService.buscarPorId(veterinarioId);
            if (medico.getCFMV() != null) {
                consulta.setVeterinario(medico);
                agendaservice.adicionar(consulta);
            }else {
                return new ResponseEntity("CFMV não existente", HttpStatus.NOT_FOUND);
            }

            PacienteModel paciente = pacienteService.buscarPorId(pacienteId);
            if (paciente.getId() != null) {
                consulta.setAnimal(paciente);
                agendaservice.adicionar(consulta);
            }else {
                return new ResponseEntity("Id não existente", HttpStatus.NOT_FOUND);
            }
            try {
                agendaservice.adicionar(consulta);
                return new ResponseEntity(consulta, HttpStatus.CREATED);
            }catch (NoSuchElementException e){
                return new ResponseEntity("Consulta não encontrada", HttpStatus.BAD_REQUEST);
            }
        }

        @GetMapping(value = "/listar/{id}")
        public ResponseEntity listarPorid(@PathVariable Integer id){
            try {
                return new ResponseEntity(agendaservice.buscarPorId(id), HttpStatus.OK);
            }catch (NoSuchElementException e){
                return new ResponseEntity<>("Consulta não encontrada", HttpStatus.NOT_FOUND);
            }
        }


        @PutMapping(value = "/atualizar/{id}")
        public ResponseEntity alterar(@PathVariable Integer id,
                                      @RequestBody AgendaModel agenda){
            try {
                AgendaModel verificarConsulta = agendaservice.buscarPorId(id);



                agendaservice.atualizar(id, agenda);
                return new ResponseEntity("Consulta atualizada",HttpStatus.OK);
            }catch (NoSuchElementException e){
                return new ResponseEntity("Consulta não encontrada", HttpStatus.NOT_FOUND);
            }
        }

        @DeleteMapping(value = "/deletar/{id}")
        public ResponseEntity excluir(@PathVariable Integer id) {
            try {
                agendaservice.delete(id);
                return new ResponseEntity("Consulta desmarcada: " + id, HttpStatus.OK);
            } catch (NoSuchElementException e) {
                return new ResponseEntity("Consulta não encontrada", HttpStatus.NOT_FOUND);
            }
        }
    }


