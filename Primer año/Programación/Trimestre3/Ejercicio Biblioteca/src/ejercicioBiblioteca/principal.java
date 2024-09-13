package ejercicioBiblioteca;

import java.util.Scanner;

public class principal {

	public static void main(String[] args) {
		String dni, titulo, isbn, autor, genero, publicacion, fechaInicio, fechaFinal, fechaDevolucion;
		int ejemplares, opcion;
		Scanner sc = new Scanner(System.in);
		
		libro arrayLibros [] = new libro[20];
		prestamo arrayPrestamos [] = new prestamo [100];
		
		do {
			System.out.println("Menú de opciones");
			System.out.println("1.- Dar de alta libro nuevo");
			System.out.println("2.- Realizar un préstamo");
			System.out.println("3.- Realizar una devolución");
			System.out.println("4.- Mostrar préstamos de un clientes");
			System.out.println("5.- Mostrar préstamos de un libro");
			System.out.println("6.- Mostrar todos los préstamos");
			System.out.println("7.- Mostrar devoluciones de un clientes");
			System.out.println("8.- Mostrar devoluciones de un libro");
			System.out.println("9.- Mostrar todas las devoluciones");
			System.out.println("10.- Salir");
			opcion = sc.nextInt();
			
			switch (opcion) {
				case 1: System.out.print("Dime el isbn del libro: ");
						isbn=sc.next();
						System.out.print("Dime el titulo del libro: ");
						titulo=sc.next();
						System.out.print("Dime el autor del libro: ");
						autor=sc.next();
						System.out.print("Dime el genero del libro: ");
						genero=sc.next();
						System.out.print("Dime la publicacion del libro: ");
						publicacion=sc.next();
						System.out.print("Dime el numero de ejemplares: ");
						ejemplares=sc.nextInt();
						for(int i=0; i<arrayLibros.length; i++) {
							if(arrayLibros[i]==null) {
								arrayLibros[i]=new libro(titulo,isbn,autor,genero,publicacion,ejemplares);
								System.out.println("Libro creado y guardado correctamente");
								break;
							}
						}
					break;
					
				case 2: System.out.print("Dime el isbn del libro: ");
						isbn=sc.next();
						for(int i=0;i<arrayLibros.length;i++) {
							if(arrayLibros[i]!=null && arrayLibros[i].getIsbn().equals(isbn)) {
								if(arrayLibros[i].getNumEjemplares()>0) {
									arrayLibros[i].prestamo();
									System.out.print("Dime el dni del cliente: ");
									dni=sc.next();
									System.out.print("Fecha Inicio");
									fechaInicio=sc.next();
									System.out.print("Fecha Final");
									fechaFinal=sc.next();
									for(int j=0; j<arrayPrestamos.length; j++) {
										if(arrayPrestamos[j]==null) {
											arrayPrestamos[j]=new prestamo(isbn,dni,fechaInicio,fechaFinal);
											System.out.println("Prestamo realizado correctamente");
											break;
										}
									}
								}
							break;
							}
						}
					break;
				case 3: System.out.print("Dime el isbn del libro: ");
						isbn=sc.next();
						System.out.print("Dime el dni del cliente: ");
						dni=sc.next();
						for(int i=0;i<arrayPrestamos.length;i++) {
							if(arrayPrestamos[i]!=null && arrayPrestamos[i].getISBN().equals(isbn) && arrayPrestamos[i].getDni().equals(dni)) {
								System.out.print("Fecha Devolucion");
								fechaDevolucion=sc.next();
								arrayPrestamos[i].setFechaDevolucion(fechaDevolucion);
								for (int j=0; j<arrayLibros.length;j++) {
									if(arrayLibros[j]!=null && arrayLibros[i].getIsbn().equals(isbn)) {
										arrayLibros[j].devolucion();
										break;
									}
								}
							break;
							}
						}
					break;
				case 4: System.out.print("Dime el dni del cliente: ");
						dni=sc.next();
						for(int i=0;i<arrayPrestamos.length;i++) {
							if(arrayPrestamos[i]!=null && arrayPrestamos[i].getDni().equals(dni)){
								System.out.println(arrayPrestamos[i].toString());
								break;
							}
						}
					break;
			
			}
		} while (opcion!=10);
		
		
	}

}
