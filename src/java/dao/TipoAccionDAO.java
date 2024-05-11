/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import java.util.List;
import model.TipoAccion;

public interface TipoAccionDAO {
    void crearTipoAccion(TipoAccion tipoAccion);
    TipoAccion obtenerTipoAccion(int idTipoAccion);
    void actualizarTipoAccion(TipoAccion tipoAccion);
    void eliminarTipoAccion(int idTipoAccion);
    List<TipoAccion> obtenerTodosLosTiposAcciones();
}
