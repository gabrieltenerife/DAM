public class Cliente {
    String nombre, direccion;
    int ncliente;
    Double saldo;
    int cuenta;

    public Cliente() {
    }

    public Cliente(int cuenta, Double saldo, int ncliente, String direccion, String nombre) {
        this.cuenta = cuenta;
        this.saldo = saldo;
        this.ncliente = ncliente;
        this.direccion = direccion;
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getNcliente() {
        return ncliente;
    }

    public void setNcliente(int ncliente) {
        this.ncliente = ncliente;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public int getCuenta() {
        return cuenta;
    }

    public void setCuenta(int cuenta) {
        this.cuenta = cuenta;
    }
}
