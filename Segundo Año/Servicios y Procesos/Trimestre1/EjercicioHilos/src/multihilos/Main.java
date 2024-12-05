package multihilos;

public class Main {

	public static void main(String[] args) {
		
		//Crear tareas
		Runnable imprimeA = new ImprimeChar('x',6);
		Runnable imprimeB = new ImprimeChar('0',13);
		Runnable imprime25 = new ImprimeNumero(25);
		
		//Crear hilos
		Thread hilo1 = new Thread (imprimeA);
		Thread hilo2 = new Thread (imprimeB);
		Thread hilo3 = new Thread (imprime25);
		
		//Lanzar hilos
		hilo1.start();
		hilo2.start();
		hilo3.start();
		hilo3.setPriority(Thread.MAX_PRIORITY);

	}

}
