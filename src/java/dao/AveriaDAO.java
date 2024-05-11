/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import java.util.List;
import model.Averia;

public interface AveriaDAO {
    void crearAveria(Averia averia);
    Averia obtenerAveria(int idAveria);
    void actualizarAveria(Averia averia);
    void eliminarAveria(int idAveria);
    List<Averia> obtenerTodasLasAverias();
}

