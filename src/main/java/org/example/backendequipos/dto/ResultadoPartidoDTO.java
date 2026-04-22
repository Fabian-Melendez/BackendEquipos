package org.example.backendequipos.dto;

public class ResultadoPartidoDTO {

    private String equipoLocal;
    private String equipoVisita;
    private int golesLocal;
    private int golesVisita;

    public ResultadoPartidoDTO(String equipoLocal, String equipoVisita, int golesLocal, int golesVisita) {
        this.equipoLocal = equipoLocal;
        this.equipoVisita = equipoVisita;
        this.golesLocal = golesLocal;
        this.golesVisita = golesVisita;
    }

    public String getEquipoLocal() { return equipoLocal; }
    public String getEquipoVisita() { return equipoVisita; }
    public int getGolesLocal() { return golesLocal; }
    public int getGolesVisita() { return golesVisita; }
}