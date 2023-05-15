package br.com.edusync.desafio6.Services;

import br.com.edusync.desafio6.Models.AgendaModel;
import br.com.edusync.desafio6.Repositories.AgendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class AgendaService {

        @Autowired
        private AgendaRepository agendaRepository;


        public void adicionar(AgendaModel agenda){
            agendaRepository.save(agenda);
        }

        public AgendaModel buscarPorId(Integer id){
            Optional<AgendaModel> agendaModelOptional = agendaRepository.findById(id);
            if (agendaModelOptional.isEmpty()){
                return null;
            }
            return agendaModelOptional.get();
        }

        public void atualizar(Integer id, AgendaModel agenda) {
            AgendaModel verificar = buscarPorId(id);

            agenda.setAnimal(verificar.getAnimal());
            agenda.setVeterinario(verificar.getVeterinario());

            if (agendaRepository.existsById(id)){
                agendaRepository.save(agenda);
            }
        }

        public void delete(Integer id) {
            if (agendaRepository.existsById(id)) {
                agendaRepository.deleteById(id);
            }
        }
}


