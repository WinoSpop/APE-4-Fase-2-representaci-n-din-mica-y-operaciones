package app;

import negocio.RedInicial;
import negocio.RedSocial;

/**
 * Demo de la Fase 2: ejecuta la secuencia de comprobacion de la Tabla 3 de la guia
 * sobre la red "Conexion Ambato". Sirve para sacar las capturas de los anexos.
 * Se lanza desde la opcion 10 del menu (Main).
 */
public class DemoTabla3 {

    public static void ejecutar() {
        RedSocial red = new RedSocial();

        System.out.println("=== PASO 1: registrar A01-A06 y las cinco amistades ===");
        RedInicial.cargar(red);
        System.out.println("Personas: " + red.totalPersonas() + " | amistades: " + red.totalAmistades());
        System.out.println(red.mostrarRed());
        System.out.print("Grados (A01..A06): ");
        for (int i = 1; i <= 6; i++) {
            System.out.print(red.contarAmigos("A0" + i) + (i < 6 ? ", " : ""));
        }
        System.out.println();

        System.out.println();
        System.out.println("=== PASO 2: seguir(A02, A01) ===");
        System.out.println("Resultado: " + red.seguir("A02", "A01"));
        System.out.println("seguidores(A01) = " + red.listarSeguidores("A01"));

        System.out.println();
        System.out.println("=== PASO 3: seguir(A06, A01) ===");
        System.out.println("Resultado: " + red.seguir("A06", "A01"));
        System.out.println("seguidos(A06)   = " + red.listarSeguidos("A06") + " | amigos(A06) = '"
                + red.listarAmigos("A06") + "' (Diego sigue a Sofia sin tener amigos)");
        System.out.println("seguidores(A01) = " + red.listarSeguidores("A01"));

        System.out.println();
        System.out.println("=== PASO 4: listarAmigos(A04) ===");
        System.out.println("amigos(A04) = " + red.listarAmigos("A04") + " | grado = " + red.contarAmigos("A04"));

        System.out.println();
        System.out.println("=== PASO 5: eliminarAmistad(A04, A05) ===");
        System.out.println("Resultado: " + red.eliminarAmistad("A04", "A05"));
        System.out.println("amigos(A04) = " + red.listarAmigos("A04"));
        System.out.println("amigos(A05) = '" + red.listarAmigos("A05") + "'");

        System.out.println();
        System.out.println("=== PASO 6: eliminarPersona(A01) ===");
        System.out.println("Resultado: " + red.eliminarPersona("A01"));
        System.out.println(red.mostrarRed());
        System.out.println("A01 existe: " + red.existePersona("A01"));
        System.out.println("seguidos(A02) = '" + red.listarSeguidos("A02") + "' | seguidos(A06) = '"
                + red.listarSeguidos("A06") + "'");

        System.out.println();
        System.out.println("=== PASO 7: registrarPersona(A02, otro nombre) ===");
        System.out.println("Resultado: " + red.registrarPersona("A02", "Otro nombre") + " (usuario duplicado)");

        System.out.println();
        System.out.println("=== PASO 8: agregarAmistad(A03, A03) ===");
        System.out.println("Resultado: " + red.agregarAmistad("A03", "A03") + " (lazo no permitido)");

        System.out.println();
        System.out.println("=== Estado final ===");
        System.out.println(red.mostrarRed());
        System.out.println("Personas: " + red.totalPersonas() + " | amistades: " + red.totalAmistades()
                + " | seguimientos: " + red.totalSeguimientos());
    }
}
