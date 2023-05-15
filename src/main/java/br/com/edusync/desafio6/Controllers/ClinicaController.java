package br.com.edusync.desafio6.Controllers;

import br.com.edusync.desafio6.Models.ClinicaModel;
import br.com.edusync.desafio6.Services.ClinicaService;
import jakarta.validation.constraints.Max;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/clinica")
public class ClinicaController {
    @Autowired
    private ClinicaService clinicaService;

    @PostMapping("/adicionar")
    public ResponseEntity adicionar(@RequestBody ClinicaModel clinica) {
        clinicaService.adicionar(clinica);
        return new ResponseEntity("Clinica adicionada com sucesso", HttpStatus.CREATED);
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity listarPorId(@PathVariable Integer id) {
        ClinicaModel clinica = clinicaService.buscarPorId(id);
        if (clinica == null) {
            return new ResponseEntity("Clinica não encontrada", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(clinica, HttpStatus.OK);
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity atualizar(@PathVariable Integer id, @RequestBody ClinicaModel clinica) {
        ClinicaModel clinicaAtualizada = clinicaService.buscarPorId(id);
        if (clinicaAtualizada == null) {
            return new ResponseEntity("Clinica não encontrada", HttpStatus.NOT_FOUND);
        }
        clinicaService.update(id, clinica);
        return new ResponseEntity("Clinica atualizada com sucesso", HttpStatus.OK);
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity deletar(@PathVariable Integer id) {
        ClinicaModel clinica = clinicaService.buscarPorId(id);
        if (clinica == null) {
            return new ResponseEntity("Clinica não encontrada", HttpStatus.NOT_FOUND);
        }
        clinicaService.delete(id);
        return new ResponseEntity("Clinica deletada com sucesso", HttpStatus.OK);
    }

    @GetMapping("/listar-todos")
    public ResponseEntity listarTodos() {
        List<ClinicaModel> clinicas = clinicaService.listarTodos();
        if (clinicas.isEmpty()) {
            return new ResponseEntity("Não existem clínicas cadastradas", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(clinicas, HttpStatus.OK);
    }
}

