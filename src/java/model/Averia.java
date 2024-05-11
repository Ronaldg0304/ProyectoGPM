/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

public class Averia {
    private int idAveria;
    private String descripcion;

    // Constructor
    public Averia(int idAveria, String descripcion) {
        this.idAveria = idAveria;
        this.descripcion = descripcion;
    }

    public int getIdAveria() {
        return idAveria;
    }

    public void setIdAveria(int idAveria) {
        this.idAveria = idAveria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}

