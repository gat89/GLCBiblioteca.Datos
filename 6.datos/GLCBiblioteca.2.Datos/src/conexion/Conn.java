package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

/**
 * @author German AT
 */
public class Conn {
    Connection conn;
    Statement st;
    ResultSet rs;
    
    private boolean Conexion(String usuario,String pass) throws ClassNotFoundException, SQLException{
        Class.forName("org.gjt.mm.mysql.Driver");
        conn=DriverManager.getConnection("jdbc:mysql://localhost/GLCBiblioteca",usuario,pass);
        st=conn.createStatement();
        return true;
    }
    private boolean Conexion() throws ClassNotFoundException, SQLException{
        Class.forName("org.gjt.mm.mysql.Driver");
        conn=DriverManager.getConnection("jdbc:mysql://localhost/GLCBiblioteca","root","");
        st=conn.createStatement();
        return true;
    }
    
    /***
     * Metodo de consulta sin seguridad
     * @param consulta
     * @return
     * @throws SQLException 
     */
    public ResultSet Consulta(String consulta) throws SQLException{
        try {
            if(rs!=null){
                rs.close();
            }
            Conexion();
            rs=st.executeQuery(consulta);
            cerrar();
            return rs;
        } catch (ClassNotFoundException ex) {
            System.out.print(ex);
            rs=null;
            return rs;
        }
    }
    /***
     * Metodo de consulta donde el usuario tiene pribilegios
     * @param consulta
     * @param usuario de la BD
     * @param pass de la BD
     * @return
     * @throws SQLException 
     */
    public ResultSet Consulta(String consulta,String usuario,String pass) throws SQLException{
        try {
            if(rs!=null){
                rs.close();
            }
            Conexion(usuario,pass);
            rs=st.executeQuery(consulta);
            cerrar();
            return rs;
        } catch (ClassNotFoundException ex) {
            System.out.print(ex);
            rs=null;
            return rs;
        }
    }
    private void cerrar() throws SQLException{
        conn.close();
        st.close();
    }
}
