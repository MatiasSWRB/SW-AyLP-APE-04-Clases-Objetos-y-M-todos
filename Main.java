
// ============================================================
// Archivo: Main.java
// ============================================================

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int totalEstudiantes = 5;
        Estudiante[] lista = new Estudiante[totalEstudiantes];

        // ── Registro de estudiantes ──────────────────────────
        for (int i = 0; i < totalEstudiantes; i++) {
            System.out.println("\n--- Ingrese datos del estudiante " + (i+1) + " ---");
            System.out.print("Cédula   : "); String cedula = sc.next();
            System.out.print("Nombre   : "); String nombre = sc.next();
            System.out.print("Apellido : "); String apellido = sc.next();
            System.out.print("Nota 1 (0-10): "); double n1 = sc.nextDouble();
            System.out.print("Nota 2 (0-10): "); double n2 = sc.nextDouble();
            System.out.print("Nota 3 (0-10): "); double n3 = sc.nextDouble();
            lista[i] = new Estudiante(cedula, nombre, apellido, n1, n2, n3);
        }

        // ── Listado completo ────────────────────────────────
        int aprobados = 0, reprobados = 0;
        System.out.println("\n====== LISTADO DE ESTUDIANTES ======");
        for (Estudiante e : lista) {
            e.mostrarInformacion();
            if (e.obtenerEstado().equals("APROBADO")) aprobados++;
            else reprobados++;
        }

        // ── Resumen ─────────────────────────────────────────
        System.out.println("\nTotal aprobados  : " + aprobados);
        System.out.println("Total reprobados : " + reprobados);
        sc.close();
    }
}

