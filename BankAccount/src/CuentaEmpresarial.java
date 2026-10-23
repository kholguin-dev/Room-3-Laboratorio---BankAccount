public class CuentaEmpresarial extends CuentaBancaria {
    private String nombreEmpresa;
    private String RUT;
    private double comisionRetiro = 2000;


    public CuentaEmpresarial(String numeroCuenta, String titular, double saldoInicial, String nombreEmpresa, String RUT) {
        super(numeroCuenta, titular, saldoInicial, 1.5);
        if (saldoInicial < 100000) {
            throw new IllegalArgumentException("Saldo inicial menor al minimo");
        }
        this.nombreEmpresa = nombreEmpresa;
        this.RUT = RUT;
    }


    @Override
    public void retirar(double monto) {
        if (monto + comisionRetiro > getSaldo()) {
            System.out.println("Saldo insuficiente");
            return;
        }
        // "Saldo" no esta registrado nuevamente es actualizarSaldo y validar la operacion se reemplaza -=monto + comisionRetiro
        actualizarSaldo(getSaldo() - monto - comisionRetiro);
        System.out.println("Retiro exitoso");
        System.out.println("Comision por retiro: $" + comisionRetiro);
        System.out.println("Nuevo saldo: $" + getSaldo());
    }


    @Override
    public void mostrarInfo() {
        super.mostrarInfo();
        System.out.println("Empresa: " + nombreEmpresa);
        System.out.println("RUT: " + RUT);
    }
}
