public class Gato {

    String nombre;
    int edad;
    String raza;
    boolean alergias;

    public Gato() {
    }

    public Gato(String nombre, int edad, String raza, boolean alergias) {
        this.nombre = nombre;
        this.edad = edad;
        this.raza = raza;
        this.alergias = alergias;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public boolean isAlergias() {
        return alergias;
    }

    public void setAlergias(boolean alergias) {
        this.alergias = alergias;
    }
}
