package presencial;

import java.util.Scanner;

public class principal {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int opcionMenu, opcionAdmin, opcionUsuario;
		
		//Creación de objetos
		gestionMenus gm = new gestionMenus();
		gestion g = new gestion();
		
		do {
			gm.menuRegistro();
			opcionMenu=sc.nextInt();
			switch(opcionMenu) {
				case 1: do {
							gm.menuAdministrador();
							opcionAdmin=sc.nextInt();
							g.gestionAdmin(opcionAdmin);
						}while(opcionAdmin!=7);		
					break;
				case 2: do {
							gm.menuUsuario();
							opcionUsuario=sc.nextInt();
							g.gestionUsuario(opcionUsuario);
						}while(opcionUsuario!=4);
						
					break;
				case 3: System.out.println("Hasta la próxima");
					break;
				default: System.out.println("Opcion incorrecta");
			}
			
		} while (opcionMenu!=3);

	}

}
