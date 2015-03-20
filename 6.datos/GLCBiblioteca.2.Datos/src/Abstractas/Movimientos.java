package Abstractas;

import conexion.Conn;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author German AT
 * @version 1.0
 */

public abstract class Movimientos {
    private Conn conexion;
    
    public abstract boolean Insertar(String consulta,String parametros) throws SQLException;
    public abstract boolean Actualizar(String consulta, String parametros) throws SQLException;
    public abstract boolean Eliminar(String consulta, int [] id) throws SQLException;
    public abstract ResultSet Consultar(String consulta) throws SQLException;
    
}
