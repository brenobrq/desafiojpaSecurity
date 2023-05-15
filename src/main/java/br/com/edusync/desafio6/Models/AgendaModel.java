package br.com.edusync.desafio6.Models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
@Data
@Entity
public class AgendaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    @Column(name = "data_hora")
    private Date dataHora;

    @Column(name = "nome_medico", length = 50)
    private String nomeDoMedico;

    @Column(name = "nome_paciente", length = 50)
    private String nomeDoPaciente;
    @ManyToOne
    private VeterinarioModel veterinario;
    @ManyToOne
    private PacienteModel animal;
}