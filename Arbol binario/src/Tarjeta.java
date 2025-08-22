/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Jegor
 * Quien no sabe lo que busca no entiende lo que encuentra...
 */
public class Tarjeta implements Comparable<Tarjeta> {
    private int id;
    private String descripcion;
    private String categoria;

    public Tarjeta(int id, String descripcion, String categoria) {
        this.id = id;
        this.descripcion = descripcion;
        this.categoria = categoria;
    }

    public int getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getCategoria() {
        return categoria;
    }

    // Implementación del método compareTo heredado de la interfaz Comparable<Tarjeta>.
    // Permite comparar dos objetos Tarjeta por su atributo id.
    // Retorna un valor negativo, cero o positivo según si this.id es menor, 
    // igual o mayor que el id de la otra tarjeta.
    @Override
    public int compareTo(Tarjeta otra) {
        return Integer.compare(this.id, otra.id); 
    }

    // Sobrescritura del método toString() para representar el contenido de la tarjeta como una cadena legible.
    // Este formato facilita la visualización del objeto al imprimirlo, por ejemplo, en un recorrido del árbol.
    @Override
    public String toString() {
        return "ID: " + id + ", Descripción: " + descripcion + ", Categoría: " + categoria;
    }
}
