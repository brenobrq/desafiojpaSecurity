package br.com.edusync.desafio6.Repositories;


import br.com.edusync.desafio6.Models.VeterinarioModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VeterinarioRepository extends JpaRepository<VeterinarioModel, Integer> {
}
