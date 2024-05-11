/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import java.util.List;
import model.Equipo;

public interface EquipoDAO {
    void crearEquipo(Equipo equipo);
    Equipo obtenerEquipo(int idEquipo);
    void actualizarEquipo(Equipo equipo);
    void eliminarEquipo(int idEquipo);
    List<Equipo> obtenerTodosLosEquipos();
}
