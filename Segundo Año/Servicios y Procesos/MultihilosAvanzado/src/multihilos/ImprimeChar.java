package multihilos;

public class ImprimeChar implements Runnable {

	private char imprime;
	private int veces;
	
	public ImprimeChar(char c, int t) {
		imprime = c;
		veces = t;
	}
	
	// El try catch debe estar dentro de el bucle sino puede fallar.
	@Override
	public void run() {
			for(int i = 0; i < veces; i++) {
				System.out.print("" + imprime + "");
				if (i<10) {
					try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}}	
			}
		
	}

}
