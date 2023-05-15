package br.com.edusync.desafio6.Repositories;


import br.com.edusync.desafio6.Models.AgendaModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgendaRepository extends JpaRepository<AgendaModel, Integer> {
}
