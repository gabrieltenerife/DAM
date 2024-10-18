public class Canciones {
    String Nombre;
    String Disco;
    String Autor;
    Boolean Española;

    public Canciones(String nombre, String disco, String autor, Boolean española) {
        Nombre = nombre;
        Disco = disco;
        Autor = autor;
        Española = española;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getDisco() {
        return Disco;
    }

    public void setDisco(String disco) {
        Disco = disco;
    }

    public String getAutor() {
        return Autor;
    }

    public void setAutor(String autor) {
        Autor = autor;
    }

    public Boolean getEspañola() {
        return Española;
    }

    public void setEspañola(Boolean española) {
        Española = española;
    }
}
