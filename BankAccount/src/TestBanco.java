public class TestBanco {

    public static void main(String[] args) {

        // Cuentas de bancarias con la info del laboratorio
        CuentaAhorro cuentaAna = new CuentaAhorro("AH001", "Ana Perez", 50000, "2024-01-15");
        CuentaAhorro cuentaMaria = new CuentaAhorro("AH002", "Maria Lopez", 15000, "2024-02-01");
        // CuentaCorriente cuentaLuis

        // CuentaEmpresarial cuentaTech

        // Debe mostrar informacion inicial
        System.out.println("---------- INFORMACION INICIAL ----------");
        cuentaAna.mostrarInfo();
        System.out.println();
        cuentaMaria.mostrarInfo();
        System.out.println();

        // Operacion para mostrar saldo
        System.out.println("---------- OPERACIONES ----------");
        cuentaAna.depositar(10000);
        System.out.println();
        cuentaMaria.retirar(20000);
        System.out.println();

       //Aqui se debe validar 
        try {
            CuentaAhorro cuentaInvalida = new CuentaAhorro("AH999", "Prueba", 5000, "2024-03-01");
        } catch (IllegalArgumentException e) {
            System.out.println("No se pudo crear la cuenta: " + e.getMessage());
        }
    }
}