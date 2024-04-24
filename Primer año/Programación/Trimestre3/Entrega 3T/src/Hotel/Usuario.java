package Hotel;

public class Usuario extends Persona {
	
	protected String Usuariouser, Contraseñauser;

	public Usuario() {
		super();
	}

	public Usuario(String usuariouser, String contraseñauser) {
		super();
		Usuariouser = usuariouser;
		Contraseñauser = contraseñauser;
	}
	
	public Usuario(String nombre, String apellidos, String dni, String usuariouser, String contraseñauser) {
		super(nombre, apellidos, dni);
		Usuariouser = usuariouser;
		Contraseñauser = contraseñauser;
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
}
