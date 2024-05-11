/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

public class Operatividad {
    private int idOperatividad;
    private String descripcion;

    // Constructor
    public Operatividad(int idOperatividad, String descripcion) {
        this.idOperatividad = idOperatividad;
        this.descripcion = descripcion;
    }

    public int getIdOperatividad() {
        return idOperatividad;
    }

    public void setIdOperatividad(int idOperatividad) {
        this.idOperatividad = idOperatividad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}
