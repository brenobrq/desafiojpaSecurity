package br.com.edusync.desafio6.Repositories;

import br.com.edusync.desafio6.Models.ClinicaModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClinicaRepository extends JpaRepository<ClinicaModel, Integer> {
}
