package com.backend.todoapp.controller;

import com.backend.todoapp.entity.Tarea;
import com.backend.todoapp.exceptions.GlobalException;
import com.backend.todoapp.exceptions.ResourceNotFoundException;
import com.backend.todoapp.service.TareaService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/tasks")
@RequiredArgsConstructor
public class TareaController {
    private final TareaService tareaService;

    @GetMapping
    public ResponseEntity<?> listarTareas() {
        try {
            return ResponseEntity.ok(tareaService.buscarTareas());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarTarea(@PathVariable Integer id) throws Exception {
        try {
            return ResponseEntity.ok(tareaService.buscarTareaXId(id));
        } catch (ResourceNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (MethodArgumentTypeMismatchException matme){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(matme.getMessage());
        }
    }
    @GetMapping("/user/{id}")
    public ResponseEntity<?> buscarTareasXUsuario(@PathVariable Integer id) throws Exception {
        try {
            return ResponseEntity.ok(tareaService.buscarTareasPorUsuario(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
    @PostMapping
    public ResponseEntity<?> guardarTarea(@RequestBody Tarea tarea) {
        try {
            tarea.setFechaCreacion(LocalDate.now());
            return ResponseEntity.ok(tareaService.guardarTarea(tarea));
        } catch (ConstraintViolationException e) {
            return new GlobalException().handleConstraintViolationException(e);
        }
    }
    @PutMapping
    public ResponseEntity<?> actualizarTarea(@RequestBody Tarea tarea) throws Exception {
        try {
            tareaService.actualizarTarea(tarea);
            Optional<Tarea> nuevaTarea = tareaService.buscarTareaXId(tarea.getId());
            return ResponseEntity.ok(nuevaTarea);
        } catch (EntityNotFoundException enfe) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(enfe.getMessage());
        } catch (ConstraintViolationException e) {
            return new GlobalException().handleConstraintViolationException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarTarea(@PathVariable Integer id) throws Exception {
        try {
            tareaService.borrarTarea(id);
            return ResponseEntity.ok("Se elimino el producto con ID: "+id+" de la BBDD exitosamente");
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

}
