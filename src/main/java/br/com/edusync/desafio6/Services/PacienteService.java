package br.com.edusync.desafio6.Services;

import br.com.edusync.desafio6.Models.ClinicaModel;
import br.com.edusync.desafio6.Models.PacienteModel;
import br.com.edusync.desafio6.Repositories.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class PacienteService {
    @Autowired
    private PacienteRepository pacienteRepository;

    public void adicionar(PacienteModel paciente){
        pacienteRepository.save(paciente);
    }

    public PacienteModel buscarPorId(Integer id){
        Optional<PacienteModel> pacienteModelOptional = pacienteRepository.findById(id);
        if (pacienteModelOptional.isEmpty()){
            return null;
        }
        return pacienteModelOptional.get();
    }

    public void update(Integer id, PacienteModel paciente) {
        PacienteModel verifica = buscarPorId(id);

        paciente.setId(verifica.getId());
        if (pacienteRepository.existsById(id)){
            pacienteRepository.save(paciente);
        }
    }

    public void delete(Integer id) {
        if (pacienteRepository.existsById(id)){
            pacienteRepository.deleteById(id);
        }
    }


    }



