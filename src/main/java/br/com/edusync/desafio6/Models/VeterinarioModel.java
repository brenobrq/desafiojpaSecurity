package br.com.edusync.desafio6.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
@Data
@Entity
public class VeterinarioModel {

    @Id
    private Integer CFMV;

    private String nome;

    private String telefone;

    private String endereco;

    @JoinColumn(name = "id_clinica", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "clinica"})
    @ManyToOne(fetch = FetchType.LAZY)
    private ClinicaModel clinica;
}
