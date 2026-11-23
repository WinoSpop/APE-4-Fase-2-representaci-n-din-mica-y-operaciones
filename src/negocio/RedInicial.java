package negocio;

/**
 * Red de la Fase 1 de "Conexion Ambato" (Tabla 1 de la guia):
 * 6 usuarios (A01 a A06) y 5 amistades reciprocas.
 */
public class RedInicial {

    /**
     * Carga los 6 usuarios y las 5 amistades en la red recibida.
     * Los usuarios se registran en orden A01..A06 (por eso la lista queda
     * a06 -> a05 -> a04 -> a03 -> a02 -> a01, porque se inserta al inicio).
     * Las amistades se crean en un orden que deja cada lista de amigos igual a la Tabla 1:
     * Sofia: Mateo, Andres | Mateo: Sofia, Valeria | Valeria: Mateo, Andres |
     * Andres: Valeria, Sofia, Camila | Camila: Andres | Diego: ninguno.
     */
    public static void cargar(RedSocial red) {
        red.registrarPersona("A01", "Sofía");
        red.registrarPersona("A02", "Mateo");
        red.registrarPersona("A03", "Valeria");
        red.registrarPersona("A04", "Andrés");
        red.registrarPersona("A05", "Camila");
        red.registrarPersona("A06", "Diego");

        red.agregarAmistad("A04", "A05");
        red.agregarAmistad("A04", "A01");
        red.agregarAmistad("A03", "A04");
        red.agregarAmistad("A02", "A03");
        red.agregarAmistad("A01", "A02");
    }
}
