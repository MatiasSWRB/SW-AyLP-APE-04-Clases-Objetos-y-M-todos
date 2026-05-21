
// ============================================================
// Archivo: Estudiante.java
// APE-04: Clases, Objetos y Métodos
// Asignatura: Algoritmos y Lógica de Programación – UTA
// ============================================================

public class Estudiante {
    // ── Atributos privados ──────────────────────────────────
    private String cedula;
    private String nombre;
    private String apellido;
    private double nota1;
    private double nota2;
    private double nota3;
    private double promedio;

    // ── Constructor ─────────────────────────────────────────
    public Estudiante(String cedula, String nombre, String apellido,
                      double nota1, double nota2, double nota3) {
        this.cedula   = cedula;
        this.nombre   = nombre;
        this.apellido = apellido;
        this.nota1    = validarNota(nota1);
        this.nota2    = validarNota(nota2);
        this.nota3    = validarNota(nota3);
        this.promedio = calcularPromedio();
    }

    // ── Método de validación ─────────────────────────────────
    private double validarNota(double nota) {
        if (nota < 0 || nota > 10) {
            System.out.println("Nota inválida. Se asignará 0.");
            return 0;
        }
        return nota;
    }

    // ── Método calcular promedio ─────────────────────────────
    public double calcularPromedio() {
        return (nota1 + nota2 + nota3) / 3.0;
    }

    // ── Método determinar estado ─────────────────────────────
    public String obtenerEstado() {
        return (promedio >= 7.0) ? "APROBADO" : "REPROBADO";
    }

    // ── Método mostrar información ───────────────────────────
    public void mostrarInformacion() {
        System.out.println("================================");
        System.out.println("Cédula   : " + cedula);
        System.out.println("Nombre   : " + nombre + " " + apellido);
        System.out.printf ("Nota 1   : %.2f%n", nota1);
        System.out.printf ("Nota 2   : %.2f%n", nota2);
        System.out.printf ("Nota 3   : %.2f%n", nota3);
        System.out.printf ("Promedio : %.2f%n", promedio);
        System.out.println("Estado   : " + obtenerEstado());
        System.out.println("================================");
    }

    // ── Getters y Setters ────────────────────────────────────
    public String getCedula()   { return cedula; }
    public String getNombre()   { return nombre; }
    public String getApellido() { return apellido; }
    public double getNota1()    { return nota1; }
    public double getNota2()    { return nota2; }
    public double getNota3()    { return nota3; }
    public double getPromedio() { return promedio; }

    public void setCedula(String cedula)     { this.cedula = cedula; }
    public void setNombre(String nombre)     { this.nombre = nombre; }
    public void setApellido(String apellido) { this.apellido = apellido; }
}
