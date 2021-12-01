import java.sql.*;

public class ConexionBD {
	static String basededatos = "biblioteca";
	static String usuario = "root";
	static String password = "sabemo02";
	static String url = "jdbc:mysql://localhost/"+basededatos;
	static Connection conexion = null;
	
	public ConexionBD(){
	}
	
	public static Connection getConexion(){
		if (conexion==null){
			try {
				conexion = DriverManager.getConnection(url,usuario,password);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		
		return conexion;
	}
	
	public static void desconectar(){
		try {
			if (conexion!=null){
				conexion.close();
				conexion=null;
				System.out.println("Conexion Cerrada");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
				  
	}
	 
}
