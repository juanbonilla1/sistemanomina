package org.sistemanomina;

import java.util.*;

class Empleado {
    String nombre;
    String tipoPago; // Quincenal o Mensual
    double salarioBase;
    double horasExtras;
    double horasNocturnas;
    double horasDominicales;
    double descuentoParafiscales;

    public Empleado(String nombre, String tipoPago, double salarioBase,
                    double horasExtras, double horasNocturnas,
                    double horasDominicales, double descuentoParafiscales) {
        this.nombre = nombre;
        this.tipoPago = tipoPago;
        this.salarioBase = salarioBase;
        this.horasExtras = horasExtras;
        this.horasNocturnas = horasNocturnas;
        this.horasDominicales = horasDominicales;
        this.descuentoParafiscales = descuentoParafiscales;
    }

    public double calcularSalarioBruto() {
        return salarioBase + (horasExtras * 1.25) + (horasNocturnas * 1.35) + (horasDominicales * 1.75);
    }

    public double calcularDeducciones() {
        double salud = salarioBase * 0.04;
        double pension = salarioBase * 0.04;
        return salud + pension + descuentoParafiscales;
    }

    public double calcularSalarioNeto() {
        return calcularSalarioBruto() - calcularDeducciones();
    }

    public void mostrarResumenPago() {
        System.out.println("\n--- Resumen de Pago ---");
        System.out.println("Empleado: " + nombre);
        System.out.println("Tipo de pago: " + tipoPago);
        System.out.println("Salario Base: $" + salarioBase);
        System.out.println("Salario Bruto: $" + calcularSalarioBruto());
        System.out.println("Deducciones Totales: $" + calcularDeducciones());
        System.out.println("Salario Neto: $" + calcularSalarioNeto());
    }
}

public class SistemaNomina {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Empleado> empleados = new ArrayList<>();

        System.out.println("=== Sistema de Nómina ===");

        while (true) {
            System.out.println("\n1. Registrar empleado");
            System.out.println("2. Ver pagos registrados");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = sc.nextInt();
            sc.nextLine(); // limpiar buffer

            if (opcion == 1) {
                System.out.print("Nombre del empleado: ");
                String nombre = sc.nextLine();

                System.out.print("Tipo de pago (Quincenal/Mensual): ");
                String tipoPago = sc.nextLine();

                System.out.print("Salario base: ");
                double salarioBase = sc.nextDouble();

                System.out.print("Horas extras: ");
                double horasExtras = sc.nextDouble();

                System.out.print("Horas nocturnas: ");
                double horasNocturnas = sc.nextDouble();

                System.out.print("Horas dominicales: ");
                double horasDominicales = sc.nextDouble();

                System.out.print("Descuento por parafiscales: ");
                double descuentoParafiscales = sc.nextDouble();

                Empleado emp = new Empleado(nombre, tipoPago, salarioBase,
                        horasExtras, horasNocturnas, horasDominicales, descuentoParafiscales);
                empleados.add(emp);
                emp.mostrarResumenPago();
            } else if (opcion == 2) {
                for (Empleado emp : empleados) {
                    emp.mostrarResumenPago();
                }
            } else if (opcion == 3) {
                System.out.println("Saliendo del sistema.");
                break;
            } else {
                System.out.println("Opción no válida.");
            }
        }

        sc.close();
    }
}