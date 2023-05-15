package br.com.edusync.desafio6.Controllers;


import br.com.edusync.desafio6.Models.ClinicaModel;
import br.com.edusync.desafio6.Models.PacienteModel;
import br.com.edusync.desafio6.Services.ClinicaService;
import br.com.edusync.desafio6.Services.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/paciente")
public class PacienteController {
    @Autowired
    private PacienteService pacienteService;

    @PostMapping("/adicionar")
    public ResponseEntity adicionar(@RequestBody PacienteModel paciente) {
        pacienteService.adicionar(paciente);
        return new ResponseEntity("Paciente adicionado com sucesso", HttpStatus.CREATED);
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity listarPorId(@PathVariable Integer id) {
        PacienteModel paciente = pacienteService.buscarPorId(id);
        if (paciente == null) {
            return new ResponseEntity("Paciente não encontrado", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(paciente, HttpStatus.OK);
    }

    public ResponseEntity atualizar(@PathVariable Integer id, @RequestBody PacienteModel paciente) {
        PacienteModel pacineteAtualizado = pacienteService.buscarPorId(id);
        if (pacineteAtualizado == null) {
            return new ResponseEntity("Clinica não encontrada", HttpStatus.NOT_FOUND);
        }
        pacienteService.update(id, paciente);
        return new ResponseEntity("Clinica atualizada com sucesso", HttpStatus.OK);
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity deletar(@PathVariable Integer id) {
        PacienteModel paciente = pacienteService.buscarPorId(id);
        if (paciente == null) {
            return new ResponseEntity("Paciente não encontrado", HttpStatus.NOT_FOUND);
        }
        pacienteService.delete(id);
        return new ResponseEntity("Paciente deletado com sucesso", HttpStatus.OK);
    }
}
