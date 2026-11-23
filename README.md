# APE 4 · Fase 2 · Conexión Ambato (red social con grafo dinámico)

Estructura de Datos, 3.er semestre de Software, FISEI-UTA. Docente: Ing. José Caiza, Mg.

**Integrantes:** (completar con apellidos y nombres, orden alfabético)

## Cómo ejecutarlo

Necesitas Java 11 o superior y VS Code con la extensión **Extension Pack for Java**.

1. Abre la **carpeta del proyecto** en VS Code (`Archivo > Abrir carpeta`, la que contiene `src`).
2. Abre `src/app/Main.java` y dale a **Run** (el botón de arriba a la derecha, o *Run* sobre el `main`).
   Si usas **Code Runner**, también funciona con *Run Code*: la configuración está en `.vscode/settings.json`.
3. Se abre el menú en la terminal. Con la opción **9** cargas la red inicial, con la **10** corres la secuencia
   de la Tabla 3 y con la **11** las pruebas automatizadas (deben terminar en `79/79 pruebas OK`).

Por consola: `javac -encoding UTF-8 -sourcepath src -d out src/app/Main.java` y `java -cp out app.Main`.

## Estructura

```
src/
  enums/    TipoRelacion.java       AMISTAD y SEGUIR
  modelo/   Persona, Vertice, Arista   nodos propios de la multilista
  negocio/  RedSocial.java          todas las operaciones
            RedInicial.java         carga de la red de la Fase 1 (A01-A06)
  app/      Main.java               punto de entrada: abre el menú
            Menu.java               menú interactivo por terminal
            DemoTabla3.java         secuencia de la Tabla 3 (para las capturas)
  pruebas/  PruebasRedSocial.java   pruebas sin JUnit
```

Las capas van en un solo sentido: `app -> negocio -> modelo -> enums`.

## Modelo

Multilista: la lista de personas (vértices) y, colgada de cada una, su lista de relaciones (aristas).

- **Amistad:** recíproca, se guarda como dos aristas `AMISTAD`.
- **Seguir:** dirigida, una sola arista `SEGUIR`.
- Sin lazos ni relaciones repetidas del mismo tipo. El usuario no distingue mayúsculas (`A01` = `a01`).
- Sin `HashMap`, `HashSet`, `ArrayList` ni `LinkedList`: todo con nodos enlazados.

## Menú

1 Registrar · 2 Eliminar persona · 3 Crear amistad · 4 Eliminar amistad · 5 Seguir · 6 Dejar de seguir · 7 Listar vecinos · 8 Mostrar red · 9 Cargar red inicial (A01-A06) · 10 Demo de la Tabla 3 · 11 Pruebas · 0 Salir

## Costos

| Operación | Costo |
|---|---|
| buscar / registrarPersona | O(V) |
| agregarAmistad / seguir / eliminarAmistad / dejarDeSeguir | O(V + grado) |
| eliminarPersona | O(V + A) |
| listarAmigos / listarSeguidos / contarAmigos | O(V + grado) |
| listarSeguidores / mostrarRed | O(V + A) |
