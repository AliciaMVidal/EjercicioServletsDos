package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import conexion.Conexion;


public class UsuarioDAO {
	
	
	private static Logger logger = LogManager.getLogger(UsuarioDAO.class);

	private Connection conexion;
	private Statement statement;
	
	
	
	public boolean comprobarUsuario(String user) {
		logger.info(String.format(">>>>>>Comprobando usuario."));
		conexion = Conexion.getConexion();
		boolean existe = false;
		PreparedStatement ps;
		try {
			ps = conexion.prepareStatement("SELECT * FROM usuarios WHERE nombre = ?");
			ps.setString(1, user);
			ResultSet resultset = ps.executeQuery();
			if (resultset.next()) {
				existe = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.warn(String.format(">>>>>> No se ha creado la conexion.", e));
		}
		return existe;
	}
	
	public boolean comprobarPassw(String user, String passw) {
		logger.info(String.format(">>>>>>Comprobando usuario y contraseña."));
		conexion = Conexion.getConexion();
		boolean existe = false;
		PreparedStatement ps;
		try {
			ps = conexion.prepareStatement("SELECT * FROM usuarios WHERE nombre = ? AND clave = ?");
			ps.setString(1, user);
			ps.setString(2, passw);
			ResultSet resultset = ps.executeQuery();
			if (resultset.next()) {
				existe = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.warn(String.format(">>>>>> Error al comprobar el usuario y la contraseña.", e));
		}
		
		return existe;
		
	}

}
