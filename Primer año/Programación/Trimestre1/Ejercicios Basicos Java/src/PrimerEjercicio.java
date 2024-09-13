import java.util.Scanner;

public class PrimerEjercicio {

	public static void main(String[] args) {
		//comentarios en Java
		/*esto es para comentarios
		 * en distintos 
		 * parrafos*/
		//Variables
		int num1=4, num2=3, suma, resta, multipicacion, division, resto;
		double numero2=6.6;
		char letra='d';
		String palabra= "Gabriel Gonzalez Herrera";
		boolean verdadero= false;
		//Constantes en mayuscula
		final int VALOR=6;
	
		
		
		
		//Imprimir
		System.out.println("Hola "+palabra+" bienvenido a Java");
		System.out.println(num1);
		//Despues de System.out.print se añade extencion ln para imprimir en otra linea
		
		
		
		
		
		//Operaciones
		suma=num1+num2;
		System.out.println("El resultado de la suma es: "+suma);
		resto=num1%num2;
		System.out.println("El resultado del resto es: "+resto);
		
		
		
		
		
		
		//Vamos a hacer que pida numeros a sumar al usuario
		Scanner sc= new Scanner(System.in);
		//resolvemos el error click encima de scanner y click primera opcion
		// Despues de Sacanner el nombre que quieras ponerle= en este caso sc=
		// Scanner es un objeto y sirve para leer los imputs del usuario en el teclado
		
		//Para que te pida el nombre y la bienvenida
		//next se queda con el texto introducido hasta un espacio gabriel 
		//nextline se queda con todo el texto gabriel gonzalez herrera
		System.out.print("Dime tu nombre: ");
		String oper3= sc.nextLine();
		System.out.println("Bienvenido "+oper3+" este programa te ayudara a sumar dos numeros enteros.");
		
		//Para que te pida los numeros y realize la operación
		System.out.println("Dime un numero: ");
		int oper1= sc.nextInt();
		/*sc.nextint para enteros
		 *.nextdouble si en con decimal
		 *.nextline si es un string*/
		//System.out.print(oper1); ESTA ES LA LINEA QUE VA EN LA CALSE Y NADA MAS DE AQUI PARA ABAJO pero hice calculadora xd
		System.out.println("Dime un segundo numero: ");
		int oper2= sc.nextInt();
		suma= oper1+oper2 ;
		System.out.print("el resultado es: "+suma);
		
		
		
	}

}
