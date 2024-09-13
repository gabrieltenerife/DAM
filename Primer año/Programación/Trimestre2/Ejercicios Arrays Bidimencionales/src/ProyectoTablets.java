import java.util.Scanner;

public class ProyectoTablets {

	public static void main(String[] args) {
	
		/*
		 * Organize el ejercicio de tal manera que existen 2 tablas:
		 * -Tablets: En esta lista solo aparecen las tablets que se incertan y estan disponibles para la venta, por tanto solo tiene una columna.
		 * -Clientes: Esta tabla aparecen los clientes y las tablets que tienen en pertenencia. En la primera columna aparecen los clientes y en el resto todas las tablets que posean.
		 */
		
		//Varibles
		Scanner sc = new Scanner(System.in);
		int menu;
		String codigo, dni;
		boolean introducir = true, introducir1 = true, introducir2=true, introducir3=true;
		final int FILAST=100, COLUMNAST=1, FILASC=100, COLUMNASC=100;
		
		//Pedir datos
		String tablet [][] = new String [FILAST][COLUMNAST];
		String clientes [][] = new String [FILASC][COLUMNASC];
		
		do {
			System.out.println("Selecciona una opción del menu: ");
			System.out.println("1. -Dar de alta una tablet");
			System.out.println("2. -Dar de alta un cliente");
			System.out.println("3. -Vender una tablet a un cliente");
			System.out.println("4. -Mostrar tablets disponibles para venta");
			System.out.println("5. -Mostrar tablets compradas por un cliente");
			System.out.println("6. -Salir");
			menu = sc.nextInt();
			switch(menu) {
				case 1:
						System.out.println("Introduce numero del codigo de barras");
						codigo=sc.next();
						for(int i=0;i<FILAST;i++) {
							if(tablet[i][0]!=null && tablet[i][0].equals(codigo)) {
								System.out.println("Esta tablet ya consta en la base de datos");
								introducir = false;
							}
						}
						
						if(introducir == true) {
							for(int i=0;i<FILAST;i++) {
								if(tablet[i][0]==null) {
									tablet[i][0]=codigo;
									System.out.println("Tablet añadida correctamente");
									i=FILAST;
								}
							}
						}
						introducir = true;
					break;
					
				case 2:
						System.out.println("Introduce DNI del cliente");
						codigo=sc.next();
						for(int i=0;i<FILASC;i++) {
							if(clientes[i][0]!=null && clientes[i][0].equals(codigo)) {
								System.out.println("Este cliente ya consta en la base de datos");
								introducir = false;
							}
						}
						
						if(introducir == true) {
							for(int i=0;i<FILASC;i++) {
								if(clientes[i][0]==null) {
									clientes[i][0]=codigo;
									System.out.println("Cliente añadido correctamente");
									i=FILASC;
								}
							}
						}
						introducir = true;
					break;
					
				case 3:
						//Comprobamos si el tablet aparece en la base de datos
						System.out.println("Introduce numero del codigo de barras");
						codigo=sc.next();
						for(int i=0;i<FILAST;i++) {
							if(tablet[i][0]!=null && tablet[i][0].equals(codigo)) {
								introducir = false;
								introducir2 = false;
							}
						}
						if(introducir==true) {
							System.out.println("Esta tablet no costa en la base de datos");
						}
					
						//Comprobar si el cliente aparece en la base de datos
						System.out.println("Introduce DNI del cliente");
						dni=sc.next();
						for(int i=0;i<FILASC;i++) {
							if(clientes[i][0]!=null && clientes[i][0].equals(dni)) {
								introducir1 = false;
								introducir3 = false;
							}
						}
						if(introducir1==true) {
							System.out.println("Este cliente no consta en la base de datos");
						}
						
						//Elminamos la tablet de la tabla de disponibles
						if(introducir2==false && introducir3==false) {
							for(int i=0;i<FILAST;i++) {
								if(tablet[i][0]!=null && tablet[i][0].equals(codigo)) {
									tablet[i][0]=null;
								}
							}
							//Añadimos la tablet al cliente propietario
							for(int i=0;i<FILASC;i++) {
								if(clientes[i][0]!=null && clientes[i][0].equals(dni)) {
									for(int j=1;j<COLUMNASC;j++) {
										if(clientes[i][j]==null) {
											clientes[i][j]=codigo;
											System.out.println("La venta se a realizado correctamente");
											j=COLUMNASC;
											i=FILASC;
										}
									}
							    }
							}
						}
						introducir = true;
						introducir1 = true;
						introducir2 = true;
						introducir3 = true;

					break;
					
				case 4:
					    System.out.println("Mostrando Stock de tablets: ");
					    for(int i=0;i<FILAST;i++) {
					    	if(tablet[i][0]!=null) {
					    		System.out.println(tablet[i][0]);
					    	}
					    }
					break;
					
				case 5:
						System.out.println("Introduce DNI del cliente");
						dni=sc.next();
						for(int i=0;i<FILASC;i++) {
							if(clientes[i][0]!=null && clientes[i][0].equals(dni)) {
								for(int j=1;j<COLUMNASC;j++) {
									if(clientes[i][j]!=null) {
										System.out.println(clientes[i][j]);
										introducir1=false;
									}
								}
								i=FILASC;
							}
						}
						if(introducir1==true) {
							System.out.println("Este cliente no consta en la base de datos");
						}
						introducir1=true;
						break;
							
					default:
						if(menu!=6) {
							System.out.println("Seleccina una de las opciones disponibles");
						}
					break;	
			} 
		}while(menu!=6);
	}		
}
