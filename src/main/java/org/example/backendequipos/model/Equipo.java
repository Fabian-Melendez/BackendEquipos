package org.example.backendequipos.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "equipo")
public class Equipo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEquipo;

    @Column(nullable = false)
    private String nombre;

    private String ciudad;

    private LocalDate fundacion;

    public Equipo() {
    }

    public Equipo(Long idEquipo, String nombre, String ciudad, LocalDate fundacion) {
        this.idEquipo = idEquipo;
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.fundacion = fundacion;
    }

    public Long getIdEquipo() { return idEquipo; }
    public void setIdEquipo(Long idEquipo) { this.idEquipo = idEquipo; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getCiudad() { return ciudad; }
    public void setCiudad(String ciudad) { this.ciudad = ciudad; }

    public LocalDate getFundacion() { return fundacion; }
    public void setFundacion(LocalDate fundacion) { this.fundacion = fundacion; }
}