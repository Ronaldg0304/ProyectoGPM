/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import recursos.DBConnection;
import model.Componente;

public class ComponenteDAOImpl implements ComponenteDAO {
    
      // Método para obtener una conexión a la base de datos
    private Connection conexion = DBConnection.getConnection();

    @Override
    public void crearComponente(Componente componente) {
             // Query SQL para insertar una nueva solicitud
        String sql = "INSERT INTO COMPONENTES(Descripcion, IdTipoEquipo) "
                + "VALUES (?,?)";

        try {
            // Preparar la declaración SQL
            PreparedStatement statement = conexion.prepareStatement(sql);
            // Establecer los parámetros de la consulta
            statement.setString(1, componente.getDescripcion());
            statement.setInt(2, componente.getIdTipoEquipo());

            // Ejecutar la consulta
            statement.executeUpdate();

            // Cerrar la declaración y la conexión
            statement.close();
            conexion.close();

            System.out.println("Componente agregado exitosamente.");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Errr al agregar el componente.");
        }
    }

    @Override
    public Componente obtenerComponente(int idComponente) {
        // Query SQL para obtener una solicitud por su ID
        String sql = "SELECT * FROM COMPONENTES WHERE IdComponente = ?";

        try {
            // Preparar la declaración SQL
            PreparedStatement statement = conexion.prepareStatement(sql);
            // Establecer el parámetro de la consulta (ID del tipo_solicitud)
            statement.setInt(1, idComponente);

            // Ejecutar la consulta y obtener el resultado
            ResultSet resultSet = statement.executeQuery();

            // Verificar si se encontró una solicitud
            if (resultSet.next()) {
                // Crear un objeto Tipo_Solicitud con los datos obtenidos de la base de datos
                Componente componente = new Componente(
                        resultSet.getInt("IdComponente"),
                        resultSet.getString("Descripcion"),
                        resultSet.getInt("IdTipoEquipo")
                );

                // Cerrar el resultado y la declaración
                resultSet.close();
                statement.close();

                return componente;
            }

            statement.close();
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al obtener el componente indicado.");
            return null;
        }
    }

    @Override
    public void actualizarComponente(Componente componente) {
       // Query SQL para actualizar una solicitud
        String sql = "UPDATE COMPONENTES SET Descripcion = ?, IdTipoEquipo = ? WHERE IdComponente = ? ";

        try {
            // Preparar la declaración SQL
            PreparedStatement statement = conexion.prepareStatement(sql);
            // Establecer los parámetros de la consulta
            statement.setString(1, componente.getDescripcion());
            statement.setInt(2, componente.getIdTipoEquipo());

            // Ejecutar la consulta
            statement.executeUpdate();

            // Cerrar la declaración
            statement.close();

            System.out.println("Componente actualizado exitosamente.");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al actualizar el componente.");
        }
    }

    @Override
    public void eliminarComponente(int idComponente) {
       // Query SQL para eliminar una solicitud por su ID
        String sql = "DELETE FROM COMPONENTES WHERE IdComponente = ? ";

        try {
            // Preparar la declaración SQL
            PreparedStatement statement = conexion.prepareStatement(sql);
            // Establecer el parámetro de la consulta (ID de la solicitud)
            statement.setInt(1, idComponente);

            // Ejecutar la consulta
            statement.executeUpdate();

            // Cerrar la declaración
            statement.close();

            System.out.println("Componente eliminado exitosamente.");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al eliminarla componente.");
        } 
    }

    @Override
    public List<Componente> obtenerTodosLosComponentes() {
        List<Componente> componentes = new ArrayList<>();
        // Query SQL para obtener todas las solicitudes
        String sql = "SELECT * FROM COMPONENTES";

        try {
            // Preparar la declaración SQL
            PreparedStatement statement = conexion.prepareStatement(sql);

            // Ejecutar la consulta y obtener el resultado
            ResultSet resultSet = statement.executeQuery();

            // Recorrer el resultado y crear objetos Solicitud
            while (resultSet.next()) {
                Componente componente = new Componente(
                        resultSet.getInt("IdComponente"),
                        resultSet.getString("Descripcion"),
                        resultSet.getInt("IdTipoEquipo"));
                // Agregar la solicitud a la lista
                componentes.add(componente);
            }

            // Cerrar el resultado y la declaración
            resultSet.close();
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al obtener todos los componentes.");
        }

        return componentes;
    }
    // Implementación de los métodos CRUD utilizando JDBC o algún ORM
}

