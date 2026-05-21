// ============================================================
// Archivo: main.cpp
// APE-04: Clases, Objetos y Métodos
// Asignatura: Algoritmos y Lógica de Programación – UTA
// ============================================================

#include <iostream>
#include <string>
#include <iomanip>
using namespace std;

// ── Clase Estudiante ─────────────────────────────────────────
class Estudiante {
private:
    string cedula;
    string nombre;
    string apellido;
    double nota1, nota2, nota3;
    double promedio;

    // Validar que la nota esté entre 0 y 10
    double validarNota(double nota) {
        if (nota < 0 || nota > 10) {
            cout << "Nota invalida. Se asigna 0." << endl;
            return 0;
        }
        return nota;
    }

public:
    // ── Constructor ─────────────────────────────────────────
    Estudiante(string ced, string nom, string ape,
               double n1, double n2, double n3) {
        cedula   = ced;
        nombre   = nom;
        apellido = ape;
        nota1    = validarNota(n1);
        nota2    = validarNota(n2);
        nota3    = validarNota(n3);
        promedio = calcularPromedio();
    }

    // ── Calcular promedio ────────────────────────────────────
    double calcularPromedio() {
        return (nota1 + nota2 + nota3) / 3.0;
    }

    // ── Determinar estado ────────────────────────────────────
    string obtenerEstado() {
        return (promedio >= 7.0) ? "APROBADO" : "REPROBADO";
    }

    // ── Mostrar información ──────────────────────────────────
    void mostrarInformacion() {
        cout << "================================" << endl;
        cout << "Cedula   : " << cedula << endl;
        cout << "Nombre   : " << nombre << " " << apellido << endl;
        cout << fixed << setprecision(2);
        cout << "Nota 1   : " << nota1 << endl;
        cout << "Nota 2   : " << nota2 << endl;
        cout << "Nota 3   : " << nota3 << endl;
        cout << "Promedio : " << promedio << endl;
        cout << "Estado   : " << obtenerEstado() << endl;
        cout << "================================" << endl;
    }

    // ── Getters ──────────────────────────────────────────────
    string getCedula()   { return cedula; }
    string getNombre()   { return nombre; }
    string getApellido() { return apellido; }
    double getPromedio() { return promedio; }
    string getEstado()   { return obtenerEstado(); }

    // ── Setters ──────────────────────────────────────────────
    void setCedula(string c)   { cedula = c; }
    void setNombre(string n)   { nombre = n; }
    void setApellido(string a) { apellido = a; }
};

// ── Función principal ─────────────────────────────────────────
int main() {
    const int TOTAL = 5;
    Estudiante* lista[TOTAL];
    string ced, nom, ape;
    double n1, n2, n3;

    // Registro de estudiantes
    for (int i = 0; i < TOTAL; i++) {
        cout << "\n--- Ingrese datos del estudiante " << (i+1) << " ---" << endl;
        cout << "Cedula   : "; cin >> ced;
        cout << "Nombre   : "; cin >> nom;
        cout << "Apellido : "; cin >> ape;
        cout << "Nota 1 (0-10): "; cin >> n1;
        cout << "Nota 2 (0-10): "; cin >> n2;
        cout << "Nota 3 (0-10): "; cin >> n3;
        lista[i] = new Estudiante(ced, nom, ape, n1, n2, n3);
    }

    // Mostrar listado y conteo
    int aprobados = 0, reprobados = 0;
    cout << "\n====== LISTADO DE ESTUDIANTES ======" << endl;
    for (int i = 0; i < TOTAL; i++) {
        lista[i]->mostrarInformacion();
        if (lista[i]->getEstado() == "APROBADO") aprobados++;
        else reprobados++;
        delete lista[i];
    }

    cout << "\nTotal aprobados  : " << aprobados << endl;
    cout << "Total reprobados : " << reprobados << endl;
    return 0;
}
