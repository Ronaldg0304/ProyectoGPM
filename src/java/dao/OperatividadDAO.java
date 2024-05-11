/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import java.util.List;
import model.Operatividad;

public interface OperatividadDAO {
    void crearOperatividad(Operatividad operatividad);
    Operatividad obtenerOperatividad(int idOperatividad);
    void actualizarOperatividad(Operatividad operatividad);
    void eliminarOperatividad(int idOperatividad);
    List<Operatividad> obtenerTodasLasOperatividades();
}

