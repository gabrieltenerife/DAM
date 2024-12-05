package multihilos;

public class ImprimeNumero implements Runnable {

	private int muestra;
	
	public ImprimeNumero (int n) {muestra = n;}
	
	
	
	
	@Override
	public void run() {
		for(int i = 1; i<= muestra; i++) {
			System.out.print("" + i);
			Thread.yield();
			}
		
	}

}
