package br.com.edusync.desafio6.Models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
public class PacienteModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nome_animal", length = 50)
    private String nomeDoAnimal;

    private String especie;

    private String raca;

    @Column(name = "data_nascimento")
    private Date dataDeNascimento;

}
