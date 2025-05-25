package org.sistemanomina;

public class Empleado extends Persona {
    private String tipoPago;
    private double salarioBase;
    private double horasExtras;
    private double horasNocturnas;
    private double horasDominicales;
    private double descuentoParafiscales;

    public Empleado(String nombre, String cedula, int edad, String tipoPago, double salarioBase,
                    double horasExtras, double horasNocturnas,
                    double horasDominicales, double descuentoParafiscales) {
        super(nombre, cedula, edad);
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
        System.out.println("Nombre: " + getNombre());
        System.out.println("Cédula: " + getCedula());
        System.out.println("Edad: " + getEdad());
        System.out.println("Tipo de pago: " + tipoPago);
        System.out.println("Salario Base: $" + salarioBase);
        System.out.println("Salario Bruto: $" + calcularSalarioBruto());
        System.out.println("Deducciones Totales: $" + calcularDeducciones());
        System.out.println("Salario Neto: $" + calcularSalarioNeto());
    }
}
