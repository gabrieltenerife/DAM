import java.util.Scanner;

public class Arrayunidireccional2 {

	public static void main(String[] args) {
		
		//Variables
		Scanner sc = new Scanner(System.in);
		int numero, inferior=0, superior=0;
		double altura=0, media;
		
		//Pedir datos
		System.out.println("Introduce el numero de personas en la lista: ");
		numero = sc.nextInt();
		
		double lista [] = new double [numero];
		for(int i=0;i<lista.length;i++) {
			System.out.println("Introduce una estatura: ");
			lista [i]= sc.nextDouble();
		}
		
		//Operaciones
		for(int i=0;i<lista.length;i++) {
			altura = altura + lista[i];
		}
		media = altura / numero;
		
		for(int i=0;i<lista.length;i++) {
			if(lista[i]>media) {
				superior++;
			}else if (lista[i]<media) {
				inferior++;
			}
		}
		
		//Mostrar resultados
		System.out.println("La altura media es de: " +media+ "m");
		System.out.println(superior+ " personas tienen una altura superior a la media");
		System.out.println(inferior+ " personas tienen una altura inferior a la media");
		
	}

}
