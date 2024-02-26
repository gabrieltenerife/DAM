package EntregaT2;

import java.util.ArrayList;
import java.util.Scanner;

public class MAIN {

	public static void main(String[] args) {
		
		// Variables
		Scanner sc = new Scanner (System.in);
		String dni, nombre, Lenguajedominante;
		int edad, opcion, Lineasdecodigoporhora;
		boolean casado;
		double salario;
		
		ArrayList<Empleado>listaEmpleados = new ArrayList<Empleado>();
		Empleado e = new Empleado ();
		
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
				aumentarsalario(listaEmpleados, dni, sc);
				break;
				
			case 4:
				break;
			}
		}while(opcion!=4);
		
		
	//NOTO main	
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
	
	public static void aumentarsalario (ArrayList<Empleado>listaEmpleados, String dni, Scanner sc) {
		for(Empleado e1:listaEmpleados) {
			if(e1.getDni().equals(dni)) {
				System.out.print("Indique el porcentaje de salario que desea aumentar al trabajador con DNI :" +dni);
				int aumento = sc.nextInt();
			}
		}
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
	
	
	
	
	
	
	
	
	
	
	
	//NOTO
}
