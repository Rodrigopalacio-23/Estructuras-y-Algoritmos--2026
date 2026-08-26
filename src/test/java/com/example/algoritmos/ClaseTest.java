package com.example.algoritmos;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ClaseTest {

    @Test
    void mainPrintsGreeting() {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
        try {
            Clase.main(new String[0]);
            String out = baos.toString().trim();
            // strict assertion: Clase.main() should print exactly "Hola desde Clase"
            org.junit.jupiter.api.Assertions.assertEquals("Hola desde Clase", out);
        } finally {
            System.setOut(originalOut);
        }
    }
}
