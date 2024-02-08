import java.util.Scanner;

public class NotasMediasClase {

	public static void main(String[] args) {
		
		//Variables
		Scanner sc = new Scanner(System.in);
		int alumnos, nota, notamedia, notabaja=10, notaalta=0, resultado=0;
		
		//Pedir datos
		System.out.print("Introduzca el numero de alumnos de la clase:");
		alumnos = sc.nextInt();

		//Operaciones
		for(int i=1; i<=alumnos; i++) {
			System.out.print("Introduce una nota:");
			nota = sc.nextInt();
			resultado = resultado + nota;
			if(nota > notaalta) {
				notaalta = nota;
			}
			if(nota < notabaja) {
				notabaja = nota;
			}
		} 
		
		notamedia = resultado / alumnos;
		
		//Mostrar resultados
		System.out.println("La nota media de la clase es de: " + notamedia + "pt");
		System.out.println("La nota mas alta de la clase es de: " + notaalta + "pt");
		System.out.println("La nota mas baja de la clase es de: " + notabaja + "pt");

		
		
		
		
		
		//No tocar

	}

}
