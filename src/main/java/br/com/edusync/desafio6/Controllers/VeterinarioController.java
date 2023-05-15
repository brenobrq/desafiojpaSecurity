package br.com.edusync.desafio6.Controllers;

import br.com.edusync.desafio6.Models.PacienteModel;
import br.com.edusync.desafio6.Models.VeterinarioModel;
import br.com.edusync.desafio6.Services.PacienteService;
import br.com.edusync.desafio6.Services.VeterinarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping(value = "/veterinario")
public class VeterinarioController {
        @Autowired
        private VeterinarioService veterinarioService;

        @PostMapping("/adicionar")
        public ResponseEntity adicionar(@RequestBody VeterinarioModel veterinario) {
            veterinarioService.adicionar(veterinario);
            return new ResponseEntity("Veterinario adicionado com sucesso", HttpStatus.CREATED);
        }

        @GetMapping("/listar/{id}")
        public ResponseEntity listarPorId(@PathVariable Integer CFMV) {
            VeterinarioModel veterinario = veterinarioService.buscarPorId(CFMV);
            if (veterinario == null) {
                return new ResponseEntity("Veterinario não encontrado", HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity(veterinario, HttpStatus.OK);
        }

        public ResponseEntity atualizar(@PathVariable Integer CFMV, @RequestBody VeterinarioModel veterinario) {
            VeterinarioModel veterinarioAtualizado = veterinarioService.buscarPorId(CFMV);
            if (veterinarioAtualizado == null) {
                return new ResponseEntity("Veterinario não encontrado", HttpStatus.NOT_FOUND);
            }
            veterinarioService.atualizar(CFMV, veterinario);
            return new ResponseEntity("Veterinario atualizado com sucesso", HttpStatus.OK);
        }

        @DeleteMapping("/deletar/{id}")
        public ResponseEntity deletar(@PathVariable Integer CFMV) {
            VeterinarioModel veterinario = veterinarioService.buscarPorId(CFMV);
            if (veterinario == null) {
                return new ResponseEntity("Veterinario não encontrado", HttpStatus.NOT_FOUND);
            }
            veterinarioService.delete(CFMV);
            return new ResponseEntity("Veterinario deletado com sucesso", HttpStatus.OK);
        }
    }

