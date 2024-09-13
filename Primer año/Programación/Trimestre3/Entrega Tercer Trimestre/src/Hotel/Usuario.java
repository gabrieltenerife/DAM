package Hotel;

import java.util.ArrayList;

public class Usuario {
	
	protected String Usuariouser, Contraseñauser, Nombre, Apellido, Dni;

	public Usuario(String usuariouser, String contraseñauser, String nombre, String apellido, String dni) {
		super();
		Usuariouser = usuariouser;
		Contraseñauser = contraseñauser;
		Nombre = nombre;
		Apellido = apellido;
		Dni = dni;
	}

	public String getUsuariouser() {
		return Usuariouser;
	}

	public void setUsuariouser(String usuariouser) {
		Usuariouser = usuariouser;
	}

	public String getContraseñauser() {
		return Contraseñauser;
	}

	public void setContraseñauser(String contraseñauser) {
		Contraseñauser = contraseñauser;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getApellido() {
		return Apellido;
	}

	public void setApellido(String apellido) {
		Apellido = apellido;
	}

	public String getDni() {
		return Dni;
	}

	public void setDni(String dni) {
		Dni = dni;
	}
}
