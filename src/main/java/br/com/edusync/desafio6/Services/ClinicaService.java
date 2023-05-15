package br.com.edusync.desafio6.Services;

import br.com.edusync.desafio6.Models.ClinicaModel;
import br.com.edusync.desafio6.Repositories.ClinicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClinicaService {
        @Autowired
        private ClinicaRepository clinicarepository;

        public void adicionar(ClinicaModel clinica){
            clinicarepository.save(clinica);
        }

        public ClinicaModel buscarPorId(Integer id){
            Optional<ClinicaModel> clinicaModelOptional = clinicarepository.findById(id);
            if (clinicaModelOptional.isEmpty()){
                return null;
            }
            return clinicaModelOptional.get();
        }

        public void update(Integer id, ClinicaModel clinica) {
            ClinicaModel verifica = buscarPorId(id);

            clinica.setVeterinario(verifica.getVeterinario());

            if (clinicarepository.existsById(id)){
                clinicarepository.save(clinica);
            }
        }

        public void delete(Integer id) {
            if (clinicarepository.existsById(id)){
                clinicarepository.deleteById(id);
            }
        }

        public List<ClinicaModel> listarTodos() {
            return clinicarepository.findAll();
        }

    }

