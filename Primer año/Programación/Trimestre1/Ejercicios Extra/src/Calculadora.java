import java.util.Scanner;

public class Calculadora {

	public static void main(String[] args) {
		
		//Variables
		Scanner sc = new Scanner(System.in);
		int menu, operar, resultado=0, resultado1=1, num, num1;
		
		//Pedir datos
		System.out.println("Bienvenido a tu calculadora!");
		do {
		System.out.println("Seleccione una acción en el menu:");
		System.out.println("1. -Sumar");
		System.out.println("2. -Restar");
		System.out.println("3. -Multiplicar");
		System.out.println("4. -Dividir");
		System.out.println("5. -Apagar calculadora");
		menu = sc.nextInt();
		
		//Operaciones
		switch(menu){
			case 1:
				for(int i=0; i<=1; i++) {
					System.out.print("Introduce un numero: ");
					num = sc.nextInt();
					resultado = resultado + num;
				}
				System.out.println("El resultado es :" +resultado);
				
				do {
				System.out.println("1. -Seguir operando con el resultado");
				System.out.println("2. -Cambiar de operación");
				operar = sc.nextInt();
				if(operar==1) {
						System.out.println("Introduce un numero: ");
						num = sc.nextInt();
						resultado = resultado + num;
						System.out.println("El resultado es :" +resultado);
				} else if(operar!=1 && operar!=2) {
						System.out.println("Seleccione una opción del menu");
				}
				}while(operar!=2);
				resultado = 0;
			break;
				
			case 2:
				for(int i=0; i<=1; i++) {
					System.out.print("Introduce un numero: ");
					num = sc.nextInt();
					if(resultado>num) {
						resultado = resultado - num;
					}else if(num>resultado) {
					resultado = num-resultado;
					}else if(num == resultado) {
						resultado = 0;
					}
				} // Cierra el for
				System.out.println("El resultado es :" +resultado);
				
				if(resultado!=0) {
				do {
				System.out.println("1. -Seguir operando con el resultado");
				System.out.println("2. -Cambiar de operación");
				operar = sc.nextInt();
				if(operar==1) {
					System.out.println("Introduce un numero: ");
					num = sc.nextInt();
					if(resultado>num) {
							resultado = resultado - num;
						}else if(num>resultado) {
						resultado = num-resultado;
						}else if(num == resultado) {
							resultado = 0;
						}
						System.out.println("El resultado es :" +resultado);
						} else if(operar!=1 && operar!=2) {
						System.out.println("Seleccione una opción del menu");
						}
				}while(operar!=2 && resultado!=0);
				}//cierra el if
				resultado=0;
			break;
			
			case 3:
				for(int i=0; i<=1; i++) {
					System.out.print("Introduce un numero: ");
					num = sc.nextInt();
					resultado1 = resultado1 * num;
				}
				System.out.println("El resultado es :" +resultado1);
				
				do {
				System.out.println("1. -Seguir operando con el resultado");
				System.out.println("2. -Cambiar de operación");
				operar = sc.nextInt();
				if(operar==1) {
						System.out.println("Introduce un numero: ");
						num = sc.nextInt();
						resultado1 = resultado1 * num;
						System.out.println("El resultado es :" +resultado1);
				} else if(operar!=1 && operar!=2) {
						System.out.println("Seleccione una opción del menu");
				}
				}while(operar!=2);
				resultado1=0;
			break;
			
			case 4:
				
					do {
					System.out.print("Introduce un numero: ");
					num = sc.nextInt();
					System.out.print("Introduce un numero: ");
					num1 = sc.nextInt();
					if(num!=0 && num1!=0) {
					resultado1 = num / num1;
					} else {
						System.out.println("No se puede dividir entre 0");
					}
					}while(num==0 && num1==0);
				
				System.out.println("El resultado es :" +resultado1);
				
				do {
				System.out.println("1. -Seguir operando con el resultado");
				System.out.println("2. -Cambiar de operación");
				operar = sc.nextInt();
				if(operar==1) {
					do {
						System.out.print("Introduce un numero: ");
						num = sc.nextInt();
						if(num!=0) {
						resultado1 = resultado1 / num;
						} else {
							System.out.println("No se puede dividir entre 0");
						}
						}while(num==0);
						System.out.println("El resultado es :" +resultado1);
				} else if(operar!=1 && operar!=2) {
						System.out.println("Seleccione una opción del menu");
				}
				}while(operar!=2);
				resultado1=0;
			break;
			
			case 5:
				System.out.print("Hasta la proxima!");
			break;
			
			default:
				System.out.println("Selecciona una opcion disponible en el menu");		
			break;
			
		} //cierra menu
		}while(menu!=5);
		
	}

}