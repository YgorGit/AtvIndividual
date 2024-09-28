class Conta {
    private double saldo;

    public Conta(double saldoInicial) {
        this.saldo = saldoInicial;
    }

    public synchronized void depositar(double valor) {
        saldo += valor;
    }

    public synchronized void sacar(double valor) {
        if (saldo >= valor) {
            saldo -= valor;
        } else {
            System.out.println("Saldo insuficiente para realizar a operação.");
        }
    }

    public double getSaldo() {
        return saldo;
    }
}