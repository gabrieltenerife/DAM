package BaseDatos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.spi.DirStateFactory.Result;
import javax.swing.JOptionPane;

import com.mysql.jdbc.Statement;

public class GestionBD {
	private Conexion conexion = new Conexion(); // OBJETO DE LA CLASE CONEXTION
	private Connection con; // PUENTE PARA REALIZAR LA CONNECCION
	private Statement st; // PERMITE LANZAR LAS CONSULTAS EN SQL A LA BASE DE DATOS
	private ResultSet resultado; // ALMACENA EL RESULTADO OBTENIDO DE LA CONSULTA A LA BASE DE DATOS. // A LA
									// HORA DE DAR RESULTADOS DEVUELVE UNA MATRIZ.

	/*
	 *
	 * DOCUMENTACION DE LOS DISTINTOS METODOS DE LA CLASE STATEMENT:
	 * https://docs.oracle.com/javase/8/docs/api/java/sql/Statement.html
	 * 
	 */

	public boolean insertarAlumno(String dni, String nombre, String apellidos, String direccion, String pass)
			throws SQLException {
		boolean insertado = false;
		con = conexion.getConexion(); // ABRIMOS LA CONECCION CON LA BASE DE DATOS
		String sql = "insert into alumnos (DNI,NOMBRE,APELLIDOS,DIRECCION,PASSWORD) values ('" + dni + "','" + nombre
				+ "','" + apellidos + "','" + direccion + "','" + pass + "')";
		try {
			st = (Statement) con.createStatement(); // CREAR OBJETO DE LA CLASE STATEMENT PARA EJECUTAR
			int confirmar = st.executeUpdate(sql); // LANZA LA PETICION SQL, QUE DEVUELVE UN 1 SI SE HA COMPLETADO O UN
													// 0 SI NO SE HA COMPLETADO
			if (confirmar == 1) {
				insertado = true;
			}
			st.close(); // CERRAMOS EL OBJETO
			con.close(); // CERRAMOS LA CONECCION CON LA BASE DE DATOS
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return insertado;
	}

	public int modificarAlumno(String dni, String nombre, String apellidos, String direccion, String pass)
			throws SQLException {
		int confirmar = 0;
		con = conexion.getConexion();
		String sql = "update alumnos set DNI='" + dni + "', NOMBRE='" + nombre + "', APELLIDOS='" + apellidos
				+ "', DIRECCION='" + direccion + "', PASSWORD='" + pass + "' where DNI=" + dni + "";
		try {
			st = (Statement) con.createStatement();
			confirmar = st.executeUpdate(sql);
			st.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return confirmar;
	}

	public int eliminarAlumno(String dni) throws SQLException {
		int confirmar = 0;
		con = conexion.getConexion();
		String sql = "delete from alumnos where DNI=" + dni;
		try {
			st = (Statement) con.createStatement();
			confirmar = st.executeUpdate(sql);
			st.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return confirmar;
	}

	public boolean comprobarAlumno(String dni, String pass) throws SQLException {
		boolean encontrado = false;
		con = conexion.getConexion();
		String sql = "SELECT * FROM alumnos WHERE DNI='" + dni + "'and PASSWORD='" + pass + "' ";
		try {
			st = (Statement) con.createStatement();
			resultado = st.executeQuery(sql);
			while (resultado.next()) {

				/*
				 * EN ESTA A LA HORA DE COMPROBAR NECESITAMOS OBETENER UN RESULTADO, EN ESTE
				 * CLASO EL METODO.NEXT LO QUE HACE ES VER SI EXISTE ALGUNA FILA QUE
				 * CUMPLA LA SENTENCIA DEL SQL Y DEVUELVE SI EXISTE ESE ALUMNO CON ESA
				 * CONTRASEÑA EN LA BASE DE DATOS
				 */

				encontrado = true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return encontrado;
	}

	public boolean buscarAlumno(String dni) throws SQLException {
		boolean encontrado = false;
		con = conexion.getConexion();
		String sql = "SELECT * FROM alumnos WHERE DNI='" + dni + "' ";
		try {
			st = (Statement) con.createStatement();
			resultado = st.executeQuery(sql);
			while (resultado.next()) {
				encontrado = true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return encontrado;
	}

	public ResultSet devolverAlumno(String dni) throws SQLException {
		con = conexion.getConexion();
		String sql = "SELECT * FROM alumnos WHERE DNI='" + dni + "' ";
		try {
			st = (Statement) con.createStatement();
			resultado = st.executeQuery(sql);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultado;
	}

	public ResultSet devolverAlumnos() throws SQLException {
		con = conexion.getConexion();
		String sql = "SELECT * FROM alumnos";
		try {
			st = (Statement) con.createStatement();
			resultado = st.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultado;
	}
}