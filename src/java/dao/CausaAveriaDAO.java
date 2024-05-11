/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import java.util.List;
import model.CausaAveria;

public interface CausaAveriaDAO {
    void crearCausaAveria(CausaAveria causaAveria);
    CausaAveria obtenerCausaAveria(int idCausaAveria);
    void actualizarCausaAveria(CausaAveria causaAveria);
    void eliminarCausaAveria(int idCausaAveria);
    List<CausaAveria> obtenerTodasLasCausasAverias();
}
