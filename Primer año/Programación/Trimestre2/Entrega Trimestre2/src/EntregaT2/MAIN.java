package EntregaT2;

import java.util.ArrayList;
import java.util.Scanner;

public class MAIN {

	public static void main(String[] args) {
		
		// Variables
		Scanner sc = new Scanner (System.in);
		String dni;
		int opcion;
		
		
		ArrayList<Empleado>listaEmpleados = new ArrayList<Empleado>();
		Empleado e = new Programador ();
		
		//op
		do {
			mostrarmenu();
			opcion=sc.nextInt();
			switch(opcion) {
			case 1:
				System.out.println("Introduce el DNI del programador");
				dni=sc.next();
				if (!comprobarempleado(dni, listaEmpleados)) {
					altaProgramador(listaEmpleados, dni, sc, e);
				} else System.out.println("Este DNI ya existe en la base de datos");
				break;
				
			case 2:
				System.out.println("Introduce el DNI del programador");
				dni=sc.next();
				if(!bajaProgramador(listaEmpleados, dni)) {
					System.out.println("No existe ningun empleado con DNI : " +dni+ " en la base de datos");
				}
				break;
				
			case 3:
				System.out.print("Introduce el DNI del programador");
				dni=sc.next();
				if(!aumentarsalario(listaEmpleados, dni, sc)) {
					System.out.println("No existe ningun empleado con DNI : " +dni+ " en la base de datos");
				}
				break;
				
			case 4:
				System.out.print("Hasta la proxima!");
				break;
			}
		}while(opcion!=4);
	}

	//METODOS
	public static void mostrarmenu() {
		System.out.println("Menu principal");
		System.out.println("1. Dar de alta un programador");
		System.out.println("2. Dar de baja un programador");
		System.out.println("3. Aumentar salario de un programador");
		System.out.println("4. Salir");
	}
	
	public static boolean comprobarempleado(String dni, ArrayList<Empleado>listaEmpleados) {
		boolean existe = false;
				
		for(Empleado e1:listaEmpleados) {
			if(e1.getDni().equals(dni)) {
				existe = true;
				break;
			}
		}
		
		return existe;
	}

	public static void altaProgramador (ArrayList<Empleado>listaEmpleados, String dni, Scanner sc, Empleado e) {
		System.out.println("Introduce el nombre: ");
		String nombre = sc.next();
		System.out.println("Introduce la edad: ");
		int edad = sc.nextInt();
		System.out.println("Introduce el estado civil: ");
		boolean casado = sc.nextBoolean();
		System.out.println("Introduce el salario: ");
		double salario = sc.nextDouble();
		System.out.println("Introduce lineas de codigo por hora: ");
		int Lineasdecodigoporhora = sc.nextInt();
		System.out.println("Introduce lenguaje dominante: ");
		String Lenguajedominante = sc.next();
		e = new Programador(dni, nombre, edad, casado, salario, Lineasdecodigoporhora, Lenguajedominante);
		listaEmpleados.add(e);
	}
	
	public static boolean bajaProgramador (ArrayList<Empleado>listaEmpleados, String dni) {
		boolean existe=false;
				
		for(Empleado e1:listaEmpleados) {
			if(e1.getDni().equals(dni)) {
				existe=true;
				listaEmpleados.remove(e1);
				System.out.println("Empleado con DNI : " +dni+ " eliminado correctamente de la base de datos");
				break;
			}
		}
		return existe;
	}
	
	public static boolean aumentarsalario(ArrayList<Empleado>listaEmpleados, String dni, Scanner sc) {
		boolean existe = false;
		for(int i=0;i<listaEmpleados.size();i++) {
			if(listaEmpleados.get(i).getDni().equals(dni)) {
				System.out.println("Introduce el aumento porcentual en un rago de 0,1 a 100");
				double aumento = sc.nextInt();
				aumento = aumento/100;
				aumento = aumento +1;
				aumento = listaEmpleados.get(i).getSalario() * aumento;
				listaEmpleados.get(i).setSalario(aumento);
				System.out.println("Operacion realizada correctamente");
				existe = true;
				break;
			}
		}
		return existe;
	}

	public static void experiencia(int edad) {
		if(edad<=21) {
			System.out.print("Este trabajador es de rango principiante");
		}else if(edad>=22 && edad<=35) {
			System.out.print("Este trabajador es de rango intermedio");
		}else if(edad>35) {
			System.out.print("Este trabajador es de rango senior");
		}else{
			System.out.print("Edad no contemplada");
		}	
	}
}