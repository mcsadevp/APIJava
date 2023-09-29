package org.api.api.Services;

import org.api.api.Models.Tarea;
import org.api.api.Models.Usuario;
import org.api.api.Repositories.ComentarioRepository;
import org.api.api.Repositories.TareaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TareaServiceImple implements TareaService{

    @Autowired
    TareaRepository tareaRepository;

    @Override
    public Tarea agregaTarea(Tarea tareaNueva) {
        return tareaRepository.save(tareaNueva);
    }

    @Override
    public void borrarTarea(Long id) {
    tareaRepository.deleteById(id);
    }

    @Override
    public List<Tarea> listaTarea() {
        return tareaRepository.findAll();
    }

    @Override
    public Tarea buscarTareaPorId(Long id) {
        Boolean existe = tareaRepository.existsById(id);
        if (existe){
            Tarea tareaselec = tareaRepository.findById(id).get();
            return tareaselec;
        }else {
            System.out.println("El Id es invalido");
            return null;
        }
    }

    @Override
    public Tarea editarTareaPorId(Long id, Tarea tareaActualizada) {
        Boolean existe = tareaRepository.existsById(id);
        if (existe){
            Tarea tareaselec = tareaRepository.findById(id).get();
            tareaselec.setTarea(tareaActualizada.getTarea());
            tareaselec.setDescripcion(tareaActualizada.getDescripcion());
            tareaselec.setFechaV(tareaActualizada.getFechaV());
            System.out.println("Tarea actualizada");
            return tareaRepository.save(tareaselec);
        }else {
            System.out.println("Id invalido");
            return null;
        }

    }


}
