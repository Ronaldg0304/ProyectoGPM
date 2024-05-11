/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import java.util.List;
import model.TipoEquipo;

public interface TipoEquipoDAO {
    void crearTipoEquipo(TipoEquipo tipoEquipo);
    TipoEquipo obtenerTipoEquipo(int idTipoEquipo);
    void actualizarTipoEquipo(TipoEquipo tipoEquipo);
    void eliminarTipoEquipo(int idTipoEquipo);
    List<TipoEquipo> obtenerTodosLosTiposEquipos();
}
