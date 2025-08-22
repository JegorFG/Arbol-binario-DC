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
 * Clase genérica para la implementación de un Árbol Binario.
 * Utiliza nodos genéricos para almacenar cualquier tipo de dato comparable.
 */

public class ArbolBinario<T extends Comparable<T>> {

    // Nodo raíz del árbol. Desde aquí se conecta toda la estructura.
    protected NodoArbol<T> raiz;

    // Método público para insertar un nuevo dato en el árbol.
    public void insertar(T dato) {
        if (dato == null) return; // Se descarta el dato si no tiene valor.
        raiz = insertarRec(raiz, dato); // Se delega la inserción al método recursivo.
    }

    // Método recursivo que localiza la posición correcta en el árbol
    // - Si el dato es menor, va a la izquierda.
    // - Si es mayor, va a la derecha.
    // - Si es igual, no se inserta (no se permiten duplicados).
    private NodoArbol<T> insertarRec(NodoArbol<T> nodo, T dato) {
        if (nodo == null) return new NodoArbol<>(dato); // Caso base: se crea un nuevo nodo.

        // La comparación entre el nuevo dato y el nodo actual se hace mediante compareTo(),
        // método heredado de la interfaz Comparable<T>. Esto permite decidir si ir a la izquierda
        // (cuando el nuevo dato es menor), o a la derecha (cuando es mayor).
        if (dato.compareTo(nodo.getDato()) < 0) {
            nodo.setIzquierdo(insertarRec(nodo.getIzquierdo(), dato)); // Recorre rama izquierda.
        } else if (dato.compareTo(nodo.getDato()) > 0) {
            nodo.setDerecho(insertarRec(nodo.getDerecho(), dato));     // Recorre rama derecha.
        }

        // Si el dato es igual al del nodo actual, se ignora.
        return nodo;
    }

    /* MÉTODOS DE RECORRIDO*/
    // Cada uno devuelve los elementos del árbol en un orden distinto.
    
    // Se exponen los métodos sin parámetros para simplificar su uso desde fuera de la clase,
    // ocultando los detalles de la implementación interna.
    
    // Crea un StringBuilder para ir acumulando el resultado y llama al método recursivo privado
    // que hace el trabajo real de recorrer el árbol.
    
    // Utiliza un objeto StringBuilder y no String para construir eficientemente 
    // el resultado del recorrido, evitando concatenaciones innecesarias de cadenas.

    // Recorrido INORDEN (izquierda – raíz – derecha).
    public String recorridoInOrden() {
        StringBuilder sb = new StringBuilder();
        recorridoInOrdenRec(raiz, sb);
        return sb.toString();
    }

    private void recorridoInOrdenRec(NodoArbol<T> nodo, StringBuilder sb) {
        if (nodo != null) {
            recorridoInOrdenRec(nodo.getIzquierdo(), sb);         // Visita izquierda.
            sb.append(nodo.getDato().toString()).append("\n");    // Visita raíz.
            recorridoInOrdenRec(nodo.getDerecho(), sb);           // Visita derecha.
        }
    }

    // Recorrido PREORDEN (raíz – izquierda – derecha).
    public String recorridoPreOrden() {
        StringBuilder resultado = new StringBuilder();
        recorridoPreOrden(raiz, resultado);
        return resultado.toString();
    }

    private void recorridoPreOrden(NodoArbol<T> nodo, StringBuilder resultado) {
        if (nodo != null) {
            resultado.append(nodo.getDato().toString()).append("\n"); // Visita raíz.
            recorridoPreOrden(nodo.getIzquierdo(), resultado);        // Visita izquierda.
            recorridoPreOrden(nodo.getDerecho(), resultado);          // Visita derecha.
        }
    }

    // Recorrido POSTORDEN (izquierda – derecha – raíz).
    public String recorridoPostOrden() {
        StringBuilder sb = new StringBuilder();
        recorridoPostOrden(raiz, sb);
        return sb.toString();
    }

    private void recorridoPostOrden(NodoArbol<T> nodo, StringBuilder sb) {
        if (nodo != null) {
            recorridoPostOrden(nodo.getIzquierdo(), sb);          // Visita izquierda.
            recorridoPostOrden(nodo.getDerecho(), sb);            // Visita derecha.
            sb.append(nodo.getDato().toString()).append("\n");    // Visita raíz.
        }
    }

    // Métodos de acceso a la raíz del árbol.
    // Permiten acceder o modificar directamente la referencia al nodo raíz.
    public NodoArbol<T> getRaiz() {
        return raiz;
    }

    public void setRaiz(NodoArbol<T> raiz) {
        this.raiz = raiz;
    }
}
