/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author rolan
 */

import java.util.Date;

public class Orden {
    private int idOt;
    private String responsable;
    private int idEstado;
    private Date fechaInicioOt;
    private Date fechaFinOt;
    private int idEquipo;
    private int idSolicitud;
    private int idOperatividad;

    // Constructor
    public Orden(int idOt, String responsable, int idEstado, Date fechaInicioOt, Date fechaFinOt, int idEquipo, int idSolicitud, int idOperatividad) {
        this.idOt = idOt;
        this.responsable = responsable;
        this.idEstado = idEstado;
        this.fechaInicioOt = fechaInicioOt;
        this.fechaFinOt = fechaFinOt;
        this.idEquipo = idEquipo;
        this.idSolicitud = idSolicitud;
        this.idOperatividad = idOperatividad;
    }
    
    public Orden(){
        
    }

    public int getIdOt() {
        return idOt;
    }

    public void setIdOt(int idOt) {
        this.idOt = idOt;
    }

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    public int getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
    }

    public Date getFechaInicioOt() {
        return fechaInicioOt;
    }

    public void setFechaInicioOt(Date fechaInicioOt) {
        this.fechaInicioOt = fechaInicioOt;
    }

    public Date getFechaFinOt() {
        return fechaFinOt;
    }

    public void setFechaFinOt(Date fechaFinOt) {
        this.fechaFinOt = fechaFinOt;
    }

    public int getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(int idEquipo) {
        this.idEquipo = idEquipo;
    }

    public int getIdSolicitud() {
        return idSolicitud;
    }

    public void setIdSolicitud(int idSolicitud) {
        this.idSolicitud = idSolicitud;
    }

    public int getIdOperatividad() {
        return idOperatividad;
    }

    public void setIdOperatividad(int idOperatividad) {
        this.idOperatividad = idOperatividad;
    }

}

