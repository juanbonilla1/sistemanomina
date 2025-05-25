package org.sistemanomina;

import java.util.*;

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

            switch (opcion) {
                case 1 -> {
                    System.out.print("Nombre del empleado: ");
                    String nombre = sc.nextLine();

                    System.out.print("Cédula: ");
                    String cedula = sc.nextLine();

                    System.out.print("Edad: ");
                    int edad = sc.nextInt();

                    sc.nextLine(); // limpiar buffer
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

                    Empleado emp = new Empleado(nombre, cedula, edad, tipoPago, salarioBase,
                            horasExtras, horasNocturnas, horasDominicales, descuentoParafiscales);
                    empleados.add(emp);
                    emp.mostrarResumenPago();
                }
                case 2 -> {
                    if (empleados.isEmpty()) {
                        System.out.println("No hay empleados registrados.");
                    } else {
                        empleados.forEach(Empleado::mostrarResumenPago);
                    }
                }
                case 3 -> {
                    System.out.println("Saliendo del sistema.");
                    sc.close();
                    return;
                }
                default -> System.out.println("Opción no válida.");
            }
        }
    }
}
