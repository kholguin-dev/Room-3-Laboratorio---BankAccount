public class TestBanco {
//Rectificar que si funcione por favor
    public static void main(String[] args) {

        // Cuentas de bancarias con la info del laboratorio
        CuentaAhorro cuentaAna = new CuentaAhorro("AH001", "Ana Perez", 50000, "2024-01-15");
        CuentaAhorro cuentaMaria = new CuentaAhorro("AH002", "Maria Lopez", 15000, "2024-02-01");
        // CuentaCorriente cuentaLuis
        CuentaCorriente cuentaLuis = new CuentaCorriente("CC001", "Luis Gomez", 20000);

        // CuentaEmpresarial cuentaTech
        CuentaEmpresarial cuentaTech = new CuentaEmpresarial("EM001", "Tech Solutions", 200000, "Tech Solutions", "123456789-0");
        
        
        // Debe mostrar informacion inicial
        System.out.println(" INFORMACION INICIAL ");
        mostrarTodas(cuentaAna, cuentaLuis, cuentaTech, cuentaMaria);

        // Operacion para mostrar saldo (se cambia el orden segun lo informa el lab)
        System.out.println(" OPERACIONES ");

        System.out.println(">> Ana Perez deposita $10.000");
        cuentaAna.depositar(10000);

        System.out.println(">> Luis Gomez retira $25.000");
        cuentaLuis.retirar(25000);

        System.out.println(">> Tech Solutions retira $10.000");
        cuentaTech.retirar(10000);

        System.out.println(">> Maria Lopez intenta retirar $20.000");
        cuentaMaria.retirar(20000);



        // Aplicar intereses
        System.out.println(" INTERESES ");

        cuentaAna.aplicarInteres();
        System.out.println();
        cuentaLuis.aplicarInteres();
        System.out.println();
        cuentaTech.aplicarInteres();
        System.out.println();
        cuentaMaria.aplicarInteres();
        System.out.println();


        // Resultado final
        System.out.println(" ESTADO FINAL ");

        cuentaAna.mostrarInfo();
        System.out.println();
        cuentaLuis.mostrarInfo();
        System.out.println();
        cuentaTech.mostrarInfo();
        System.out.println();
        cuentaMaria.mostrarInfo();
        System.out.println();

        double total = cuentaAna.getSaldo() + cuentaLuis.getSaldo() + cuentaTech.getSaldo() + cuentaMaria.getSaldo();
        // del tipo padre se saca la informacion 
        CuentaBancaria mayor = cuentaAna; 
        if (cuentaLuis.getSaldo() > mayor.getSaldo()) mayor = cuentaLuis;
        if (cuentaTech.getSaldo() > mayor.getSaldo()) mayor = cuentaTech;
        if (cuentaMaria.getSaldo() > mayor.getSaldo()) mayor = cuentaMaria;

        System.out.println(" RESUMEN RESULTADO DE CUENTAS ");
        System.out.println("Total de cuentas: 4");
        // se maneja String.formt para formatear los valores monetarios con dos decimales
        System.out.println("Saldo total: $" + String.format("%.2f", total));
        System.out.println("Promedio de saldo: $" + String.format("%.2f", total / 4));
        System.out.println("Mayor saldo: " + mayor.getNumeroCuenta() + " - " + mayor.getTitular()
                + " - $" + String.format("%.2f", mayor.getSaldo()));
    }

    // Evita repetir informacion por m edio de polimorfismo cada cuenta usa su propia version bajo parametros de los argunmentos brindados
    private static void mostrarTodas(CuentaBancaria c1, CuentaBancaria c2,CuentaBancaria c3, CuentaBancaria c4) {
        c1.mostrarInfo();
        System.out.println();
        c2.mostrarInfo();
        System.out.println();
        c3.mostrarInfo();
        System.out.println();
        c4.mostrarInfo();
        System.out.println();
    
    }
}