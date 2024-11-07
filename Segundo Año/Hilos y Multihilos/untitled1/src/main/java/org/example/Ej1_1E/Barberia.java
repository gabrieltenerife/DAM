package org.example.Ej1_1E;

public class Barberia {
    private final int NumAsientos = 3;
    private int NumAsientosOcupados = 0;

    public Barberia() {
    }

    public int getNumAsientosOcupados() {
        return NumAsientosOcupados;
    }

    public boolean CogerAsiento(){
        if(NumAsientosOcupados < NumAsientos){
            NumAsientosOcupados++;
            return true;
        }
        return false;
    }

    public void CortarPelo(){
        double tiempo = (int) (Math.random() * 9) + 1;
        try {
            Thread.sleep((long) tiempo);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        NumAsientosOcupados--;
    }
}
