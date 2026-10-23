public class CuentaAhoro extends CuentaBancaria{
    private String fechaApertura;

    private static final double TASA_INTERES = 2.5,
    private static final double SALDO_MINIMO = 10000.0;

    //Constructor
    public CuentaAhorro(String numeroCuenta, String titular, double saldoInicial, String fechaApertura) {
        super(numeroCuenta, titular, saldoInicial, TASA_INTERES);
        if (saldoInicial < SALDO_MINIMO) {
            throw new IllegalArgumentException("El saldo inicial debe ser de por lo menos $10.000.");
        }
        this.fechaApertura = fechaApertura;
    }

    public String getFechaApertura() {
        return fechaApertura;
    }

    @Override
    public void retirar(double monto){
        if (monto <= 0){
            System.out.println("Error: monto inválido");
        }else if (monto > getSaldo()){
            System.out.println("Error: saldo insuficiente");
        }else{
            double nuevoSaldo = getSaldo() - monto;
            actualizarSaldo(nuevoSaldo);

            System.out.println("Retiro exitoso.");
            System.out.println("Monto retirado: $" +
                    String.format("%.2f", monto));
            System.out.println("Nuevo saldo: $" +
                    String.format("%.2f", getSaldo()));
        }
    }

    @Override
    public void mostrarInfo(){
        super.mostrarInfo();
        System.out.println("Fecha de apertura: " + fechaApertura);
    }


}
