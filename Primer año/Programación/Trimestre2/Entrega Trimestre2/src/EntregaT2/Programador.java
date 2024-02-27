package EntregaT2;

public class Programador extends Empleado {
	//Variables
	protected int Lineasdecodigoporhora;
	protected String Lenguajedominate;
	
	//Constructores
	public Programador() {
		super();
	}
	public Programador(String dni, String nombre, int edad, boolean casado, double salario, int lineasdecodigoporhora,
			String lenguajedominate) {
		super(dni, nombre, edad, casado, salario);
		Lineasdecodigoporhora = lineasdecodigoporhora;
		Lenguajedominate = lenguajedominate;
	}
	public Programador(double salario) {
		super(salario);
	}
	//Metodos
	public int getLineasdecodigoporhora() {
		return Lineasdecodigoporhora;
	}
	public void setLineasdecodigoporhora(int lineasdecodigoporhora) {
		Lineasdecodigoporhora = lineasdecodigoporhora;
	}
	public String getLenguajedominate() {
		return Lenguajedominate;
	}
	public void setLenguajedominate(String lenguajedominate) {
		Lenguajedominate = lenguajedominate;
	}
	public String toString() {
		return super.toString()+" lenguaje dominante : " +Lenguajedominate+ "y con " +Lineasdecodigoporhora+ "lineas de codigo por hora";
	}
}