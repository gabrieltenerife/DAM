import java.util.Scanner;

public class Arrayunidireccional1 {

	public static void main(String[] args) {
		
		//Variables
		Scanner sc = new Scanner(System.in);
		int positivo=0, negativo=0, cero=0;
		
		//Pedir datos
		int array [] = new int [10];
		for(int i=0;i<array.length;i++) {
			System.out.println("Introduce un numero: ");
			array [i]= sc.nextInt();
		}
		
		//Operaciones
		for(int i=0;i<array.length;i++) {
			if(array[i]<0){
				negativo++;
			}else if(array[i]>0) {
				positivo++;
			}else {
				cero++;
			}
		}
		
		//Mostrar resultados
		System.out.println("En la lista existen " +positivo+ " numeros positivos");
		System.out.println("En la lista existen " +negativo+ " numeros negativos");
		System.out.println("En la lista existen " +cero+ " ceros");
		
	}

}
