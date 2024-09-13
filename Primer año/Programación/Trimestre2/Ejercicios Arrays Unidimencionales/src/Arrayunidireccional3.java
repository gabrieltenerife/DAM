import java.util.Scanner;

public class Arrayunidireccional3 {

	public static void main(String[] args) {
		
		//Variables
		Scanner sc = new Scanner(System.in);
		int dni;
		final int div=23;
		
		//Pedir datos
		/*
		 * Lo correcto mas correcto seria:
		 * Char array [] = {'T', 'R', 'W'};
		 */
		char array [] = new char [23];
		array [0]='T';
		array [1]='R';
		array [2]='W';
		array [3]='A';
		array [4]='G';
		array [5]='M';
		array [6]='Y';
		array [7]='F';
		array [8]='P';
		array [9]='D';
		array [10]='X';
		array [11]='B';
		array [12]='N';
		array [13]='J';
		array [14]='Z';
		array [15]='S';
		array [16]='Q';
		array [17]='V';
		array [18]='H';
		array [19]='L';
		array [20]='C';
		array [21]='K';
		array [22]='E';
		
		System.out.println("Introduzca su DNI sin la letra: ");
		dni = sc.nextInt();
		
		//Operaciones
		int resto = dni % div;
		
		//Mostrar resultados
		System.out.print("Su DNI compreto es: " +dni+ "" +array[resto]);
		
	}

}
