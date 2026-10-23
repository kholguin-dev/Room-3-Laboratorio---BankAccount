public class CuentaCorriente extends CuentaBancaria {

    private double limiteSobregiro;
    private double porcentajeComisionSobregiro;

    // Builder
    public CuentaCorriente(String numeroCuenta, String titular, double saldoInicial,
                           double limiteSobregiro, double porcentajeComisionSobregiro) {
        super(numeroCuenta, titular, saldoInicial, 0.0);
        this.limiteSobregiro = limiteSobregiro;
        this.porcentajeComisionSobregiro = porcentajeComisionSobregiro;
    }

    // Sobrecarga de Buider ¿por que? por que si
    public CuentaCorriente(String numeroCuenta, String titular, double saldoInicial) {
        this(numeroCuenta, titular, saldoInicial, 50000.0, 5.0);
    }

    public double getLimiteSobregiro() {
        return limiteSobregiro;
    }

    public double getPorcentajeComisionSobregiro() {
        return porcentajeComisionSobregiro;
    }

    // Implementación del método abstracto retirar
    @Override
    public void retirar(double monto) {
        if (monto > (getSaldo() + limiteSobregiro)) {
            System.out.println("Error: El retiro de $" + String.format("%.2f", monto)
                    + " excede el límite de sobregiro disponible.");
            return;
        }

        setSaldo(getSaldo() - monto);
        System.out.println("Retiro exitoso por $" + String.format("%.2f", monto));

        if (getSaldo() < 0) {
            double montoSobregirado = Math.abs(getSaldo());
            double comision = montoSobregirado * (porcentajeComisionSobregiro / 100.0);

            setSaldo(getSaldo() - comision);

            System.out.println("Comisión por sobregiro (" + porcentajeComisionSobregiro + "%): $"
                    + String.format("%.2f", comision));
        }

        System.out.println("Nuevo saldo: $" + String.format("%.2f", getSaldo()));
    }

    @Override
    public void mostrarInfo() {
        super.mostrarInfo();
        System.out.println("Límite de Sobregiro: $" + String.format("%.2f", limiteSobregiro));
        System.out.println("Porcentaje Comisión Sobregiro: " + porcentajeComisionSobregiro + "%");
    }
}