# Arbol-binario-DC

---

🌳 Árbol Binario en Java (Gestión de Tarjetas DC Comics)

Este proyecto implementa un árbol binario de búsqueda (ABB) en Java con interfaz gráfica (GUI), desarrollado como parte de un ejercicio académico para comprender y aplicar estructuras de datos jerárquicas.

El programa permite gestionar una colección de tarjetas de DC Comics almacenadas en un árbol binario, soportando inserciones, búsquedas, recorridos, eliminaciones y visualización gráfica del árbol.


---

🎯 Objetivos de Aprendizaje

Comprender la estructura, propiedades y tipos de árboles binarios.

Implementar árboles binarios en Java, creando clases y referencias para enlazar nodos.

Aplicar algoritmos clásicos de recorrido: preorden, inorden, postorden y BFS (por niveles).

Analizar la eficiencia de operaciones de inserción, búsqueda y eliminación.

Utilizar recursividad en estructuras jerárquicas.

Aplicar la estructura a un caso práctico: gestión de tarjetas coleccionables.



---

🛠️ Tecnologías Utilizadas

Lenguaje: Java 8+

IDE: NetBeans

GUI: Swing / AWT

Paradigma: Programación Orientada a Objetos



---

📦 Estructura del Proyecto

Tarjeta.java → Clase modelo con los atributos de cada tarjeta.

Nodo.java → Clase que representa cada nodo del árbol.

ArbolBinario.java → Implementación de las operaciones principales sobre el árbol.

VentanaPrincipal.java → Interfaz gráfica con todas las opciones.



---

📌 Funcionalidades Implementadas

✅ Inserción de tarjetas con validación de IDs únicos.

✅ Eliminación de nodos según condiciones específicas:

No se pueden eliminar tarjetas de categoría Civiles.

Restricciones especiales si el nodo tiene uno o dos hijos.


✅ Búsqueda de tarjetas por ID, mostrando sus datos completos.

✅ Recorridos clásicos: Preorden, Inorden y Postorden.

✅ Cantidad de nodos filtrados por categorías (“Súper héroes” y “Súper villanos”).

✅ Listado de nodos hoja de categoría “Frases icónicas”.

✅ Identificación del mayor y menor ID en el árbol.

✅ Visualización gráfica del árbol, mostrando los nodos en pantalla.


---

📊 Ejemplo de Datos en el Árbol

Cada tarjeta contiene:

Id (int): Identificador único.

Descripción (String): Texto libre.

Categoría (String): Seleccionada desde un DropDownList con opciones como:

Civiles

Equipos

Súper héroes

Objetos

Súper villanos

Paneles

Cara a cara

Frases icónicas

Película especial




---

🚀 Ejecución

1. Clona el repositorio:

git clone https://github.com/JegorFG/arbol-binario-dc.git
cd arbol-binario-dc


2. Abre el proyecto en NetBeans o tu IDE de preferencia.


3. Ejecuta la clase principal VentanaPrincipal.java.


4. Usa la interfaz para insertar, buscar, eliminar, recorrer y visualizar el árbol.


---

📸 Capturas 


---

📚 Temas de Estudio Relacionados

Árboles binarios de búsqueda (ABB).

Algoritmos de recorrido en árboles.

Complejidad temporal en inserciones, búsquedas y eliminaciones.

Representación gráfica de estructuras de datos.

---

🧑‍💻 Autor

Proyecto académico desarrollado por:
Jesús Garita Obando– JegorFG
