/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Jegor
 * Quien no sabe lo que busca no entiende lo que encuentra...
 */
/*
 * Nodo genérico para la implementación de un árbol binario.
 * Permite almacenar cualquier tipo de dato utilizando el parámetro genérico <T>.
 */

public class NodoArbol<T> {
    // Dato almacenado en el Nodo
    private T dato;
    // Referencias a los hijos izquierdo y derecho
    private NodoArbol<T> izquierdo;
    private NodoArbol<T> derecho;

    // Constructor que recibe el dato y deja los hijos nulos
    public NodoArbol(T dato) {
        this.dato = dato;
        this.izquierdo = null;
        this.derecho = null;
    }

    // Métodos Getters y Setters
    public T getDato() {
        return dato;
    }

    public void setDato(T dato) {
        this.dato = dato;
    }

    public NodoArbol<T> getIzquierdo() {
        return izquierdo;
    }

    public void setIzquierdo(NodoArbol<T> izquierdo) {
        this.izquierdo = izquierdo;
    }

    public NodoArbol<T> getDerecho() {
        return derecho;
    }

    public void setDerecho(NodoArbol<T> derecho) {
        this.derecho = derecho;
    }
}