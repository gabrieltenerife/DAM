import java.util.Scanner;

public class CalculadoraDecimal {

	public static void main(String[] args) {
		
		
		//Variables
		int menu;
		double num1, num2, resultado;
		Scanner sc = new Scanner(System.in);
		
		//Peticion de datos
		/*
		 * He puesto un bucle en la petición de datos ya que aun que poniendo en default del menu el mensaje de numero erooneo, el programa
		 * seguia leyendo lineas y te preguntaba los numeros para las operaciones antes de que te advirtiera que no habias seleccionado
		 * una opccion disponible en el menu. Lo decidi cambiar por estetica. Lo mismo ocurre con el apagado de la calculadora.
		1 * Desconozco si ahi una manera mas facil de hacerlo pero fue la unica que se me ocurrio.
		 *
		 */
		do{
		do{
		System.out.println("Bienvenido a tu calculadora!");
		System.out.println("Selecciona en el pad numerico una operación a realizar");
		System.out.println("1. -Suma");
		System.out.println("2. -Resta");
		System.out.println("3. -Multiplicación");
		System.out.println("4. -División");
		System.out.println("5. -Apagar Calculadora");
		menu=sc.nextInt();
		if(menu<1 || menu>5) {
			System.out.println("Selecciona una opción del menu");
		}}while(menu<1 || menu>5);
		if(menu!=5) {
		System.out.println("Introduce el primer numero");
		num1=sc.nextDouble();
		System.out.println("Introduce el segundo numero");
		num2=sc.nextDouble();
		
	
		//Operaciones
		
		switch(menu) {
		case 1: 
			resultado=num1+num2;
			System.out.println("El resultado de "+ num1 + "+"+num2 +"="+ resultado);
			break;
		case 2:
			if(num1>num2){
				resultado=num1-num2;
				System.out.println("El resultado de "+ num1 + "-"+num2 +"="+ resultado);
			} else {
				resultado=num2-num1;
				System.out.println("El resultado de "+ num2 + "-"+num1 +"="+ resultado);
			}
			break;
		case 3:
			resultado=num1*num2;
			System.out.println("El resultado de "+ num1 + "*"+num2 +"="+ resultado);
			break;
		case 4:
			if(num1==0 || num2==0) {
				System.out.println("No es posible dividir por 0");
			}else {resultado=num1/num2;
			System.out.println("El resultado de "+ num1 + "/"+num2 +"="+ resultado);}
			break;
		default:System.out.println("Porfavor selecciona una de las opciones disponibles");
				}
		}
			}while(menu!=5);
		}
			}	
		

