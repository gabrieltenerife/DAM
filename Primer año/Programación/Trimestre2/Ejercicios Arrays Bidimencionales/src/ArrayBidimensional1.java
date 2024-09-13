
public class ArrayBidimensional1 {

	public static void main(String[] args) {
		
		//Variables
		final int FILAS=3, COLUMNAS=3;
		
		//Pedir datos
		int array [][]= new int [FILAS][COLUMNAS];
		array [0][0]= 1;
		array [1][0]= 2;
		array [2][0]= 3;
		array [0][1]= 4;
		array [1][1]= 5;
		array [2][1]= 6;
		array [0][2]= 7;
		array [1][2]= 8;
		array [2][2]= 9;
		
		//Operaciones 
		
		//Mostrar resultados
		System.out.print(array [0][0]);
		System.out.print(array [1][0]);
		System.out.println(array [2][0]);
		System.out.print(array [0][1]);
		System.out.print(array [1][1]);
		System.out.println(array [2][1]);
		System.out.print(array [0][2]);
		System.out.print(array [1][2]);
		System.out.print(array [2][2]);
		
	}

}
