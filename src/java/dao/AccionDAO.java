/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import java.util.List;
import model.Accion;

public interface AccionDAO {
    void crearAccion(Accion accion);
    Accion obtenerAccion(int idAccion);
    void actualizarAccion(Accion accion);
    void eliminarAccion(int idAccion);
    List<Accion> obtenerTodasLasAcciones();
}
