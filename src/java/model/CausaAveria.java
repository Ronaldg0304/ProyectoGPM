/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

public class CausaAveria {
    private int idCausaAveria;
    private String descripcion;

    // Constructor
    public CausaAveria(int idCausaAveria, String descripcion) {
        this.idCausaAveria = idCausaAveria;
        this.descripcion = descripcion;
    }

    public int getIdCausaAveria() {
        return idCausaAveria;
    }

    public void setIdCausaAveria(int idCausaAveria) {
        this.idCausaAveria = idCausaAveria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    
}

