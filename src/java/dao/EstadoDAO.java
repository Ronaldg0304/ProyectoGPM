/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import java.util.List;
import model.Estado;

public interface EstadoDAO {
    void crearEstado(Estado estado);
    Estado obtenerEstado(int idEstado);
    void actualizarEstado(Estado estado);
    void eliminarEstado(int idEstado);
    List<Estado> obtenerTodosLosEstados();
}

