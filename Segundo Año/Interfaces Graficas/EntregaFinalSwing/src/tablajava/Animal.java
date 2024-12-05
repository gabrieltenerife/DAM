/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tablajava;

/**
 *
 * @author gamba
 */
public class Animal {
    
    String tipo;
    int codigo;
    String estadovacuna;
    Boolean produccion;
    String comentario;

    public Animal() {
    }

    public Animal(String tipo, int codigo, String estadovacuna, Boolean produccion, String comentario) {
        this.tipo = tipo;
        this.codigo = codigo;
        this.estadovacuna = estadovacuna;
        this.produccion = produccion;
        this.comentario = comentario;
    }

    public Animal(String tipo, int codigo, Boolean produccion, String comentario) {
        this.tipo = tipo;
        this.codigo = codigo;
        this.produccion = produccion;
        this.comentario = comentario;
    }

    public String getTipo() {
        return tipo;
    }

    public String getEstadovacuna() {
        return estadovacuna;
    }

    public void setEstadovacuna(String estadovacuna) {
        this.estadovacuna = estadovacuna;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Boolean getProduccion() {
        return produccion;
    }

    public void setProduccion(Boolean produccion) {
        this.produccion = produccion;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

}
