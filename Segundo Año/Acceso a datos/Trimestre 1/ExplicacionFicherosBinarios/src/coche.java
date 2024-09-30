import java.io.Serializable;

public class coche implements Serializable {

    String marca, bastidor, color;

    public coche(String color, String marca, String bastidor) {
        this.color = color;
        this.marca = marca;
        this.bastidor = bastidor;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getBastidor() {
        return bastidor;
    }

    public void setBastidor(String bastidor) {
        this.bastidor = bastidor;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}