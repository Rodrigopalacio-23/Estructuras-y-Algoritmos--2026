/*
Quiero implementar en Java un verificador de paréntesis balanceados en expresiones matemáticas (ParentesisBalanceados) utilizando una Pila de caracteres implementada internamente con un arreglo.

### Estructura y Arreglo Interno
Para no utilizar colecciones de Java, implementaremos una pila interna basada en un arreglo de caracteres char[] pila, con tamaño suficiente para la expresión (por ejemplo longitud de la cadena) y un índice 'top'.

### Razonamiento: Uso de la Pila y Operación Pop
Al recorrer una expresión carácter por carácter de izquierda a derecha:
1. Paréntesis que abre '(': Representa una estructura anidada pendiente de resolución. Se apila (push) en la cima de la pila.
2. Paréntesis que cierra ')': Representa el cierre de la estructura abierta más reciente. En este instante:
   - Se consulta la pila. Si está vacía, significa que hay un cierre huérfano sin apertura previa que lo respalde -> el balanceo falla de inmediato (inválido).
   - Si no está vacía, se realiza un pop(), emparejando y cancelando la apertura pendiente más cercana (principio LIFO).
3. Final del análisis: Al concluir el recorrido completo:
   - Si la pila queda completamente vacía (isEmpty()), cada apertura encontró su correspondiente cierre -> resultado "válido".
   - Si la pila contiene elementos remanentes (top >= 0), hubo paréntesis que abrieron pero nunca se cerraron -> resultado "inválido".

### Casos Límite a Contemplar
- Cierre sin apertura al inicio o en el medio, como ")(" o "() )".
- Apertura sin cierre al final, como "((()".
- Expresiones sin ningún paréntesis, como "5 + 3 * 2" (debe ser válido).
- Expresión nula o vacía (válido trivialmente).

### Casos de Prueba en Main
1. "(5 + 3) * (2 + 1)" -> Válido
2. "(5 + 3)) * (2 + 1" -> Inválido (cierre prematuro y apertura sobrante)
3. ")(" -> Inválido
4. "5 + 3 * 2" -> Válido (sin paréntesis)
5. "((10 - 2) * (3 + (4 / 2)))" -> Válido (anidamiento múltiple)
6. "((5 + 2)" -> Inválido (falta cerrar)
*/

package pilas_y_colas.ejercicio03;

public class ParentesisBalanceados {

    /**
     * Pila de caracteres implementada puramente con arreglo.
     */
    private static class PilaCaracteres {
        private final char[] datos;
        private int top;

        public PilaCaracteres(int capacidad) {
            this.datos = new char[capacidad];
            this.top = -1;
        }

        public void push(char c) {
            datos[++top] = c;
        }

        public char pop() {
            if (isEmpty()) {
                throw new IllegalStateException("Pila vacía");
            }
            return datos[top--];
        }

        public boolean isEmpty() {
            return top == -1;
        }
    }

    /**
     * Evalúa si los paréntesis de una expresión están balanceados.
     *
     * @param expresion cadena matemática a inspeccionar
     * @return "válido" si los paréntesis están balanceados, "inválido" en caso contrario
     */
    public static String validarParentesis(String expresion) {
        if (expresion == null || expresion.isEmpty()) {
            return "válido";
        }

        PilaCaracteres pila = new PilaCaracteres(expresion.length());

        for (int i = 0; i < expresion.length(); i++) {
            char c = expresion.charAt(i);

            if (c == '(') {
                // Se apila la apertura
                pila.push(c);
            } else if (c == ')') {
                // Se intenta desapilar
                if (pila.isEmpty()) {
                    // Cierre sin apertura previa correspondiente
                    return "inválido";
                }
                pila.pop(); // Se empareja y retira la apertura correspondiente
            }
        }

        // Si la pila quedó vacía, todas las aperturas tuvieron su cierre
        return pila.isEmpty() ? "válido" : "inválido";
    }

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println(" EJERCICIO 3: VALIDAR PARÉNTESIS BALANCEADOS");
        System.out.println("==================================================\n");

        String[] expresionesPrueba = {
            "(5 + 3) * (2 + 1)",        // Ejemplo 1 de consigna -> válido
            "(5 + 3)) * (2 + 1",        // Ejemplo 2 de consigna -> inválido
            ")(",                       // Caso especial -> inválido
            "5 + 3 * 2",                // Sin paréntesis -> válido
            "((10 - 2) * (3 + (4 / 2)))", // Anidado complejo -> válido
            "((5 + 2)"                  // Apertura sin cierre -> inválido
        };

        for (int i = 0; i < expresionesPrueba.length; i++) {
            String exp = expresionesPrueba[i];
            String resultado = validarParentesis(exp);
            System.out.printf("Prueba %d:\n", (i + 1));
            System.out.printf("   Expresión: \"%s\"\n", exp);
            System.out.printf("   Resultado: %s\n\n", resultado);
        }

        System.out.println("Prueba de Ejercicio 3 completada con éxito.");
    }
}

/*
Ajustes al prompt:
Sin ajustes.
*/

