public class TestBanco {

    public static void main(String[] args) {


        System.out.println("====== PASO 1: CREACIÓN DE CUENTAS ======");

        CuentaAhorro cuentaAna = new CuentaAhorro("AH001", "Ana Perez", 50000.0, "2024-01-15");

        CuentaCorriente cuentaLuis = new CuentaCorriente("CC001", "Luis Gomez", 20000.0);

        CuentaEmpresarial cuentaTech = new CuentaEmpresarial("EM001", "Tech Solutions", 200000.0, "Tech Solutions", "123456789-0");

        CuentaAhorro cuentaMaria = new CuentaAhorro("AH002", "Maria Lopez", 15000.0, "2024-02-01");

        System.out.println("Las 4 cuentas han sido creadas con éxito.\n");



        System.out.println("====== PASO 2: INFORMACIÓN INICIAL DE LAS CUENTAS ======");

        System.out.println("--- Cuenta 1 ---");
        cuentaAna.mostrarInfo();
        System.out.println("\n--- Cuenta 2 ---");
        cuentaLuis.mostrarInfo();
        System.out.println("\n--- Cuenta 3 ---");
        cuentaTech.mostrarInfo();
        System.out.println("\n--- Cuenta 4 ---");
        cuentaMaria.mostrarInfo();
        System.out.println();


        System.out.println("====== PASO 3: REALIZACIÓN DE OPERACIONES ======");

        // 1. Ana Perez deposita $10,000
        System.out.println("\n--> Operación 1: Ana Perez deposita $10,000");
        cuentaAna.depositar(10000.0);

        // 2. Luis Gomez retira $25,000 (Entra en sobregiro y cobra comisión del 5%)
        System.out.println("\n--> Operación 2: Luis Gomez retira $25,000");
        cuentaLuis.retirar(25000.0);

        // 3. Tech Solutions retira $10,000 (Aplica comisión por retiro de $2,000)
        System.out.println("\n--> Operación 3: Tech Solutions retira $10,000");
        cuentaTech.retirar(10000.0);

        // 4. Maria Lopez intenta retirar $20,000 (Debe fallar por saldo insuficiente)
        System.out.println("\n--> Operación 4: Maria Lopez intenta retirar $20,000");
        cuentaMaria.retirar(20000.0);
        System.out.println();



        System.out.println("====== PASO 4: APLICACIÓN DE INTERESES ======");

        System.out.print("Cuenta Ana: ");
        cuentaAna.aplicarInteres();

        System.out.print("Cuenta Luis: ");
        cuentaLuis.aplicarInteres();

        System.out.print("Cuenta Tech: ");
        cuentaTech.aplicarInteres();

        System.out.print("Cuenta Maria: ");
        cuentaMaria.aplicarInteres();
        System.out.println();


        System.out.println("====== PASO 5: ESTADO FINAL DE LAS CUENTAS ======");

        System.out.println("--- Cuenta 1 (Ana) ---");
        cuentaAna.mostrarInfo();
        System.out.println("\n--- Cuenta 2 (Luis) ---");
        cuentaLuis.mostrarInfo();
        System.out.println("\n--- Cuenta 3 (Tech) ---");
        cuentaTech.mostrarInfo();
        System.out.println("\n--- Cuenta 4 (Maria) ---");
        cuentaMaria.mostrarInfo();
        System.out.println();



        System.out.println("====== PASO 6: RESUMEN GENERAL ======");

        int totalCuentas = 4;

        double saldoTotal = cuentaAna.getSaldo() + cuentaLuis.getSaldo() + cuentaTech.getSaldo() + cuentaMaria.getSaldo();
        double promedioSaldo = saldoTotal / totalCuentas;

        CuentaBancaria cuentaMayor = cuentaAna;

        if (cuentaLuis.getSaldo() > cuentaMayor.getSaldo()) {
            cuentaMayor = cuentaLuis;
        }
        if (cuentaTech.getSaldo() > cuentaMayor.getSaldo()) {
            cuentaMayor = cuentaTech;
        }
        if (cuentaMaria.getSaldo() > cuentaMayor.getSaldo()) {
            cuentaMayor = cuentaMaria;
        }

        System.out.println("Total de cuentas: " + totalCuentas);
        System.out.println("Saldo total acumulado: $" + String.format("%.2f", saldoTotal));
        System.out.println("Promedio de saldo: $" + String.format("%.2f", promedioSaldo));
        System.out.println("Cuenta con mayor saldo:");
        System.out.println("  - Número de Cuenta: " + cuentaMayor.getNumeroCuenta());
        System.out.println("  - Titular: " + cuentaMayor.getTitular());
        System.out.println("  - Saldo: $" + String.format("%.2f", cuentaMayor.getSaldo()));
    }
}