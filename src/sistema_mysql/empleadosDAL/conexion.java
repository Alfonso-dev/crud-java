package sistema_mysql.empleadosDAL;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 *
 * @author alfonso
 */
public class conexion {
    Connection conn = null;
    final String HOST = "localhost";
    final String PORT = "3306";
    final String DB = "sistema";
    final String USER = "root";
    final String PASSWORD = "alfonso1234";
    
    public conexion(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://"+HOST+":"+PORT+"/"+DB, USER, PASSWORD);
            System.out.println("Se conecto con exito");
        } catch (Exception e) {
            System.out.println("Error de conexion: " + e);
        }
    }
    
    public int ejecutarSentenciaSQL(String strSentenciaSQL){
        try {
            PreparedStatement pstm = conn.prepareStatement(strSentenciaSQL);
            pstm.execute();
            return 1;
        } catch (Exception e) {
            System.out.println("Ha ocurrido un error: " + e);
            return 0;
        }
    }
    
    public ResultSet consultarRegistro(String strSentenciaSQL){
        try {
            
            PreparedStatement pstm = conn.prepareStatement(strSentenciaSQL);
            ResultSet respuesta = pstm.executeQuery();
            return respuesta;
        } catch (Exception e) {
            System.out.println("Ha ocurrido un error al consultar datos: " + e);
            return null;
        }
        
    }
}
