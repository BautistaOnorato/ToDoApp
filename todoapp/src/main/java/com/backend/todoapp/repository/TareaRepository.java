package com.backend.todoapp.repository;

import com.backend.todoapp.entity.Tarea;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TareaRepository extends JpaRepository<Tarea, Integer> {
    List<Tarea> findByUsuarioId(Integer id);
}
