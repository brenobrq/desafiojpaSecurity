package br.com.edusync.desafio6.Repositories;


import br.com.edusync.desafio6.Models.PacienteModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<PacienteModel, Integer>{
}
