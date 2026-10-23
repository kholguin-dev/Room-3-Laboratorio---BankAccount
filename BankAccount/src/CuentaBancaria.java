public class CuentaBancaria {
    private String numeroCuenta;
    private String titular;
    private double saldo;
    private double tasaInteres;



    // Constructor
    public CuentaBancaria(String numeroCuenta, String titular, double saldoInicial, double tasaInteres) {
        this.numeroCuenta = numeroCuenta;
        this.titular = titular;

        // Validación de saldo inicial no negativo
        if (saldoInicial >= 0) {
            this.saldo = saldoInicial;
        } else {
            this.saldo = 0;
            System.out.println("Advertencia: El saldo inicial no puede ser negativo. Se ha establecido en 0.");
        }

        // Validación de tasa de interés no negativa
        if (tasaInteres >= 0) {
            this.tasaInteres = tasaInteres;
        } else {
            this.tasaInteres = 0;
            System.out.println("Advertencia: La tasa de interés no puede ser negativa. Se ha establecido en 0.");
        }

    }
    // Getters
    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public String getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public double getTasaInteres() {
        return tasaInteres;
    }


    // metodo depositar
    public void depositar(double monto) {
        if (monto > 0) {
            saldo += monto;
            System.out.println("Depósito exitoso.");
            System.out.println("Monto depositado: $" + monto);
            System.out.println("Nuevo saldo: $" + saldo);
        } else {
            System.out.println("Error: El monto a depositar debe ser positivo.");
        }
    }
}
