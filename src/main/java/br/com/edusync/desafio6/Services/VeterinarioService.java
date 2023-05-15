package br.com.edusync.desafio6.Services;

import br.com.edusync.desafio6.Models.VeterinarioModel;
import br.com.edusync.desafio6.Repositories.VeterinarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class VeterinarioService {
    @Autowired
    private VeterinarioRepository veterinarioRepository;

    public void adicionar(VeterinarioModel veterinario){
        veterinarioRepository.save(veterinario);
    }

    public VeterinarioModel buscarPorId(Integer id){
        Optional<VeterinarioModel> veterinarioModelOptional = veterinarioRepository.findById(id);
        if (veterinarioModelOptional.isEmpty()){
            return null;
        }
        return veterinarioModelOptional.get();
    }

    public void atualizar(Integer id, VeterinarioModel veterinario) {
        VeterinarioModel verificar = buscarPorId(id);

        veterinario.setClinica(verificar.getClinica());

        if (veterinarioRepository.existsById(id)){
            veterinarioRepository.save(veterinario);
        }
    }

    public void delete(Integer id) {
        if (veterinarioRepository.existsById(id)){
            veterinarioRepository.deleteById(id);
        }
    }
}


