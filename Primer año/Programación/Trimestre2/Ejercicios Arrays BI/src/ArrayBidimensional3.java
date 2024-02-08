import java.util.Scanner;

public class ArrayBidimensional3 {

	public static void main(String[] args) {

		//Variables
		Scanner sc = new Scanner(System.in);
		int FILAS0, FILAS1, FILASR, COLUMNAS0, COLUMNAS1, COLUMNASR;
		
		//Pedir datos
		System.out.println("Introduce el numero de filas de la primera matriz: ");
		FILAS0=sc.nextInt();
		System.out.println("Introduce el numero de columnas de la primera matriz: ");
		COLUMNAS0=sc.nextInt();
		System.out.println("Introduce el numero de filas de la segunda matriz: ");
		FILAS1=sc.nextInt();
		System.out.println("Introduce el numero de columnas de la segunda matriz: ");
		COLUMNAS1=sc.nextInt();
		
		FILASR=FILAS0;
		COLUMNASR=COLUMNAS0;
		
		int array0 [][] = new int [FILAS0][COLUMNAS0];
		int array1 [][] = new int [FILAS1][COLUMNAS1];
		int resultados [][] = new int [FILASR][COLUMNASR];
			
			System.out.println("Introduce valores para la primera matriz");
			for(int i=0;i<FILAS0;i++) {
				for(int j=0;j<COLUMNAS0;j++) {
					System.out.println("Introduce el valor para la posición: " +i+ "" +j);
					array0[i][j]=sc.nextInt();
				}
			}
			
			System.out.println("Introduce valores para la segunda matriz");
			for(int i=0;i<FILAS1;i++) {
				for(int j=0;j<COLUMNAS1;j++) {
					System.out.println("Introduce el valor para la posición: " +i+ "" +j);
					array1[i][j]=sc.nextInt();
				}
			}
		
		//Operaciones
			for(int i=0;i<FILAS0;i++) {
				for(int j=0;j<COLUMNAS0;j++) {
					for(int k=0;k<FILAS1;k++) {
						for(int h=0;h<COLUMNAS1;h++) {
							for(int p=0;p<FILASR;p++) {
								for(int q=0;q<COLUMNASR;q++) {
									resultados[p][q] = array0[i][j] + array1 [k][h];
								}
							}
						}
					}
				}
			}
			
		//Mostrar resultados
			
			System.out.println("Primera matriz: ");
			for(int i=0;i<FILAS0;i++) {
				for(int j=0;j<COLUMNAS0;j++) {
					System.out.println(array0[i][j]);
				}
			}
		
			System.out.println("Segunda matriz: ");
			for(int i=0;i<FILAS1;i++) {
				for(int j=0;j<COLUMNAS1;j++) {
					System.out.println(array1[i][j]);
				}
			}
			System.out.println("Resultado de la suma de ambas: ");
			for(int i=0;i<FILASR;i++) {
				for(int j=0;j<COLUMNASR;j++) {
					System.out.println(resultados[i][j]);
				}
			}
	}
}
