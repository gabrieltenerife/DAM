package presencial;

public class usuario extends persona{
	protected String codigoUsuario;
	protected boolean sancionado;

	protected usuario(String dni, String nombre, String apellidos, String codigoUsuario) {
		super(dni, nombre, apellidos);
		this.codigoUsuario = codigoUsuario;
		this.sancionado = false;
	}

	protected String getCodigoUsuario() {
		return codigoUsuario;
	}

	protected void setCodigoUsuario(String codigoUsuario) {
		this.codigoUsuario = codigoUsuario;
	}

	protected boolean isSancionado() {
		return sancionado;
	}

	protected void setSancionado(boolean sancionado) {
		this.sancionado = sancionado;
	}
	
	
}
