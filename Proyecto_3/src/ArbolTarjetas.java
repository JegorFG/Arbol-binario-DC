
import java.util.List;
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Jegor
 * Quien no sabe lo que busca no entiende lo que encuentra...
 */
// Clase especializada que extiende ArbolBinario para manejar objetos Tarjeta
public class ArbolTarjetas extends ArbolBinario<Tarjeta> {

    private String mensajeEliminacion; // para mensajes de error/resultado
    
    public Tarjeta buscarPorId(int id) {
        return buscarPorIdRec(raiz, id);
    }

    // Método recursivo que explora el árbol para buscar la tarjeta con el ID recibido
    // Se explora primero el nodo actual, luego el subárbol izquierdo y derecho.
    private Tarjeta buscarPorIdRec(NodoArbol<Tarjeta> nodo, int id) {
        if (nodo == null) return null; // Caso base: nodo vacío
        Tarjeta tarjeta = nodo.getDato();

        if (tarjeta.getId() == id) return tarjeta; // Encontró la tarjeta

        // Busca en subárbol izquierdo
        Tarjeta izq = buscarPorIdRec(nodo.getIzquierdo(), id);
        if (izq != null) return izq; // Si la encuentra en izquierda, devuelve

        // Busca en subárbol derecho
        return buscarPorIdRec(nodo.getDerecho(), id);
    }
    
    /* Métodos especializados para la clase ArbolTarjetas */
    
    // Se exponen los métodos sin parámetros para simplificar su uso desde fuera de la clase,
    // ocultando los detalles de la implementación interna.
    

    //Cuenta las tarjetas en el árbol que pertenecen a las categorías indicadas.
    public int contarPorCategoria(String categoria1, String categoria2) {
        return contarRec(raiz, categoria1, categoria2);
    }

    // Método recursivo para contar las tarjetas
    private int contarRec(NodoArbol<Tarjeta> nodo, String c1, String c2) {
        if (nodo == null) return 0; // Si el árbol está vacio retorna cero.

        Tarjeta t = nodo.getDato();
        // Si coincide la categoría con c1 o c2 cuma 1 de lo contrario suma cero
        int count = (t.getCategoria().equalsIgnoreCase(c1) || t.getCategoria().equalsIgnoreCase(c2)) ? 1 : 0;

        // Suma el conteo actual más el resultado de contar en los subárboles izquierdo y derecho de forma recursiva.
        return count + contarRec(nodo.getIzquierdo(), c1, c2) + contarRec(nodo.getDerecho(), c1, c2);
    }
    
    public String eliminarPorIdConValidacion(int id) {
        mensajeEliminacion = "";
        if (!existe(id)) {
            return "No se encontró ninguna tarjeta con ID " + id + ".";
        }
        raiz = eliminarRecConValidacion(raiz, id);
        if (mensajeEliminacion.isEmpty()) {
            //return "Tarjeta con ID " + id + " eliminada con éxito.";
            return "Éxito.";
        } else {
            return mensajeEliminacion;
        }
    }

    private NodoArbol<Tarjeta> eliminarRecConValidacion(NodoArbol<Tarjeta> nodo, int id) {
        if (nodo == null) return null;

        Tarjeta actual = nodo.getDato();

        if (id < actual.getId()) {
            nodo.setIzquierdo(eliminarRecConValidacion(nodo.getIzquierdo(), id));
        } else if (id > actual.getId()) {
            nodo.setDerecho(eliminarRecConValidacion(nodo.getDerecho(), id));
        } else {
            // Nodo encontrado, evaluar casos de eliminación

            // No eliminar si categoría es "Civiles"
            if (actual.getCategoria().equalsIgnoreCase("Civiles")) {
                mensajeEliminacion = "No se puede eliminar la tarjeta con ID " + id + " porque pertenece a la categoría Civiles.";
                return nodo;
            }

            // No eliminar si tiene dos hijos
            if (nodo.getIzquierdo() != null && nodo.getDerecho() != null) {
                mensajeEliminacion = "No se puede eliminar el nodo con ID " + id + " porque tiene dos hijos.";
                return nodo;
            }

            // No eliminar si solo tiene subárbol derecho
            if (nodo.getIzquierdo() == null && nodo.getDerecho() != null) {
                mensajeEliminacion = "No se puede eliminar el nodo con ID " + id + " porque tiene un    subárbol derecho.";
                return nodo;
            }

            // Caso 1: nodo hoja
            if (nodo.getIzquierdo() == null && nodo.getDerecho() == null) {
                return null;
            }

            // Caso 2: nodo con un solo hijo izquierdo
            if (nodo.getDerecho() == null) {
                return nodo.getIzquierdo();
            }
        }
        return nodo;
    }
    
    // Elimina la tarjeta con el ID recibido si existe en el árbol sin importar 
    // si tiene hijos reacomodando los nodos.
    public boolean eliminarPorId(int id) {
        if (!existe(id)) return false; // Verifica existencia antes de eliminar
        raiz = eliminarRec(raiz, id);  // Actualiza la raíz tras eliminación
        return true;
    }

    // Método recursivo para eliminar el nodo correspondiente
    private NodoArbol<Tarjeta> eliminarRec(NodoArbol<Tarjeta> nodo, int id) {
        if (nodo == null) return null; // No hay nodos

        Tarjeta actual = nodo.getDato();

        // Evaluamos si el id es menor al id de la posición del nodo actual
        // para ver si recorremos el árbol por la izquierda
        if (id < actual.getId()) {
            nodo.setIzquierdo(eliminarRec(nodo.getIzquierdo(), id));
        // Evaluamos si el id es mayor al id de la posición del nodo actual
        // para ver si recorremos el árbol por la derecha
        } else if (id > actual.getId()) {
            nodo.setDerecho(eliminarRec(nodo.getDerecho(), id));
        } else {
            // Nodo encontrado, evaluar casos de eliminación
            
            // Caso 1: Nodo sin hijos
            if (nodo.getIzquierdo() == null && nodo.getDerecho() == null) {
                return null;
            }
            // Caso 2: Nodo con un solo hijo (derecho o izquierdo)
            else if (nodo.getIzquierdo() == null) {
                return nodo.getDerecho();
            } else if (nodo.getDerecho() == null) {
                return nodo.getIzquierdo();
            }
            // Caso 3: Nodo con dos hijos
            else {
                // Para eliminar un nodo con dos hijos, se reemplaza su dato por el sucesor inorden,
                // que es el nodo con el valor mínimo en el subárbol derecho.
                // Esto garantiza que el árbol mantenga la propiedad de búsqueda binaria:
                // - Todos los nodos a la izquierda son menores que el nodo actual.
                // - Todos los nodos a la derecha son mayores que el nodo actual.
                NodoArbol<Tarjeta> sucesor = encontrarMinimo(nodo.getDerecho()); // Encuentra sucesor en subárbol derecho
                nodo.setDato(sucesor.getDato());  // Reemplaza dato actual con el sucesor
                nodo.setDerecho(eliminarRec(nodo.getDerecho(), sucesor.getDato().getId())); // Elimina sucesor duplicado
            }
        }
        return nodo;
    }

    // Encuentra el nodo con el valor mínimo en un subárbol que debería estar siempre a la izquierda
    private NodoArbol<Tarjeta> encontrarMinimo(NodoArbol<Tarjeta> nodo) {
        while (nodo.getIzquierdo() != null) {
            nodo = nodo.getIzquierdo();
        }
        return nodo;
    }

    // Encuentra el nodo con el valor maximo en un subárbol que debería estar siempre a la derecha
    private NodoArbol<Tarjeta> encontrarMaximo(NodoArbol<Tarjeta> nodo) {
        while (nodo.getDerecho()!= null) {
            nodo = nodo.getDerecho();
        }
        return nodo;
    }

    // Verifica si el id existe en el árbol
    public boolean existe(int id) {
        return buscarPorId(raiz, id) != null;
    }

    // busqueda recursiva para encontrar el id en el árbol
    private Tarjeta buscarPorId(NodoArbol<Tarjeta> nodo, int id) {
        if (nodo == null) return null; // Árbol vacio
        Tarjeta actual = nodo.getDato();
        if (actual.getId() == id) {
            return actual;
        }
        Tarjeta izquierda = buscarPorId(nodo.getIzquierdo(), id);
        if (izquierda != null) return izquierda;
        return buscarPorId(nodo.getDerecho(), id);
    }

    // Cuenta las tarjetas que pertenecen a la categoría "Super héroes" o "Super villanos"
    public int contarTarjetasCategoria() {
        return contarCategoria(raiz);
    }

    // Recorre el árbol de forma recursiva en busca de las categorías
    private int contarCategoria(NodoArbol<Tarjeta> nodo) {
        if (nodo == null) return 0;
        int conteo = 0;
        Tarjeta tarjeta = nodo.getDato();
        if (tarjeta.getCategoria().equalsIgnoreCase("Súper héroes") ||
            tarjeta.getCategoria().equalsIgnoreCase("Súper villanos")) {
            conteo++;
        }
        conteo += contarCategoria(nodo.getIzquierdo());
        conteo += contarCategoria(nodo.getDerecho());
        return conteo;
    }

    // Lista las descripciones de las tarjetas con la categoría "Fraces icónicas" que están en las hojas del árbol.
    public List<String> listarDescripcionesFrasesIconicasEnHojas() {
        List<String> descripciones = new ArrayList<>();
        listarDescripcionesFrasesIconicasEnHojasRec(raiz, descripciones);
        return descripciones;
    }

    // método recursivo que recorre el árbol y añade a la lista descripciones.
    private void listarDescripcionesFrasesIconicasEnHojasRec(NodoArbol<Tarjeta> nodo, List<String> lista) {
        if (nodo == null) return;  // Caso base: si el nodo es nulo, no hay nada que hacer.

        // Determina si el nodo actual es hoja (no tiene hijos)
        boolean esHoja = nodo.getIzquierdo() == null && nodo.getDerecho() == null;
        Tarjeta tarjeta = nodo.getDato();

        // Si es hoja y la categoría es "Frases icónicas", agrega la descripción a la lista
        if (esHoja && tarjeta.getCategoria().equalsIgnoreCase("Frases icónicas")) {
            lista.add(tarjeta.getDescripcion());
        }

        // Continúa recorriendo el subárbol izquierdo y derecho recursivamente
        listarDescripcionesFrasesIconicasEnHojasRec(nodo.getIzquierdo(), lista);
        listarDescripcionesFrasesIconicasEnHojasRec(nodo.getDerecho(), lista);
    }


    // Método para obtener la tarjeta con el menor id del árbol.
    public Tarjeta obtenerTarjetaMenorId() {
        return obtenerTarjetaMenorIdRec(raiz, null);
    }

    private Tarjeta obtenerTarjetaMenorIdRec(NodoArbol<Tarjeta> nodo, Tarjeta actualMenor) {
        if (nodo == null) return actualMenor; // Caso base si el nodo es nulo.

        Tarjeta t = nodo.getDato(); // Se obtiene la tarjeta almacenada en el nodo actual.

        // Si no se ha asignado aún un id mínimo o si la tarjeta actual tiene un ID menor, se actualiza el mínimo.
        if (actualMenor == null || t.getId() < actualMenor.getId()) {
            actualMenor = t;
        }

        // Se continúa recorriendo recursivamente el subárbol izquierdo y derecho,
        // actualizando la tarjeta con menor ID según se vaya encontrando una más pequeña.
        actualMenor = obtenerTarjetaMenorIdRec(nodo.getIzquierdo(), actualMenor);
        actualMenor = obtenerTarjetaMenorIdRec(nodo.getDerecho(), actualMenor);

        // Nota: Aunque en un Árbol Binario los menores suelen estar en la rama izquierda,
        // este método recorre ambos subárboles porque no se asume un orden estricto en la estructura.
        // Esto garantiza encontrar la tarjeta con el ID más bajo aunque esté mal posicionada.
        
        return actualMenor; // Retorna la tarjeta con el menor ID encontrada tras recorrer todo el árbol.
    }

    // Método para obtener la tarjeta con el mayor id del árbol.
    public Tarjeta obtenerTarjetaMayorId() {
        return obtenerTarjetaMayorIdRec(raiz, null);
    }

    private Tarjeta obtenerTarjetaMayorIdRec(NodoArbol<Tarjeta> nodo, Tarjeta actualMayor) {
        if (nodo == null) return actualMayor;// Caso base si el nodo es nulo.
        Tarjeta t = nodo.getDato();

        // Si no se ha asignado aún un id mínimo o si la tarjeta actual tiene un ID mayor, se actualiza el máximo.
        if (actualMayor == null || t.getId() > actualMayor.getId()) {
            actualMayor = t;
        }

        // Se continúa recorriendo recursivamente el subárbol izquierdo y derecho,
        // actualizando la tarjeta con menor ID según se vaya encontrando una más grande.
        actualMayor = obtenerTarjetaMayorIdRec(nodo.getIzquierdo(), actualMayor);
        actualMayor = obtenerTarjetaMayorIdRec(nodo.getDerecho(), actualMayor);

        // Nota: Aunque en un Árbol Binario los mayores suelen estar en la rama derecha,
        // este método recorre ambos subárboles porque no se asume un orden estricto en la estructura.
        // Esto garantiza encontrar la tarjeta con el ID más alto aunque esté mal posicionada.
        
        return actualMayor;
    }
}