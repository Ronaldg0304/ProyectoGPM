/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Time;

public class Accion {
    private int idAccion;
    private int tiempoAccion;
    private String comentarioAccion;
    private int idOt;
    private int idAveria;
    private int idCausaAveria;
    private int idComponente;
    private int idTipoAccion;

    // Constructor
    public Accion(int idAccion, int tiempoAccion, String comentarioAccion, int idOt, int idAveria, int idCausaAveria, int idComponente, int idTipoAccion) {
        this.idAccion = idAccion;
        this.tiempoAccion = tiempoAccion;
        this.comentarioAccion = comentarioAccion;
        this.idOt = idOt;
        this.idAveria = idAveria;
        this.idCausaAveria = idCausaAveria;
        this.idComponente = idComponente;
        this.idTipoAccion = idTipoAccion;
    }

    public Accion() {
    }

    public int getIdAccion() {
        return idAccion;
    }

    public void setIdAccion(int idAccion) {
        this.idAccion = idAccion;
    }

    public int getTiempoAccion() {
        return tiempoAccion;
    }

    public void setTiempoAccion(int tiempoAccion) {
        this.tiempoAccion = tiempoAccion;
    }

    public String getComentarioAccion() {
        return comentarioAccion;
    }

    public void setComentarioAccion(String comentarioAccion) {
        this.comentarioAccion = comentarioAccion;
    }

    public int getIdOt() {
        return idOt;
    }

    public void setIdOt(int idOt) {
        this.idOt = idOt;
    }

    public int getIdAveria() {
        return idAveria;
    }

    public void setIdAveria(int idAveria) {
        this.idAveria = idAveria;
    }

    public int getIdCausaAveria() {
        return idCausaAveria;
    }

    public void setIdCausaAveria(int idCausaAveria) {
        this.idCausaAveria = idCausaAveria;
    }

    public int getIdComponente() {
        return idComponente;
    }

    public void setIdComponente(int idComponente) {
        this.idComponente = idComponente;
    }

    public int getIdTipoAccion() {
        return idTipoAccion;
    }

    public void setIdTipoAccion(int idTipoAccion) {
        this.idTipoAccion = idTipoAccion;
    }

    
}

