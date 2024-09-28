import java.util.ArrayList;
import java.util.List;

class Banco {
    private List<Cliente> clientes;

    public Banco() {
        this.clientes = new ArrayList<>();
    }

    // Método para adicionar clientes ao banco
    public void adicionarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    // Método sincronizado para garantir consistência nas transações
    public synchronized void transferir(Conta origem, Conta destino, double valor) {
        // Verifica se a conta de origem tem saldo suficiente
        if (origem.getSaldo() >= valor) {
            origem.sacar(valor);   // Realiza o saque na conta de origem
            destino.depositar(valor);  // Deposita o valor na conta de destino
            System.out.println("Transferência de R$ " + valor + " realizada com sucesso.");
        } else {
            System.out.println("Saldo insuficiente na conta de " + origem + " para realizar a transferência de R$ " + valor);
        }
    }

    // Método para processar as transações de cada cliente
    public void processarTransacoes() {
        // Inicia todas as threads de clientes
        for (Cliente cliente : clientes) {
            cliente.start();
        }

        // Espera que todas as threads terminem
        for (Cliente cliente : clientes) {
            try {
                cliente.join();  // Garante que o main espere todas as threads de clientes
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
