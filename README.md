# Estructuras-y-Algoritmos--2026
Repositorio de trabajos de Estructuras de datos y algoritmos.

[![CI](https://github.com/Rodrigopalacio-23/Estructuras-y-Algoritmos--2026/actions/workflows/ci.yml/badge.svg)](https://github.com/Rodrigopalacio-23/Estructuras-y-Algoritmos--2026/actions/workflows/ci.yml)

---

## Agentes y prompts

Las reglas y prompts canónicos del proyecto se han centralizado en:

- [`.github/agents/AGENTS.md`](.github/agents/AGENTS.md)
- [`.github/prompts/README_PROMPTS.md`](.github/prompts/README_PROMPTS.md)

Consulta esos archivos para obtener las plantillas de prompts, guías de comportamiento y los prompts reutilizables para los agentes del repositorio.

---

## Cómo compilar y ejecutar los ejemplos

Los ejemplos Java incluidos están en la carpeta `Clases Estructura y Algoritmo`. Puede compilarlos y ejecutarlos desde la línea de comandos:

Linux/macOS:

```bash
# Ruta recomendada: `src/main/java` con paquete `com.example.algoritmos`.

# Compilar y ejecutar con javac
javac -d out src/main/java/com/example/algoritmos/Clase.java src/main/java/com/example/algoritmos/HolaMundo.java
java -cp out com.example.algoritmos.Clase
echo "---"
java -cp out com.example.algoritmos.HolaMundo

# Con Maven (si está instalado):
# mvn package
# java -cp target/estructuras-algoritmos-0.1.0-SNAPSHOT.jar com.example.algoritmos.Clase
```

Nota: las rutas con espacios pueden requerir comillas. Se recomienda usar la estructura `src/main/java` y declarar paquetes para evitar problemas.
# StudyPath
