import java.util.Random;
import java.util.Scanner;

public class ArrayBidimensional2 {

	public static void main(String[] args) {
		
		//Variables
		Scanner sc = new Scanner(System.in);
		Random num = new Random();
		final int FILAS=5;
		int COLUMNAS;
		
		//Pedir datos
		System.out.print("Introduzca un numero de columnas: ");
		COLUMNAS = sc.nextInt();
		int array [][] = new int [FILAS][COLUMNAS];
		
		//Operaciones
		for(int i=0;i<FILAS;i++) {
			for(int j=0;j<COLUMNAS;j++) {
				array [i][j] = num.nextInt(11);
			}
		}
		//Mostrar resultados
			for(int j=0;j<COLUMNAS;j++) {
				System.out.print(array[0][j]);
				System.out.print(array[1][j]);
				System.out.print(array[2][j]);
				System.out.print(array[3][j]);
				System.out.print(array[4][j]);
				System.out.println("");
				
			}

	}

}
