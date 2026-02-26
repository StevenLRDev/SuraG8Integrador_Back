package com.example.demo.servicios;

import com.example.demo.modelos.Asistencia;
import com.example.demo.repositorios.IRepositorioAsistencia;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicioAsistencia {

    private final IRepositorioAsistencia repository;

    public ServicioAsistencia(IRepositorioAsistencia repository) {
        this.repository = repository;
    }

    public Asistencia crear(Asistencia asistencia) {
        if (asistencia.getNombrePersona() == null || asistencia.getNombrePersona().isBlank()) {
            throw new IllegalArgumentException("El nombre es obligatorio");
        }
        if (asistencia.getFecha() == null) {
            throw new IllegalArgumentException("La fecha es obligatoria");
        }
        if (asistencia.getHoraEntrada() == null) {
            throw new IllegalArgumentException("La hora de entrada es obligatoria");
        }
        if (asistencia.getAsistio() == null) {
            asistencia.setAsistio(false);
        }

        // Defaults para nuevos campos
        if (asistencia.getTieneExcusa() == null) {
            asistencia.setTieneExcusa(false);
        }

        // Reglas de negocio
        if (Boolean.TRUE.equals(asistencia.getAsistio())) {
            asistencia.setTieneExcusa(false);
            asistencia.setExcusa(null);
        } else {
            if (Boolean.TRUE.equals(asistencia.getTieneExcusa())) {
                if (asistencia.getExcusa() == null || asistencia.getExcusa().isBlank()) {
                    throw new IllegalArgumentException("Debe escribir la excusa cuando aplica");
                }
            } else {
                asistencia.setExcusa(null);
            }
        }

        return repository.save(asistencia);
    }

    public List<Asistencia> obtenerTodas() {
        return repository.findAll();
    }

    public Asistencia obtenerPorId(Integer id) {
        Optional<Asistencia> resultado = repository.findById(id);
        if (resultado.isPresent()) {
            return resultado.get();
        } else {
            throw new RuntimeException("Asistencia con ID " + id + " no encontrada");
        }
    }
}