package com.example.demo.modelos;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "asistencia")
public class Asistencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String nombrePersona;

    @Column
    private String correoPersona;

    @Column
    private String tituloCurso;

    @Column(nullable = false)
    private LocalDate fecha;

    @Column(nullable = false)
    private LocalTime horaEntrada;

    @Column(nullable = false)
    private Boolean asistio;

    @Column(nullable = false)
    private Boolean tieneExcusa = false;

    @Column(length = 500)
    private String excusa;

    // Constructor vacío obligatorio para JPA
    public Asistencia() {}

    // Getters y Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getNombrePersona() { return nombrePersona; }
    public void setNombrePersona(String nombrePersona) { this.nombrePersona = nombrePersona; }

    public String getCorreoPersona() { return correoPersona; }
    public void setCorreoPersona(String correoPersona) { this.correoPersona = correoPersona; }

    public String getTituloCurso() { return tituloCurso; }
    public void setTituloCurso(String tituloCurso) { this.tituloCurso = tituloCurso; }

    public LocalDate getFecha() { return fecha; }
    public void setFecha(LocalDate fecha) { this.fecha = fecha; }

    public LocalTime getHoraEntrada() { return horaEntrada; }
    public void setHoraEntrada(LocalTime horaEntrada) { this.horaEntrada = horaEntrada; }

    public Boolean getAsistio() { return asistio; }
    public void setAsistio(Boolean asistio) { this.asistio = asistio; }

    public Boolean getTieneExcusa() { return tieneExcusa; }
    public void setTieneExcusa(Boolean tieneExcusa) { this.tieneExcusa = tieneExcusa; }

    public String getExcusa() { return excusa; }
    public void setExcusa(String excusa) { this.excusa = excusa; }
}
