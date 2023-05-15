package br.com.edusync.desafio6.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.List;
@Data
@Entity
public class ClinicaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nome_clinica", length = 50)
    private String nomedaClinica;

    private String telefone;

    private String endereco;

    @JoinColumn(name = "id_veterinario", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "clinica"})
    @OneToMany(fetch = FetchType.LAZY)
    private List<VeterinarioModel> veterinario;
}
