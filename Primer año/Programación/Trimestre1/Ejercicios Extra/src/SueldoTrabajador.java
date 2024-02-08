import java.util.Scanner;

public class SueldoTrabajador {

	public static void main(String[] args) {
		
		//Variables
		Scanner sc = new Scanner(System.in);
		int a=25, b=20, c=15, d=10, horas, clase, resultado;
		
		//Peticion de datos
		System.out.println("Bienvenido!");
		do{
		System.out.println("Elije la clase del trabajador: ");
		System.out.println("1. -A");
		System.out.println("2. -B");
		System.out.println("3. -C");
		System.out.println("4. -D");
		System.out.println("5. -Apagar calculadora");
		clase = sc.nextInt();
		
		//Operar
		switch (clase) {
		
			case 1: 
				System.out.println("Indique el numero de horas trabajadas");
				horas = sc.nextInt();
				resultado = horas * a;
				System.out.println("El sueldo que le corresponde al trabajador es de: " +resultado+ "$");
				break;
				
			case 2: 
				System.out.println("Indique el numero de horas trabajadas");
				horas = sc.nextInt();
				resultado = horas * b;
				System.out.println("El sueldo que le corresponde al trabajador es de: " +resultado+ "$");
				break;
				
			case 3: 
				System.out.println("Indique el numero de horas trabajadas");
				horas = sc.nextInt();
				resultado = horas * c;
				System.out.println("El sueldo que le corresponde al trabajador es de: " +resultado+ "$");
				break;
				
			case 4: 
				System.out.println("Indique el numero de horas trabajadas");
				horas = sc.nextInt();
				resultado = horas * d;
				System.out.println("El sueldo que le corresponde al trabajador es de: " +resultado+ "$");
				break;
				
			case 5: 
				System.out.println("Hasta la proxima!");
				break;
				
			default:
				System.out.println("Elije una opción disponible en el menu");
				break;
						}//Cierra menu
		}while(clase!=5);

	}

}