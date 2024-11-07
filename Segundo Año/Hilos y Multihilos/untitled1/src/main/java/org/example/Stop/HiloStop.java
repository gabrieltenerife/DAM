package org.example.Stop;

public class HiloStop implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Contador num: " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {

                /*
                Aqui cuando en el main ocurre el interrump, salta la exepccion, y
                inmprime el mensaje, y el return hace que no siga ejecutando mas el hilo.
                 */
                System.out.println("Me pararon");
                return;

                /*
                Tambien:

                if(Thread.interrupted()){
                    return;
                }
                 */
            }
        }
    }
}
