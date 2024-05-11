/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import java.util.List;
import model.TipoSolicitud;

public interface TipoSolicitudDAO {
    void crearTipoSolicitud(TipoSolicitud tipoSolicitud);
    TipoSolicitud obtenerTipoSolicitud(int idTipoSolicitud);
    void actualizarTipoSolicitud(TipoSolicitud tipoSolicitud);
    void eliminarTipoSolicitud(int idTipoSolicitud);
    List<TipoSolicitud> obtenerTodosLosTiposSolicitudes();
}
