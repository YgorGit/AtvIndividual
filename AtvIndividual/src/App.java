import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        // Inicializando o banco
        Banco banco = new Banco();

        // Criando lojas
        Loja loja1 = new Loja("Loja 1", new Conta(0));
        Loja loja2 = new Loja("Loja 2", new Conta(0));

        // Criando funcionários (como threads)
        Funcionario funcionario1 = new Funcionario("Funcionario 1", 1400, new Conta(0), new Conta(0));
        Funcionario funcionario2 = new Funcionario("Funcionario 2", 1400, new Conta(0), new Conta(0));
        Funcionario funcionario3 = new Funcionario("Funcionario 3", 1400, new Conta(0), new Conta(0));
        Funcionario funcionario4 = new Funcionario("Funcionario 4", 1400, new Conta(0), new Conta(0));

        // Adicionando funcionários às lojas
        loja1.contratarFuncionario(funcionario1);
        loja1.contratarFuncionario(funcionario2);
        loja2.contratarFuncionario(funcionario3);
        loja2.contratarFuncionario(funcionario4);

        // Criando clientes
        List<Loja> lojas = new ArrayList<>();
        lojas.add(loja1);
        lojas.add(loja2);

        List<Cliente> clientes = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            Cliente cliente = new Cliente("Cliente " + i, new Conta(2000), lojas, banco);
            banco.adicionarCliente(cliente);
            clientes.add(cliente); // Adicionando clientes para revisão posterior
        }

        // Processando transações
        banco.processarTransacoes();

        // **Disparar as threads para os funcionários**
        funcionario1.start();
        funcionario2.start();
        funcionario3.start();
        funcionario4.start();

        // Exibindo os saldos finais
        exibirSaldos(loja1, loja2, funcionario1, funcionario2, funcionario3, funcionario4, clientes);
    }

    public static void exibirSaldos(Loja loja1, Loja loja2, Funcionario funcionario1, Funcionario funcionario2, Funcionario funcionario3, Funcionario funcionario4, List<Cliente> clientes) {
        // Exibindo saldos finais das lojas
        System.out.println("Saldo final das lojas:");
        System.out.println(loja1.getNome() + ": R$ " + loja1.getConta().getSaldo());
        System.out.println(loja2.getNome() + ": R$ " + loja2.getConta().getSaldo());
    
        // Exibindo saldo final dos funcionários
        System.out.println("Saldo final dos funcionários:");
        System.out.println(funcionario1.getNome() + ": Conta Salário: R$ " + funcionario1.getContaSalario().getSaldo()
            + ", Conta Investimento: R$ " + funcionario1.getContaInvestimento().getSaldo());
        System.out.println(funcionario2.getNome() + ": Conta Salário: R$ " + funcionario2.getContaSalario().getSaldo()
            + ", Conta Investimento: R$ " + funcionario2.getContaInvestimento().getSaldo());
        System.out.println(funcionario3.getNome() + ": Conta Salário: R$ " + funcionario3.getContaSalario().getSaldo()
            + ", Conta Investimento: R$ " + funcionario3.getContaInvestimento().getSaldo());
        System.out.println(funcionario4.getNome() + ": Conta Salário: R$ " + funcionario4.getContaSalario().getSaldo()
            + ", Conta Investimento: R$ " + funcionario4.getContaInvestimento().getSaldo());
    
        // Exibindo saldo final dos clientes
        System.out.println("\nSaldo final dos clientes:");
        for (Cliente cliente : clientes) {
            System.out.println(cliente.getNome() + ": Conta Saldo: R$ " + cliente.getConta().getSaldo());
        }
    }
    
}
