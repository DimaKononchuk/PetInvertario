package bbdd;

import java.sql.*;

import javax.swing.JOptionPane;

public class conexion {
	
	static String timeZone = "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	static String dbName = "petproject";
	static String url = "jdbc:mysql://127.0.0.1:3306/?user=root";
	static String user = "root";
	static String pass = "admin";
	static String driver = "com.mysql.cj.jdbc.Driver";
    
    static Connection conexion;
    static Statement consulta;
    static ResultSet resultado;
    
    public static void Conectar(){
    	try {
           Class.forName(driver) ;
           conexion = DriverManager.getConnection(url, user, pass);
           System.out.println("Base de datos situada en :\n "+url);
           consulta = conexion.createStatement();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
            e.printStackTrace();
        }
    }
    
    public static ResultSet EjecutarSentencia(String Sentencia){
        try {
        	resultado = consulta.executeQuery(Sentencia);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return resultado;
    }
      
    public static void EjecutarUpdate(String Sentencia){
    	try{
    		consulta.executeUpdate(Sentencia);
    		System.out.println("Done.");
    	}catch(SQLException e){
    		JOptionPane.showMessageDialog(null, e.getMessage());
    	} 
    }
    
    public static void CerrarConexion(){
        try{
        	consulta.close();
        }catch(Exception e){}
    }
}
