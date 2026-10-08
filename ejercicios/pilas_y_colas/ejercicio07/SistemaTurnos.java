/*
Quiero implementar en Java un simulador de sistema de turnos para atención en una oficina (SistemaTurnos) utilizando una Cola basada en arreglos.

### Estructura y Arreglo Interno
La clase debe gestionar una entidad de turno Turno(int numero, String nombreCliente) y un arreglo Turno[] fila de capacidad fija, junto con índices 'frente', 'final' y un contador 'personasEsperando'.

### Razonamiento: ¿Por qué este problema utiliza FIFO y NO LIFO?
El principio de una sala de espera o atención ciudadana se rige por la justicia y el orden de llegada:
- FIFO (First-In, First-Out): La primera persona que llega a la oficina y solicita un turno es legal y moralmente la primera en ser llamada a ventanilla. Esto garantiza equidad y un tiempo de espera acotado.
- Si utilizáramos una Pila (LIFO): Cada nueva persona que ingresara a la oficina pasaría inmediatamente al frente para ser atendida antes que todos los demás. Las personas que llegaron temprano quedarían relegadas en la base de la pila, sufriendo un bloqueo indefinido o inanición (starvation). Por esta razón, el modelo LIFO es totalmente inadecuado e injusto para la atención de clientes.

### Operaciones Requeridas
- void registrarPersona(String nombreCliente): Emite un nuevo número correlativo de turno y encola a la persona.
- Turno atenderSiguiente(): Desencola y atiende a la persona que encabeza la fila.
- Turno consultarProximo(): Consulta quién está primero en la fila sin atenderlo.
- boolean hayPersonasEsperando(), boolean salaLlena(), int cantidadEnEspera().

### Casos Límite y Manejo de Errores
- Sala de espera llena: Si se intenta registrar un cliente cuando la cola está llena, lanzar IllegalStateException("Error: Sala de espera llena. No se pueden emitir más turnos por el momento.").
- No hay clientes para atender: Si se intenta atender o consultar cuando la cola está vacía, lanzar IllegalStateException("Error: No hay clientes esperando para ser atendidos.").

### Casos de Prueba en Main
Crear una sala con capacidad para 4 personas. Registrar a "Carlos", "Beatriz", "Andrés". Consultar quién está primero. Registrar a "Diana" para completar la capacidad. Intentar registrar a "Elena" con sala llena capturando la excepción. Atender a los clientes uno a uno demostrando el orden FIFO de atención. Intentar llamar a ventanilla con la sala vacía.
*/

package pilas_y_colas.ejercicio07;

public class SistemaTurnos {

    public record Turno(int numero, String nombreCliente) {
        @Override
        public String toString() {
            return String.format("Turno #%03d - %s", numero, nombreCliente);
        }
    }

    private final Turno[] fila;
    private int frente;
    private int fin;
    private int personasEsperando;
    private final int capacidad;
    private int contadorTurnos;

    public SistemaTurnos(int capacidad) {
        if (capacidad <= 0) {
            throw new IllegalArgumentException("La capacidad debe ser mayor que 0.");
        }
        this.capacidad = capacidad;
        this.fila = new Turno[capacidad];
        this.frente = 0;
        this.fin = -1;
        this.personasEsperando = 0;
        this.contadorTurnos = 0;
    }

    public Turno registrarPersona(String nombreCliente) {
        if (salaLlena()) {
            throw new IllegalStateException("Error: Sala de espera llena (capacidad " + capacidad + "). No se puede emitir turno para: " + nombreCliente);
        }
        contadorTurnos++;
        Turno nuevoTurno = new Turno(contadorTurnos, nombreCliente);
        fila[++fin] = nuevoTurno;
        personasEsperando++;
        System.out.println("-> Se emitió " + nuevoTurno + " (Personas en espera: " + personasEsperando + ")");
        return nuevoTurno;
    }

    public Turno atenderSiguiente() {
        if (!hayPersonasEsperando()) {
            throw new IllegalStateException("Error: No hay clientes esperando en la fila.");
        }
        Turno atendido = fila[frente];
        fila[frente++] = null; // Limpieza
        personasEsperando--;
        System.out.println("<- [Ventanilla] Atendiendo a: " + atendido + " (Restan en espera: " + personasEsperando + ")");
        return atendido;
    }

    public Turno consultarProximo() {
        if (!hayPersonasEsperando()) {
            throw new IllegalStateException("Error: No hay clientes en la fila.");
        }
        return fila[frente];
    }

    public boolean hayPersonasEsperando() {
        return personasEsperando > 0;
    }

    public boolean salaLlena() {
        return fin == capacidad - 1;
    }

    public int cantidadEnEspera() {
        return personasEsperando;
    }

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println(" EJERCICIO 7: SISTEMA DE TURNOS (FIFO)");
        System.out.println("==================================================\n");

        SistemaTurnos oficina = new SistemaTurnos(4);

        System.out.println("--- 1. Llegada de personas a la oficina ---");
        oficina.registrarPersona("Carlos Gomez");
        oficina.registrarPersona("Beatriz Perez");
        oficina.registrarPersona("Andres Lopez");

        System.out.println("\nPróximo en ser llamado: " + oficina.consultarProximo() + "\n");

        System.out.println("--- 2. Llenado de sala y caso límite ---");
        oficina.registrarPersona("Diana Ruiz");

        try {
            oficina.registrarPersona("Elena Morales");
        } catch (IllegalStateException e) {
            System.out.println("Excepción capturada: " + e.getMessage() + "\n");
        }

        System.out.println("--- 3. Atención en ventanilla (Orden FIFO riguroso) ---");
        while (oficina.hayPersonasEsperando()) {
            oficina.atenderSiguiente();
        }

        System.out.println("\n--- 4. Intento de atención con sala vacía ---");
        try {
            oficina.atenderSiguiente();
        } catch (IllegalStateException e) {
            System.out.println("Excepción capturada: " + e.getMessage() + "\n");
        }

        System.out.println("Prueba de Ejercicio 7 completada con éxito.");
    }
}

/*
Ajustes al prompt:
Sin ajustes.
*/

