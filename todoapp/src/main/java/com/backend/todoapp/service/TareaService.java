package com.backend.todoapp.service;

import com.backend.todoapp.entity.Tarea;
import com.backend.todoapp.exceptions.BadRequestException;
import com.backend.todoapp.repository.TareaRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TareaService {
    private final TareaRepository tareaRepository;

    public Tarea guardarTarea(Tarea tarea) throws ConstraintViolationException {
        try {
            return tareaRepository.save(tarea);
        } catch (ConstraintViolationException e) {
            throw e;
        }
    }

    public List<Tarea> buscarTareas() throws Exception {
        try {
            return tareaRepository.findAll();
        } catch (Exception e) {
            throw new BadRequestException("Ocurrio un error al listar todas las tareas");
        }
    }

    public Optional<Tarea> buscarTareaXId(Integer id) throws Exception {
        try {
            return tareaRepository.findById(id);
        } catch (EntityNotFoundException enfe) {
            throw new EntityNotFoundException(enfe.getMessage());
        } catch (DataAccessException dae) {
            throw new Exception("Error al acceder a la base de datos. Mensaje: " + dae.getMessage());
        }
    }

    public List<Tarea> buscarTareasPorUsuario(Integer id) throws BadRequestException {
        try {
            return tareaRepository.findByUsuarioId(id);
        } catch (Exception e) {
            throw new BadRequestException("Ocurrio un error al listar todas las tareas del usuario " + id);
        }
    }

    public void borrarTarea(Integer id) throws Exception {
        try {
            tareaRepository.deleteById(id);
        } catch (Exception e) {
            throw new Exception("Ocurrio un error al eliminar la tarea");
        }
    }

    public void actualizarTarea(Tarea tarea) throws Exception {
        try {
            tareaRepository.save(tarea);
        } catch (ConstraintViolationException e) {
            throw e;
        }
    }
}
