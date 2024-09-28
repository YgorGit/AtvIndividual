import java.util.ArrayList;
import java.util.List;

class Loja {
    private String nome;
    private Conta conta;
    private List<Funcionario> funcionarios;

    public Loja(String nome, Conta conta) {
        this.nome = nome;
        this.conta = conta;
        this.funcionarios = new ArrayList<>();
    }

    public void contratarFuncionario(Funcionario funcionario) {
        funcionarios.add(funcionario);
    }

    public void receberPagamento(double valor) {
        conta.depositar(valor);
        System.out.println("Loja " + nome + " recebeu pagamento de R$ " + valor + ". Saldo atual: R$ " + conta.getSaldo());
        pagarFuncionarios();  // Tenta pagar os funcionários após receber cada pagamento
    }

    public void pagarFuncionarios() {
        for (Funcionario funcionario : funcionarios) {
            // Verifica se há saldo suficiente para pagar um funcionário
            if (conta.getSaldo() >= 1400) {
                conta.sacar(1400);  // Deduz o valor do salário da conta da loja
                funcionario.start();  // Chama o método start() para iniciar a thread que paga o salário
                System.out.println("Funcionário " + funcionario.getNome() + " está recebendo o salário.");
            } else {
                System.out.println("Saldo insuficiente para pagar " + funcionario.getNome() + ". Saldo atual: R$ " + conta.getSaldo());
            }
        }
    }

    public Conta getConta() {
        return conta;
    }

    public String getNome() {
        return nome;
    }
}
