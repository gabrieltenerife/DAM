import java.util.Scanner;

public class Entrega {

	public static void main(String[] args) {
		
		//Variables
		Scanner sc = new Scanner(System.in);
		int num1, num2, menu = 0, a, radio, radio2, radio3;
		double resultado;
		
		//Petición de datos
		do {
		System.out.println("Bienvenido a la calculadora de areas y perimetros");
		System.out.println("Seleccione la figura:");
		System.out.println("1. -Circulo");
		System.out.println("2. -Cuadrado");
		System.out.println("3. -Rectangulo");
		System.out.println("4. -Triangulo");
		System.out.println("5. -Apagar calculadora");
		menu = sc.nextInt();
		
		switch(menu){
		
			case 1: 
				do {
				System.out.println("Que desea calcular:");
				System.out.println("1. -Area");
				System.out.println("2. -Perimetro");
				a = sc.nextInt();
				if(a==1) {
					System.out.print("Introduzca un radio");
					radio=sc.nextInt();
					resultado = Math.PI * Math.pow(radio, 2);
					System.out.println("El area de un circulo de radio " +radio+ " es: " +resultado);
				}
				else if(a==2) {
						System.out.println("Introduzca un radio");
						radio=sc.nextInt();
						resultado = 2 * Math.PI * radio;
						System.out.println("El perimetro de un circulo de radio " +radio+ " es: " +resultado);
				}
				else if(a!=1 || a!=2) {
					System.out.println("Elije una de las opcciones disponibles");
				}
				}while(a!=1 && a!=2);
				break;
				
			case 2: 
				do {
				System.out.println("Que desea calcular:");
				System.out.println("1. -Area");
				System.out.println("2. -Perimetro");
				a = sc.nextInt();
				if(a==1) {
					System.out.print("Introduzca la medida del lado");
					radio=sc.nextInt();
					resultado = Math.pow(radio, 2);
					System.out.println("El area de un cuadrado de lado " +radio+ " es: " +resultado);
				}
				else if(a==2) {
						System.out.println("Introduzca la medida del lado");
						radio=sc.nextInt();
						resultado = 4 * radio;
						System.out.println("El perimetro de un cuadrado de lado " +radio+ " es: " +resultado);
				}
				else if(a!=1 || a!=2) {
					System.out.println("Elije una de las opcciones disponibles");
				}
				}while(a!=1 && a!=2);
				break;
				
			case 3: 
				do {
				System.out.println("Que desea calcular:");
				System.out.println("1. -Area");
				System.out.println("2. -Perimetro");
				a = sc.nextInt();
				if(a==1) {
					System.out.println("Introduzca la medida del lado largo");
					radio=sc.nextInt();
					System.out.println("Introduzca la medida del lado corto");
					radio2=sc.nextInt();
					resultado = radio2 * radio;
					System.out.println("El area de un rectangulo de lado corto " +radio2+ " y radio largo " +radio+ " es: " +resultado);
				}
				else if(a==2) {
					System.out.println("Introduzca la medida del lado largo");
					radio=sc.nextInt();
					System.out.println("Introduzca la medida del lado corto");
					radio2=sc.nextInt();
					resultado = 2 * (radio2 + radio);
					System.out.println("El perimetro de un rectangulo de lado corto " +radio2+ " y radio largo " +radio+ " es: " +resultado);
				}
				else if(a!=1 || a!=2) {
					System.out.println("Elije una de las opcciones disponibles");
				}
				}while(a!=1 && a!=2);
				break;
				
			case 4: 
				do {
				System.out.println("Que desea calcular:");
				System.out.println("1. -Area");
				System.out.println("2. -Perimetro");
				a = sc.nextInt();
				if(a==1) {
					System.out.println("Introduzca la medida de la base");
					radio=sc.nextInt();
					System.out.println("Introduzca la medida de la altura");
					radio2=sc.nextInt();
					resultado = (radio * radio2) / 2;
					System.out.println("El area de un triangulo de base " +radio+ " y altura " +radio2+ " es: " +resultado);
				}
				else if(a==2) {
					System.out.println("Introduzca la medida del lado 1");
					radio=sc.nextInt();
					System.out.println("Introduzca la medida del lado 2");
					radio2=sc.nextInt();
					System.out.println("Introduzca la medida del lado 3");
					radio3=sc.nextInt();
					resultado = radio + radio2 + radio3;
					System.out.println("El perimetro de un triangulo de medidas de lado: " +radio+ ", " +radio2+ ", " +radio3+ " es: " +resultado);
				}
				else if(a!=1 || a!=2) {
					System.out.println("Elije una de las opcciones disponibles");
				}
				}while(a!=1 && a!=2);
				break;
				
			case 5:
				System.out.print("Hasta la proxima!");
				
			default:
				if(menu!=5) {
					System.out.println("Elije una opción disponible");
				}	
			}	//Este cierra el menu
		}while(menu!=5);
		
	}

}
