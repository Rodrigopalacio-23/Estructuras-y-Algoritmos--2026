/*
Quiero implementar en Java un simulador de cola de impresión (ColaImpresion) utilizando una estructura de Cola basada en arreglos.

### Estructura y Arreglo Interno
La clase debe definir una entidad inmutable Documento(String nombre, int paginas) y gestionar un arreglo Documento[] trabajos de tamaño fijo, con variables de control 'frente', 'final' y 'pendientes'.

### Razonamiento: ¿Por qué una Cola representa correctamente el orden de impresión?
En un entorno informático, la impresora es un periférico de salida compartido por múltiples aplicaciones y usuarios concurrentes:
- Los documentos llegan a velocidades variables y no pueden imprimirse todos al mismo tiempo debido a las restricciones mecánicas del hardware.
- Una Cola FIFO (First-In, First-Out) actúa como un búfer o "spooler" de impresión que conserva con exactitud el orden cronológico en que se emitieron las solicitudes. El primer documento enviado es el primero en ser expulsado en papel.
- Si utilizáramos una Pila (LIFO), un usuario que envía un documento extenso al comienzo vería postergada su impresión cada vez que otro usuario envíe un documento nuevo, generando frustración e inequidad. Por ende, la Cola FIFO es el estándar de la arquitectura de sistemas operativos para buffers de impresión.

### Operaciones Requeridas
- void enviarAImprimir(String nombre, int paginas): Encola un nuevo trabajo.
- Documento imprimirSiguiente(): Desencola y simula la impresión del documento.
- Documento consultarProximo(): Muestra el documento que está en cabecera sin imprimirlo.
- boolean tieneTrabajosPendientes(), boolean colaLlena(), int totalHojasPendientes().

### Casos Límite y Manejo de Errores
- Cola de impresión saturada: Si el búfer está lleno y se envía otro trabajo, lanzar IllegalStateException("Error: Búfer de impresión lleno. No se puede encolar el trabajo.").
- Búfer vacío: Si la impresora intenta imprimir sin trabajos pendientes, lanzar IllegalStateException("Error: No hay documentos en cola para imprimir.").

### Casos de Prueba en Main
Crear una cola con capacidad para 4 documentos. Encolar:
1. "Tesis_Final.pdf" (120 págs)
2. "Resumen_Historia.docx" (15 págs)
3. "Factura_Compra.pdf" (2 págs)
Consultar próximo documento. Llenar la cola con "Presentacion.pptx" (45 págs). Intentar encolar en buffer lleno capturando el error. Imprimir todos los documentos mostrando el orden FIFO. Intentar imprimir con cola vacía.
*/

package pilas_y_colas.ejercicio08;

public class ColaImpresion {

    public record Documento(String nombre, int paginas) {
        @Override
        public String toString() {
            return String.format("\"%s\" (%d páginas)", nombre, paginas);
        }
    }

    private final Documento[] trabajos;
    private int frente;
    private int fin;
    private int pendientes;
    private final int capacidad;

    public ColaImpresion(int capacidad) {
        if (capacidad <= 0) {
            throw new IllegalArgumentException("La capacidad debe ser mayor que 0.");
        }
        this.capacidad = capacidad;
        this.trabajos = new Documento[capacidad];
        this.frente = 0;
        this.fin = -1;
        this.pendientes = 0;
    }

    public void enviarAImprimir(String nombre, int paginas) {
        if (colaLlena()) {
            throw new IllegalStateException("Error: Búfer de impresión lleno (capacidad " + capacidad + "). No se puede encolar: " + nombre);
        }
        Documento doc = new Documento(nombre, paginas);
        trabajos[++fin] = doc;
        pendientes++;
        System.out.println("-> [Spooler] Recibido trabajo: " + doc + " (Trabajos en cola: " + pendientes + ")");
    }

    public Documento imprimirSiguiente() {
        if (!tieneTrabajosPendientes()) {
            throw new IllegalStateException("Error: No hay documentos en cola para imprimir.");
        }
        Documento doc = trabajos[frente];
        trabajos[frente++] = null; // Limpieza de referencia
        pendientes--;
        System.out.println("<- [Impresora] Imprimiendo: " + doc + " | Páginas impresas: " + doc.paginas());
        return doc;
    }

    public Documento consultarProximo() {
        if (!tieneTrabajosPendientes()) {
            throw new IllegalStateException("Error: Búfer vacío, no hay trabajos pendientes.");
        }
        return trabajos[frente];
    }

    public boolean tieneTrabajosPendientes() {
        return pendientes > 0;
    }

    public boolean colaLlena() {
        return fin == capacidad - 1;
    }

    public int totalHojasPendientes() {
        int total = 0;
        for (int i = frente; i <= fin; i++) {
            if (trabajos[i] != null) {
                total += trabajos[i].paginas();
            }
        }
        return total;
    }

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println(" EJERCICIO 8: COLA DE IMPRESIÓN (SPOOLER FIFO)");
        System.out.println("==================================================\n");

        ColaImpresion impresora = new ColaImpresion(4);

        System.out.println("--- 1. Envío de trabajos de impresión ---");
        impresora.enviarAImprimir("Tesis_Final.pdf", 120);
        impresora.enviarAImprimir("Resumen_Historia.docx", 15);
        impresora.enviarAImprimir("Factura_Compra.pdf", 2);

        System.out.println("\nPróximo en salir por impresora: " + impresora.consultarProximo());
        System.out.println("Total de páginas acumuladas en espera: " + impresora.totalHojasPendientes() + " págs.\n");

        System.out.println("--- 2. Llenado del buffer y saturación ---");
        impresora.enviarAImprimir("Presentacion.pptx", 45);

        try {
            impresora.enviarAImprimir("Reporte_Mensual.xlsx", 8);
        } catch (IllegalStateException e) {
            System.out.println("Excepción capturada: " + e.getMessage() + "\n");
        }

        System.out.println("--- 3. Procesamiento en orden secuencial FIFO ---");
        while (impresora.tieneTrabajosPendientes()) {
            impresora.imprimirSiguiente();
        }

        System.out.println("\n--- 4. Intento de impresión con buffer vacío ---");
        try {
            impresora.imprimirSiguiente();
        } catch (IllegalStateException e) {
            System.out.println("Excepción capturada: " + e.getMessage() + "\n");
        }

        System.out.println("\nPrueba de Ejercicio 8 completada con éxito.");
    }
}

/*
Ajustes al prompt:
Sin ajustes.
*/

