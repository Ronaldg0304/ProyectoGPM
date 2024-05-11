/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import java.util.List;
import model.Componente;

public interface ComponenteDAO {
    void crearComponente(Componente componente);
    Componente obtenerComponente(int idComponente);
    void actualizarComponente(Componente componente);
    void eliminarComponente(int idComponente);
    List<Componente> obtenerTodosLosComponentes();
}

