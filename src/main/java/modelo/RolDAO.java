package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import conexion.Conexion;

public class RolDAO {

	private Connection conexion;

	public Rol getRol() {

		conexion = Conexion.getConexion();
		Rol rol = null;
		if (conexion != null) {

			try {
				PreparedStatement ps = conexion.prepareStatement("select * from roles");

				ResultSet resultado = ps.executeQuery();
				while (resultado.next()) {
					rol = new Rol();
					rol.setId(resultado.getInt("id"));
					rol.setRol(resultado.getString("rol"));
				}
				resultado.close();
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return rol;

	}

}
